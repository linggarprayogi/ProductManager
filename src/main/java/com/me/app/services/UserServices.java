package com.me.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.app.repo.UsersRepository;

@Service
public class UserServices {

	@Autowired
	UsersRepository usersRepository;

}
