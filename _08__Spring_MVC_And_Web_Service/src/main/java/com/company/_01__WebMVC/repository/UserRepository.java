package com.company._01__WebMVC.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company._01__WebMVC.model.User;

@Repository(value = "repository_user")
public interface UserRepository extends JpaRepository<User, Long> {

}
