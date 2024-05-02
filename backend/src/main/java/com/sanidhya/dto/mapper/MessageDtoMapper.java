package com.sanidhya.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sanidhya.dto.ChatDto;
import com.sanidhya.dto.MessageDto;
import com.sanidhya.dto.UserDto;
import com.sanidhya.model.Message;

public class MessageDtoMapper {
	
	
	public static MessageDto toMessageDto(Message message) {
		
//		ChatDto chatDto=ChatDtoMapper.toChatDto(message.getChat());
		UserDto userDto=UserDtoMapper.userDTO(message.getUser());
		
		MessageDto messageDto=new MessageDto();
		messageDto.setId(message.getId());
//		messageDto.setChat(chatDto);
		messageDto.setContent(message.getContent());
		messageDto.setIs_read(message.getIs_read());
		messageDto.setTimeStamp(message.getTimeStamp());
		messageDto.setUser(userDto);
		messageDto.setImage(message.getImage());
		
		return messageDto;
	}
	
	public static List<MessageDto> toMessageDtos(List<Message> messages){
		
		List<MessageDto> messageDtos=new ArrayList<>();
		
		for(Message message : messages) {
			MessageDto messageDto=toMessageDto(message);
			messageDtos.add(messageDto);
		}
		
		return messageDtos;
	}

}
