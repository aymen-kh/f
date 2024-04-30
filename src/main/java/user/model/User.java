package user.model;

/**
 * User.java
 * This is a model class represents a User entity
 *
 */
public class User {
	protected int id;
	protected String name;
	protected String email;
	protected String password;
	
	public User() {
	}
	
	public User(String name, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.password = country;
	}

	public User(int id, String name, String email, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = country;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String country) {
		this.password = country;
	}
}
