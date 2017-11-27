package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Book;

@Component
@Transactional
public class BookDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void saveBook(Book entity) {
		entityManager.persist(entity);
	}
	
	public List<Book> loadAllBooks() {
		final String QUERY= "SELECT b FROM Book b";
		Query query = entityManager.createQuery(QUERY);
		List<Book> list = query.getResultList();
		return list;
	}
	
	public Book loadById(long id) {
		return entityManager.find(Book.class, id);
	}
	
	public void updateBook(Book entity) {
		entityManager.merge(entity);
	}
	
	public void deleteBook(Book entity) {
		entityManager.remove(entityManager.contains(entity)?entity:entityManager.merge(entity));
	}
	
}
