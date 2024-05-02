package com.sanidhya.service;

import java.util.List;

import com.sanidhya.exception.UserException;
import com.sanidhya.model.Reels;
import com.sanidhya.model.User;

public interface ReelsService {
	
	public Reels createReel(Reels reel,User user);
	public List<Reels> findAllReels();
	public List<Reels> findUsersReel(Integer userId) throws UserException;

}
