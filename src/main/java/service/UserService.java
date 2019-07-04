package service;

import java.util.List;

import model.User;

public interface UserService {
	public User getUserByID(int id);
	public List<User> getAllUsers();
	public void addUser(User user);
	public User getUserByUsername(String username);
	public void update(User user);
	public void delete(int id);
}
