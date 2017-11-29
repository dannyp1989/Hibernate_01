package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PersonRepository;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private PublisherDao publisherDao;
	
	@RequestMapping("")
	public String showBooks(Model model) {
		List<Book> list = bookDao.loadAllBooks();
		List<Author> listA = authorDao.loadAll();
		List<Publisher> listP = publisherDao.loadAll();
		Book book = new Book();
		model.addAttribute("authors", listA);
		model.addAttribute("publishers", listP);
		model.addAttribute("book", book);
		
		model.addAttribute("books", list);
		return "books";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String addBook(@ModelAttribute Book book) {
//		public String addBook(@RequestParam String title, @RequestParam String description,
//				@RequestParam double rating,@RequestParam long author_id, @RequestParam long publisher_id) {
//		Book book = new Book();
//		book.setTitle(title);
//		book.setDescription(description);
//		book.setRating(rating);
//		Author author = authorDao.loadById(author_id);
//		Publisher publisher = publisherDao.loadById(publisher_id);
//		book.setAuthor(author);
//		book.setPublisher(publisher);
		bookDao.saveBook(book);
		return "redirect:/books";
//		return "redirect:./";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeBook(@PathVariable long id) {
		Book book = bookDao.loadById(id);
		bookDao.deleteBook(book);
		return "redirect:../";
	}
	
	@RequestMapping("/edit/{id}")
	public String editBookForm(@PathVariable long id, Model model) {
		Book book = bookDao.loadById(id);
		List<Author> listA = authorDao.loadAll();
		List<Publisher> listP = publisherDao.loadAll();
		model.addAttribute("authors", listA);
		model.addAttribute("publishers", listP);
		model.addAttribute("book", book);
		return "edit";
	}
	
	@RequestMapping("/edit")
	public String editBook(@RequestParam long id, @RequestParam String title, @RequestParam String description,
			@RequestParam double rating, @RequestParam long author_id, @RequestParam long publisher_id) {
		Book book = bookDao.loadById(id);
		book.setTitle(title);
		book.setDescription(description);
		book.setRating(rating);
		Author author = authorDao.loadById(author_id);
		Publisher publisher = publisherDao.loadById(publisher_id);
		book.setAuthor(author);
		book.setPublisher(publisher);
		bookDao.updateBook(book);
		return "redirect:./";
	}
	
}








