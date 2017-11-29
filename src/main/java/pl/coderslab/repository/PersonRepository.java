package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	List<Person> findBypassword(String password);
	List<Person> findByPasswordOrLogin(String password, String login);
	
	@Query("SELECT p FROM Person p where p.password = :password")
	List<Person> findByPassword22(String password);
	
}
