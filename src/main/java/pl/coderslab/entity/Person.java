package pl.coderslab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="people")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(unique=true)
	private String login;
	private String password;
	@Column(unique=true)
	private String email;
	@OneToOne
	@JoinColumn(name="details_id")
	private PersonDetails personDetails;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public long getId() {
		return id;
	}
	public PersonDetails getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(PersonDetails personDetails) {
		this.personDetails = personDetails;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}