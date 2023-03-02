package com.ty.user.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.user.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
