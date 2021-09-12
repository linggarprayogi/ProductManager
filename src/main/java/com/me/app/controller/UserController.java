package com.me.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.app.model.Users;
import com.me.app.repo.UsersRepository;

@Controller
//@RestController
public class UserController {

	@Autowired
	UsersRepository usersRepository;

	// Login form
	@RequestMapping("/")
	public String login() {
		return "login.html";
	}

	@RequestMapping(value = "/signup/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") Users user) {
		usersRepository.save(user);
		return "redirect:/";
	}

	@RequestMapping("/signup/new")
	public String showNewproductForm(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);

		return "signup";
	}
}
