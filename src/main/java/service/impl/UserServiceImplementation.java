package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import model.repository.UserRepository;
import service.UserService;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public User getUserByID(int id) {
		return userRepository.getUserByID(id);
	}
	
	public void addUser(User user) {
		userRepository.addUser(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
	
	public void update(User user) {
		userRepository.update(user);
	}
	
	public void delete(int id) {
		userRepository.delete(id);
	}
}
