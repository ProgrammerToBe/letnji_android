package task.commander.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import task.commander.exceptions.NotFoundException;
import task.commander.model.User;
import task.commander.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User initialRequestProcessing(String email){
		
		try {
			User user = userRepository.findByEmail(email).orElseThrow(NotFoundException::new);
			return user;
		} catch (NotFoundException e) {
			User user = new User(email);
			return userRepository.save(user);
		}
		
	}

}