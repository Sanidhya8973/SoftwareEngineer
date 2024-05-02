package com.sanidhya.service;

import com.sanidhya.exception.CommentException;
import com.sanidhya.exception.PostException;
import com.sanidhya.exception.UserException;
import com.sanidhya.model.Comments;

public interface CommentService {
	
	public Comments createComment(Comments comment,Integer postId,Integer userId) throws PostException, UserException;

	public Comments findCommentById(Integer commentId) throws CommentException;
	public Comments likeComment(Integer CommentId,Integer userId) 
			throws UserException, CommentException;
}
