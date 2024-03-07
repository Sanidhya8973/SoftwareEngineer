package com.company._02__WebService.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company._02__WebService.entity.User;

@Repository(value = "repository_user")
public interface UserRepository extends JpaRepository<User, Long> {

}