package pl.coderslab.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@Controller
@RequestMapping("/peopledet")
public class PersonDetailsController {

	@Autowired
	private PersonDetailsDao personDetailsDao;
	@Autowired
	private PersonDao personDao;
	
	@ModelAttribute("people")
	public List<String> getProgrammingSkills() {
		String[] list = {"Java","Python","Ruby"};
		return Arrays.asList(list);
	}
	@ModelAttribute("hobbies")
	public List<String> getHobbies() {
		String[] list = {"running","programming","playing football"};
		return Arrays.asList(list);
	}
	
	@RequestMapping("")
	public String showPeopleDetails(Model model) {
		List<PersonDetails> list = personDetailsDao.loadAllPeopleDetails();
		PersonDetails personDetails = new PersonDetails();
		model.addAttribute("personDet", personDetails);
		model.addAttribute("peopleDet", list);
		return "peopleDetails";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String addNewPersonDet(@ModelAttribute PersonDetails personDetails) {
		personDetailsDao.savePersonDetail(personDetails);
		return "redirect:/peopleDetails";
	}
	
}
