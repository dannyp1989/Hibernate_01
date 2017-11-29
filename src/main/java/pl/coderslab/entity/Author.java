package pl.coderslab.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="firstname", length=100)
	private String firstName;
	@Column(name="lastname", length=100)
	private String lastName;
	@OneToMany(mappedBy="author", cascade=CascadeType.REMOVE)
	private List<Book> books;
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
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
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
