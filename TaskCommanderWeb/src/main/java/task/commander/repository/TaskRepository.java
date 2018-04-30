package task.commander.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import task.commander.model.Task;
import task.commander.model.TaskGroup;

@Repository
public interface TaskRepository  extends CrudRepository<Task, Long>{
	public Task save(Task task);
	public Optional<Task> findById(Long id);
	public Optional<Task> findByName(String name);
	
}