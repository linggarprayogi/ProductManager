package com.me.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.app.model.Product;
import com.me.app.services.ProductService;

@Controller
public class AppController {
	@Autowired
	private ProductService service;

	// Halaman Index
	@RequestMapping("/index")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);

		return "index";
	}

	// Insert new product
	@RequestMapping("/new")
	public String showNewproductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);

		return "new_product";
	}

	// Save product baru
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);

		return "redirect:/";
	}

	// Edit by Id Product
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditproductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav     = new ModelAndView("edit_product");
		Product      product = service.get(id);
		mav.addObject("product", product);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);

		return "redirect:/";
	}
}
