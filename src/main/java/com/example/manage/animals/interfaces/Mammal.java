package com.example.manage.animals.interfaces;

import java.util.Arrays;
import java.util.List;

import com.example.manage.animals.attributes.entity.AnimalType;
import com.example.manage.animals.exception.CustomException;
import com.example.manage.animals.operational.entity.Attributes;

public interface Mammal extends Animal {
	
	static List<AnimalType> types = Arrays.asList(AnimalType.DOLPHIN);
	
	void walk() throws CustomException;
	
	void swim() throws CustomException;

}
