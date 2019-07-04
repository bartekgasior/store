package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "{NotBlank.User.username.validation}")
	@Size(min = 3, max = 12, message = "{Size.User.username.validation}")
	@Column(name = "username")
	private String username;
	
	@NotBlank(message = "{NotBlank.User.password.validation}")
	@Size(min = 3, max = 12, message = "{Size.User.password.validation}")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "{NotBlank.User.name.validation}")
	@Size(min = 3, max = 12, message = "{Size.User.name.validation}")
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = "{NotBlank.User.lastName.validation}")
	@Size(min = 3, max = 12, message = "{Size.User.lastName.validation}")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "{NotBlank.User.email.validation}")
	@Email(message = "{Email.User.email.validation}")
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "user")
	private Set<Purchase> purchases = new HashSet<Purchase>();
	
	public User() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return id + " - " + name + " " + lastName;
	}
	
	
}
