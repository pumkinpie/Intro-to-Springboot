package com.tts.MyAweSomeProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.tts.MyAweSomeProject.domain.Subscriber;

@Controller
public class MainController {

@SuppressWarnings("rawtypes")
@Autowired	
private CrudRepository subscriberRepository;

@GetMapping(value= "/")	
	public String index(Subscriber subscriber) {
		return "index";
	}
private Subscriber subscriber;

@SuppressWarnings("unchecked")
@PostMapping(value = "/")

// this method will post the info to the database and display a "confirmation" on a new template "result"
public String addNewSubscriber(Subscriber subscriber, Model model) {
	subscriberRepository.save(new Subscriber(subscriber.getFirstName(), 
        subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignedUp()));
	model.addAttribute("firstName", subscriber.getFirstName());
	model.addAttribute("lastName", subscriber.getLastName());
	model.addAttribute("userName", subscriber.getUserName());
	return "result";

}

public Subscriber getSubscriber() {
	return subscriber;
}

public void setSubscriber(Subscriber subscriber) {
	this.subscriber = subscriber;
}
}