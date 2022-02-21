package com.me.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.app.model.Users;
import com.me.app.repo.UsersRepository;

@Service
public class UserServices {

	@Autowired
	UsersRepository usersRepository;

	public List<Users> listAll() {
		return usersRepository.findAll();
	}
}
