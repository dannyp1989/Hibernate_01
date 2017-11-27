package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

	@Autowired
	private PublisherDao publisherDao;
	
	@RequestMapping("")
	public String showPublishers(Model model) {
		List<Publisher> list = publisherDao.loadAll();
		model.addAttribute("publishers", list);
		return "publishers";
	}
	
	@RequestMapping("/add")
	public String addPublisher(@RequestParam String name) {
		Publisher publisher = new Publisher();
		publisher.setName(name);
		publisherDao.saveToDb(publisher);
		return "redirect:./";
	}
	
	@RequestMapping("/remove/{id}")
	public String removePublisher(@PathVariable long id) {
		Publisher publisher = publisherDao.loadById(id);
		publisherDao.delete(publisher);
		return "redirect:../";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPublisherForm(@PathVariable long id, Model model) {
		Publisher publisher = publisherDao.loadById(id);
		model.addAttribute("publisher", publisher);
		return "publishers_edit";
	}
	
	@RequestMapping("/edit")
	public String editBook(@RequestParam long id, @RequestParam String name) {
		Publisher publisher = publisherDao.loadById(id);
		publisher.setName(name);
		publisherDao.update(publisher);
		return "redirect:./";
	}
	
}








