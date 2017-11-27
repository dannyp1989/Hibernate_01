package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorDao authorDao;
	
	@RequestMapping("")
	public String showAuthors(Model model) {
		List<Author> list = authorDao.loadAll();
		model.addAttribute("author", list);
		return "authors";
	}
	
	@RequestMapping("/add")
	public String addAuthor(@RequestParam String firstname, @RequestParam String lastname) {
		Author author = new Author();
		author.setFirstName(firstname);
		author.setLastName(lastname);
		authorDao.saveToDb(author);;
		return "redirect:./";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeAuthors(@PathVariable long id) {
		Author author = authorDao.loadById(id);
		authorDao.delete(author);
		return "redirect:../";
	}
	
	@RequestMapping("/edit/{id}")
	public String editBookForm(@PathVariable long id, Model model) {
		Author author = authorDao.loadById(id);
		model.addAttribute("author", author);
		return "authors_edit";
	}
	
	@RequestMapping("/edit")
	public String editBook(@RequestParam long id, @RequestParam String firstname, @RequestParam String lastname) {
		Author author = authorDao.loadById(id);
		author.setFirstName(firstname);
		author.setLastName(lastname);
		authorDao.update(author);
		return "redirect:./";
	}
	
}








