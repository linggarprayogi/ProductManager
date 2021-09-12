package com.me.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.app.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
