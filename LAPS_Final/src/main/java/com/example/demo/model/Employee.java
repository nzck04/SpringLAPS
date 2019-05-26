package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String username;
	private String password;
	private String email;

	@ManyToOne
	@JoinColumn(name="manager_id")
	private Employee manager;
	
	private String role;
	private String annualleave;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String username, String password, String email, Employee manager, String role,
			String annualleave) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.manager = manager;
		this.role = role;
		this.annualleave = annualleave;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAnnualleave() {
		return annualleave;
	}
	public void setAnnualleave(String annualleave) {
		this.annualleave = annualleave;
	}
	@Override
	/*public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", manager=" + manager + ", role=" + role + ", annualleave=" + annualleave + "]";
	}*/
	public String toString() {
	
		return Integer.toString(id);
	}
	
	
	
	
}
