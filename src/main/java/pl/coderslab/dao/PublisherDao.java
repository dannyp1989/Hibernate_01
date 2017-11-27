package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class PublisherDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void saveToDb(Publisher entity) {
		entityManager.persist(entity);
	}
	
	public Publisher loadById(long id) {
		return entityManager.find(Publisher.class, id);
	}
	
	public List<Publisher> loadAll() {
		String QUERY_LOAD_ALL = "SELECT p FROM Publisher p";
		Query query = entityManager.createQuery(QUERY_LOAD_ALL);
		List<Publisher> list = query.getResultList();
		return list;
	}
	
	public void update(Publisher entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Publisher entity) {
		entityManager.remove(entityManager.contains(entity)?entity:entityManager.merge(entity));
	}
	
}
