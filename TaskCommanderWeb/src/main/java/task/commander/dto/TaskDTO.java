package task.commander.dto;

import lombok.Data;

@Data
public class TaskDTO {
	
	private String name;
	private String description;
	private Long group_id;
	private String assignee;
	
	public TaskDTO(String name, String description, Long group_id, String assignee) {
		super();
		this.name = name;
		this.description = description;
		this.group_id = group_id;
		this.assignee = assignee;
	}
	public TaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
