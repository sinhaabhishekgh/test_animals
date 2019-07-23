package com.example.manage.animals.interfaces;

import java.util.Arrays;
import java.util.List;

import com.example.manage.animals.attributes.entity.AnimalType;
import com.example.manage.animals.exception.CustomException;

public interface Bird extends Animal {
	
	static List<AnimalType> types = Arrays.asList(AnimalType.BIRD, AnimalType.CHICKEN, AnimalType.DUCK, AnimalType.ROOSTER, AnimalType.PARROT, AnimalType.BUTTERFLY, AnimalType.CATTERPILOR);
	
	String fly() throws CustomException;
	
	String walk() throws CustomException;
	
	String speak() throws CustomException;
	
	String sing() throws CustomException;
	
	String swim() throws CustomException;
}
