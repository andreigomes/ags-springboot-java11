package com.ags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ags.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
