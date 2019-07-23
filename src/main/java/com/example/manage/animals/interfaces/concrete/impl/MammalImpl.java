package com.example.manage.animals.interfaces.concrete.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.manage.animals.attributes.entity.Actions;
import com.example.manage.animals.exception.CustomException;
import com.example.manage.animals.exception.ErrorConstants;
import com.example.manage.animals.interfaces.Mammal;
import com.example.manage.animals.operational.entity.Attributes;

public class MammalImpl implements Mammal{
	
	
	private Attributes attributes;

	
	public MammalImpl(Attributes attributes) {
		super();
		this.attributes = attributes;
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
