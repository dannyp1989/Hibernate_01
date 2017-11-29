package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.PersonDetails;

@Component
@Transactional
public class PersonDetailsDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void savePersonDetail(PersonDetails entity) {
		entityManager.persist(entity);
	}
	
	public List<PersonDetails> loadAllPeopleDetails() {
		final String QUERY= "SELECT b FROM PersonDetails b";
		Query query = entityManager.createQuery(QUERY);
		List<PersonDetails> list = query.getResultList();
		return list;
	}
	
	public PersonDetails loadById(long id) {
		return entityManager.find(PersonDetails.class, id);
	}
	
	public void updateBook(PersonDetails entity) {
		entityManager.merge(entity);
	}
	
	public void deleteBook(PersonDetails entity) {
		entityManager.remove(entityManager.contains(entity)?entity:entityManager.merge(entity));
	}
	
}
