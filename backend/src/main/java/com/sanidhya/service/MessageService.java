package com.sanidhya.service;

import java.util.List;

import com.sanidhya.exception.ChatException;
import com.sanidhya.exception.MessageException;
import com.sanidhya.exception.UserException;
import com.sanidhya.model.Message;
import com.sanidhya.request.SendMessageRequest;

public interface MessageService  {
	
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException;
	
	public List<Message> getChatsMessages(Integer chatId) throws ChatException;
	
	public Message findMessageById(Integer messageId) throws MessageException;
	
	public String deleteMessage(Integer messageId) throws MessageException;

}
