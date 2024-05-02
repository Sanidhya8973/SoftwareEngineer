package com.sanidhya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanidhya.model.Comments;


public interface CommentRepository extends JpaRepository<Comments, Integer> {

}
