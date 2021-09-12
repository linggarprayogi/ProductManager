package com.me.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.app.model.Stock;
import com.me.app.repo.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository str;

	public List<Stock> allStock() {
		return str.findAll();
	}

}
