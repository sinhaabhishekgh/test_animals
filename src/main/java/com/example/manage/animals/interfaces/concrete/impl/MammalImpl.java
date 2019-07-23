package com.example.manage.animals.interfaces.concrete.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.manage.animals.interfaces.Mammal;
import com.example.manage.animals.operational.entity.Attributes;
import com.example.manage.animals.operational.entity.ManageVoice;

public class MammalImpl implements Mammal{
	
	
	private Attributes attributes;

	@Autowired
	private ManageVoice manageVoice;
	
	
	public MammalImpl(Attributes attributes) {
		super();
		this.attributes = attributes;
	}


	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}

}
