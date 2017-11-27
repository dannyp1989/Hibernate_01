package pl.coderslab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(length =255)
	private String title;
	@Column(scale=2, precision=4)
	private double rating;
	@Column(columnDefinition="TEXT")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	@ManyToOne
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	
	
	
}
