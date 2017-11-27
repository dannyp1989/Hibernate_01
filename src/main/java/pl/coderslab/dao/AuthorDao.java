package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Author;

@Component
@Transactional
public class AuthorDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void saveToDb(Author entity) {
		entityManager.persist(entity);
	}
	
	public Author loadById(long id) {
		return entityManager.find(Author.class, id);
	}
	
	public List<Author> loadAll() {
		String QUERY_LOAD_ALL = "SELECT a FROM Author a";
		Query query = entityManager.createQuery(QUERY_LOAD_ALL);
		List<Author> list = query.getResultList();
		return list;
	}
	
	public void update(Author entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Author entity) {
		entityManager.remove(entityManager.contains(entity)?entity:entityManager.merge(entity));
	}
	
}
