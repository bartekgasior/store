package model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.User;
import model.repository.UserRepository;

@Repository
public class UserRepositoryImplementation implements UserRepository{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void addUser(User user) {
		entityManager.merge(user);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getAllUsers(){
		Query query = entityManager.createQuery("SELECT u FROM User u", User.class);
		List<User> users = query.getResultList(); 
		return users;
	}
	
	@Transactional
	public User getUserByID(int id) {
		return entityManager.find(User.class, id);
	}
	
	@Transactional
	public User getUserByUsername(String username) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username");
		query.setParameter("username", username);
		return (User)query.getSingleResult();
	}
	
	@Transactional
	public void update(User user) {
		entityManager.merge(user);
	}
	
	@Transactional
	public void delete(int id) {
		Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
