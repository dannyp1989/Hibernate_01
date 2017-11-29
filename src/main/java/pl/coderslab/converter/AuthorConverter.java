package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

public class AuthorConverter implements Converter<String, Author> {

	@Autowired
	private AuthorDao authorDao;
	
	public Author convert(String source) {
	Author author = authorDao.loadById(Integer.parseInt(source));
	return author;
	}

}
