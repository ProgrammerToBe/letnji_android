package task.commander.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import task.commander.dto.GroupDTO;
import task.commander.model.TaskGroup;
import task.commander.model.User;
import task.commander.service.TaskGroupService;

@Controller
@RequestMapping(value="/task_group")
public class TaskGroupController {
	
	@Autowired
	TaskGroupService taskGroupService;
	
	@RequestMapping(
			value = "/create",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskGroup> createTaskGroup(@RequestBody GroupDTO groupDTO , HttpServletRequest request) throws Exception {
		
		System.out.println("---------------------------PRAVIM GRUPU---------------------------");
		TaskGroup taskGroup = taskGroupService.create(groupDTO);
		return new ResponseEntity<TaskGroup>(taskGroup, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/leave/{group_id}/{user_email}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskGroup> leaveTaskGroup(@PathVariable("group_id") Long group_id, @PathVariable("user_email") String user_email , HttpServletRequest request) throws Exception {
		
		System.out.println("=======================NAPUSTAM GRUPU========================");
		
		TaskGroup taskGroup;
		try {
			taskGroup = taskGroupService.removeUserFromTaskGroup(group_id, user_email);
			return new ResponseEntity<TaskGroup>(taskGroup, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(
			value = "/addMember/{group_id}/{user_email}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskGroup> addMemberToTaskGroup(@PathVariable("group_id") Long group_id, @PathVariable("user_email") String user_email , HttpServletRequest request) throws Exception {
		
		TaskGroup taskGroup;
		try {
			taskGroup = taskGroupService.addMembersToGroup(group_id, user_email);
			return new ResponseEntity<TaskGroup>(taskGroup, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
