package com.me.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.app.model.Stock;
import com.me.app.services.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService service;

	@RequestMapping("/stock")
	public List<Stock> getAllStocks(Model model) {
		List<Stock> listStock = service.allStock();
		model.addAttribute("listStocks", listStock);

		return listStock;
	}
}
