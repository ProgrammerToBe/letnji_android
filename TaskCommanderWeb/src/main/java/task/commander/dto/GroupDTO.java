package task.commander.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class GroupDTO {
	
	private String name;
	private Collection<String> members ;
	
	
	
	public GroupDTO(String name, Collection<String> members) {
		super();
		this.name = name;
		this.members = members;
	}



	public GroupDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
