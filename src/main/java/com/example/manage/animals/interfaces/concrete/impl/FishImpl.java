package com.example.manage.animals.interfaces.concrete.impl;

import org.springframework.util.StringUtils;

import com.example.manage.animals.attributes.entity.Actions;
import com.example.manage.animals.exception.CustomException;
import com.example.manage.animals.exception.ErrorConstants;
import com.example.manage.animals.interfaces.Fish;
import com.example.manage.animals.operational.entity.Attributes;

public class FishImpl implements Fish{

	
	private Attributes attributes;
	
	
	public FishImpl(Attributes attributes) {
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

	@Override
	public String decorateWithDimentison() {
		String decoratedValue = "";
		if(attributes.getColor() != null) {
			decoratedValue  = "Color is : " + attributes.getColor().name() + ",";
		}
		if(attributes.getDimension() != null) {
			decoratedValue  = decoratedValue + "Dimension is : " + attributes.getDimension().name();
		}
		return decoratedValue;
	}

	@Override
	public String toString() {
			return decorateWithDimentison() != ""?String.join(" : ", this.attributes.getType().name() ,decorateWithDimentison()):this.attributes.getType().name();
	}
	
}
