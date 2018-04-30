package task.commander.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Long id;

	@Column(unique = true, nullable = false)
	@Size(max = 40)
	@NotNull
	private String name;
	
	@Column( nullable = true)
	@Size(max = 60)
	private String description;
	
	@ManyToOne
	private User assignee;
	
	private boolean completed;
	
	private Timestamp deadline;
	
	public Task() {
		super();
		this.completed = false;
	}


	public Task( @Size(max = 40) @NotNull String name, @Size(max = 60) String description, User assignee,
			 Timestamp deadline) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.assignee = assignee;
		this.completed = completed;
		this.deadline = deadline;
	}
	
	@JsonIgnoreProperties({ "task_groups"})
	public User getAssignee(){
		return assignee;
	}

	
}
