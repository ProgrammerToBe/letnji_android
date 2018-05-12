package task.commander.controller;

import java.util.Collection;

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

import task.commander.dto.TaskDTO;
import task.commander.model.Task;
import task.commander.service.TaskService;

@Controller
@RequestMapping(value="/task")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@RequestMapping(
			value = "/create",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO , HttpServletRequest request) throws Exception {
		
		Task task;
		try {
			task = taskService.create(taskDTO);
			return new ResponseEntity<Task>(task, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(
			value = "/complete/{task_id}/{email}",
			method = RequestMethod.PUT,
			
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Task>> createTask(@PathVariable("task_id") Long task_id, @PathVariable("email") String email, HttpServletRequest request) throws Exception {
		System.out.println("=====================HIT COMPLETE=========================");
		Task task;
		try {
			
			return new ResponseEntity<Collection<Task>>(taskService.complete(task_id, email), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(
			value = "/find/{filter}/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Task>> find(@PathVariable("filter") String filter, @PathVariable("id") String id , HttpServletRequest request) throws Exception {
		
		System.out.println("===============================POGODJEN FIND===========================");
		
		if(filter.equals("assignee")){
			return new ResponseEntity<Collection<Task>>(taskService.getTasksByAssignee(id), HttpStatus.OK);
		}else if(filter.equals("group_id")){
			try {
				return new ResponseEntity<Collection<Task>>(taskService.getTasksByGroupId(Long.parseLong(id)), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		return null;
		
	}
	
}
