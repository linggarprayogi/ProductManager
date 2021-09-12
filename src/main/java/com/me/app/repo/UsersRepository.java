package com.me.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.app.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
