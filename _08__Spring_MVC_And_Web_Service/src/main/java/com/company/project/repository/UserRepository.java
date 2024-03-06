package com.company.project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.project.model.User;

@Repository(value = "repository_user")
public interface UserRepository extends JpaRepository<User, Long> {

}
