package com.example.manage.animals.operational.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.manage.animals.attributes.entity.Voice;
import com.example.manage.animals.exception.CustomException;
import com.example.manage.animals.exception.ErrorConstants;

@Component
public class ManageVoice {


	@Autowired
	private Environment env;
	
	/**
	 * Write Business logic to implement the speaking part of animal behaviour  otherwise throw exception
	 */
	public String speak(Attributes attributes) throws CustomException{
		
		String key = null;
		if(Voice.BASIC_VOICE.equals(attributes.getVoice())) {
		 key = String.join(".", "VOICE" , attributes.getType().name(),attributes.getVoice().name());
		}else if(Voice.LEARNABLE_VOICE.equals(attributes.getVoice())) {
			 key = String.join(".", "VOICE" , attributes.getType().name(),attributes.getVoice().name(), attributes.getNeighbour().name());
		}
		if(!StringUtils.isEmpty(key)) {
			return (env.getProperty(key));
		}else {
			throw new CustomException(ErrorConstants.CAN_NOT_SPEAK);
		}
	}
	
	/**
	 * Write business logic to implement for sing, otherwise throw exception
	 */
	public String sing(Attributes attributes) throws CustomException {
		String key = null;
		if(Voice.SING.equals(attributes.getVoice())) {
		 key = String.join(".", "VOICE" , attributes.getType().name(),attributes.getVoice().name());
		}
		if(!StringUtils.isEmpty(key)) {
			return  env.getProperty(key);
		}else {
			throw new CustomException(ErrorConstants.CAN_NOT_SING);
		}
	}
	
	
	
}
