package com.example.manage.animals.interfaces.concrete.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.manage.animals.interfaces.Animal;
import com.example.manage.animals.interfaces.Bird;
import com.example.manage.animals.interfaces.Mammal;
import com.example.manage.animals.operational.entity.Attributes;
import com.example.manage.animals.operational.entity.ManageVoice;

@Component
public class AnimalFactory {

	@Autowired
	private ManageVoice manageVoice;
	
	public Animal getAnimal(Attributes attributes) {
		return getProperAnimalInstance(attributes);
	}
	
	
	private Animal getProperAnimalInstance(Attributes attribute) {
		
		
		
		if(Mammal.types.contains(attribute.getType())) {
			return new MammalImpl(attribute);
		}else if(Bird.types.contains(attribute.getType())) {
			return new BirdImpl(attribute,manageVoice);
		}
		
		return null;
	}
	
	
}
