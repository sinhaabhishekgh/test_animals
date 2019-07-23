package com.example.manage.animals.interfaces.concrete.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.manage.animals.attributes.entity.Actions;
import com.example.manage.animals.exception.CustomException;
import com.example.manage.animals.exception.ErrorConstants;
import com.example.manage.animals.interfaces.Bird;
import com.example.manage.animals.operational.entity.Attributes;
import com.example.manage.animals.operational.entity.ManageVoice;

@Component
@Scope("prototype")
public class BirdImpl implements Bird{

	
	private Attributes attributes;
	
	
	private ManageVoice manageVoice;
	
	
	public BirdImpl(Attributes attributes, ManageVoice manageVoice) {
		super();
		this.attributes = attributes;
		this.manageVoice = manageVoice;
	}

	@Override
	public String speak() throws CustomException {
		return manageVoice.speak(attributes);
	}

	@Override
	public String fly() throws CustomException{
		if(attributes.getActions().contains(Actions.FLY)) {
			return Actions.FLY.getDescription();
		}else {
			throw new CustomException(ErrorConstants.CAN_NOT_FLY);
		}
	}

	@Override
	public String walk() throws CustomException {
		if(attributes.getActions().contains(Actions.WALK)) {
			return Actions.WALK.getDescription();
		}else {
			throw new CustomException(ErrorConstants.CAN_NOT_WALK);
		}
	}

	@Override
	public String sing() throws CustomException {
		return manageVoice.sing(attributes);
		
	}

	@Override
	public String swim() throws CustomException {
		if(attributes.getActions().contains(Actions.SWIM)) {
			return Actions.SWIM.getDescription();
		}else {
			throw new CustomException(ErrorConstants.CAN_NOT_SWIM);
		}		
	}

}
