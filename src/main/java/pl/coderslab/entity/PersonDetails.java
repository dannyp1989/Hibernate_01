package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persondetails")
public class PersonDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private long streetNumber;
	private String street;
	private String city;
	private boolean mailing;
	private String[] programmingSkills;
	private String[] hobbies;
	
	public boolean isMailing() {
		return mailing;
	}
	public void setMailing(boolean mailing) {
		this.mailing = mailing;
	}
	public String[] getProgrammingSkills() {
		return programmingSkills;
	}
	public void setProgrammingSkills(String[] programmingSkills) {
		this.programmingSkills = programmingSkills;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(long streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}