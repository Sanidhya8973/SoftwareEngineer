package com.sanidhya.service;

import java.util.List;

import com.sanidhya.exception.StoryException;
import com.sanidhya.exception.UserException;
import com.sanidhya.model.Story;

public interface StoryService {

	public Story createStory(Story story,Integer userId) throws UserException;
	
	public List<Story> findStoryByUserId(Integer userId) throws UserException, StoryException;
	
	
}
