package task.commander.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import task.commander.dto.TaskDTO;
import task.commander.exceptions.NotFoundException;
import task.commander.model.Task;
import task.commander.model.TaskGroup;
import task.commander.model.User;
import task.commander.repository.TaskGroupRepository;
import task.commander.repository.TaskRepository;
import task.commander.repository.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TaskGroupRepository taskGroupRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Task create(TaskDTO taskDTO) {
		
		User user = userRepository.findByEmail(taskDTO.getAssignee()).orElseThrow(NotFoundException::new);
		Task task = new Task(taskDTO.getName(), taskDTO.getDescription(), user, new Timestamp(0));
		
		TaskGroup taskGroup = taskGroupRepository.findById(taskDTO.getGroup_id()).orElseThrow(NotFoundException::new);
		
		task = taskRepository.save(task);
		taskGroup.getTasks().add(task);
		taskGroupRepository.save(taskGroup);
		return task;
	}

	public Task complete(Long task_id) {
		Task task = taskRepository.findById(task_id).orElseThrow(NotFoundException::new);
		task.setCompleted(true);
		task = taskRepository.save(task);
		return task;
	}

}
