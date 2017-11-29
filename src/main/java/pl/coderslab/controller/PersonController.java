package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entity.Person;
import pl.coderslab.repository.PersonRepository;


@Controller
@RequestMapping("/people")
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping("")
	public String showPeople(Model model) {
		List<Person> list = personRepository.findByPasswordOrLogin("passwordw", "login");
//		List<Person> list = personRepository.findBypassword("passwordw");
//		List<Person> list = personRepository.findAll();
		Person person = new Person();
		model.addAttribute("person", person);
		model.addAttribute("people", list);
		return "people";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String addNewPerson(@ModelAttribute Person person) {
		personRepository.save(person);
		return "redirect:/people";
	}

	
	
}





