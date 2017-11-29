package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Person;

@Component
@Transactional
public class PersonDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void savePerson(Person entity) {
		entityManager.persist(entity);
	}
	
	public List<Person> loadAllPeople() {
		final String QUERY= "SELECT p FROM Person p";
		Query query = entityManager.createQuery(QUERY);
		List<Person> list = query.getResultList();
		return list;
	}
	
	public Person loadById(long id) {
		return entityManager.find(Person.class, id);
	}
	
	public void updateBook(Person entity) {
		entityManager.merge(entity);
	}
	
	public void deleteBook(Person entity) {
		entityManager.remove(entityManager.contains(entity)?entity:entityManager.merge(entity));
	}
	
}
