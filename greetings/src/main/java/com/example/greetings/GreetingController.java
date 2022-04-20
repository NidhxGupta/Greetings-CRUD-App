package com.example.greetings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GreetingController {

	@Autowired
	public MongoRepo repo;
	
	@GetMapping("/")
	public String homepage(Model model){
		return "homepage";
	}
	
	@GetMapping("/viewgreeting")
	public String viewGreeting(Model model) {
		List<Greeting> greeting = repo.findAll();
		model.addAttribute("allgreeting",greeting);
		return "viewgreeting";
	}
	
	@GetMapping("/addgreeting")
	public String addGreeting(Model model) {
		model.addAttribute("greeting",new Greeting());
		return "addgreeting";
	}

	@PostMapping("/addgreeting")
	public String submitGreeting(@ModelAttribute("greeting") Greeting greeting) {
		repo.save(greeting);
		return "redirect:viewgreeting";
	}

	@GetMapping("/editgreeting")
	public String editGreeting(Model model) {
		model.addAttribute("greeting",new Greeting());
		return "editgreeting";
	}
	
		
	
	@PostMapping("/editgreeting")
	public String submiteditGreeting(@ModelAttribute("greeting") Greeting greeting) {
		System.out.println(greeting.getGreetingcontent2());

		List<Greeting> greetings = repo.getGreetingByContent(greeting.getGreetingcontent());
		for (Greeting m : greetings) {
			m.setName(greeting.getName2());
			m.setGreetingcontent(greeting.getGreetingcontent2());
			repo.save(m);
					
		}
		
		return "redirect:viewgreeting";
		
	}
	
	@GetMapping("/deletegreeting")
	public String deleteGreeting(Model model) {
		model.addAttribute("greeting",new Greeting());
		return "deletegreeting";
	}
	
	
	@PostMapping("/deletegreeting")
	public String editedGreeting(@ModelAttribute("greeting") Greeting greeting) {
		System.out.println(greeting.getName());
		List<Greeting> greetings = repo.getGreetingByName(greeting.getName());
		for (Greeting m : greetings) {
			System.out.println(m.getName());
			repo.delete(m);
		}
		return "redirect:viewgreeting";
	}
}
