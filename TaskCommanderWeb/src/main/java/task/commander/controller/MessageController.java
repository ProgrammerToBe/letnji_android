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

import task.commander.dto.MessageDTO;
import task.commander.model.Message;
import task.commander.model.TaskGroup;
import task.commander.service.MessageService;
import task.commander.service.TaskGroupService;

@Controller
@RequestMapping(value="/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	TaskGroupService taskGroupService;
	
	@RequestMapping(
			value = "/create/{group_id}",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> createMessage(@PathVariable("group_id") Long group_id,
			@RequestBody MessageDTO msg , HttpServletRequest request) throws Exception {
		
		Message message = messageService.create(msg, group_id);
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/get_all/{group_id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Message>> getMessages(@PathVariable("group_id") Long group_id,
			HttpServletRequest request) throws Exception {
		
		TaskGroup taskGroup = taskGroupService.getGroup(group_id);
		
		return new ResponseEntity<Collection<Message>>(taskGroup.getMessages(), HttpStatus.OK);
	}
	

}
