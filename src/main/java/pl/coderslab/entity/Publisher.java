package pl.coderslab.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="publishers")
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="name", length=100)
	private String name;

	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
	
}
