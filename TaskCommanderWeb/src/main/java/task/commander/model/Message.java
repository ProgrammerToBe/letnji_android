package task.commander.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private Long id;
	
	@NotNull
	private String text;
	
	@ManyToOne
	@NotNull
	private User sender;
	
	private Timestamp timestamp;
	
	
	public Message(String text, User sender) {
		super();
		this.text = text;
		this.sender = sender;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@JsonIgnoreProperties({"task_groups"})
	public User getSender(){
		return sender;
	}

}
