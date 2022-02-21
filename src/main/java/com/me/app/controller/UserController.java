package com.me.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.app.model.Users;
import com.me.app.repo.UsersRepository;
import com.me.app.services.UserServices;

@Controller
//@RestController
public class UserController {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	UserServices    userServices;

	// Login form
	@RequestMapping("/")
	public String login() {
		return "login.html";
	}

	@RequestMapping(value = "/signup/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Users user) {
		usersRepository.save(user);
		return "redirect:/";
	}

	@RequestMapping("/signup/new")
	public String showSignUp(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);

		return "signup";
	}

	@RequestMapping("/user-validasi")
	public String validasiUser(@ModelAttribute("user") Users user) {
		List<Users> users = userServices.listAll();
		String      rtn   = null;
		for (Users u : users) {
			String usr = u.getUsername();
			String pwd = u.getPassword();

			if (usr.equals(user.getUsername()) && pwd.equals(user.getPassword())) {
				rtn = "redirect:/index";
				break;
			} else {
				rtn = "login.html";
			}
		}

		return rtn;
	}
}
