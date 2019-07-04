package model.repository;

import java.util.List;

import model.User;

public interface UserRepository {
	public void addUser(User user);
	public User getUserByID(int id);
	public User getUserByUsername(String username);
	public List<User> getAllUsers();
	public void update(User user);
	public void delete(int id);
}
