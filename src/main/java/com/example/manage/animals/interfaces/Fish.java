package com.example.manage.animals.interfaces;

import java.util.Arrays;
import java.util.List;

import com.example.manage.animals.attributes.entity.AnimalType;
import com.example.manage.animals.exception.CustomException;

public interface Fish extends Animal, DimensionDecorator{

	static List<AnimalType> types = Arrays.asList(AnimalType.FISH, AnimalType.SHARK, AnimalType.CLOWNFISH);
	
	String swim() throws CustomException;
}
