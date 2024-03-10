package com.company.project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.project.entity.User;

@Repository(value = "repository_user")
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM table_user WHERE user_email = :email;", nativeQuery = true)
    public abstract void readUserByEmail(@Param("email") String email) throws Exception;

}