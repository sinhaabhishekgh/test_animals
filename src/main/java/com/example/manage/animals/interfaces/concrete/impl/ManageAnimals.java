package com.example.manage.animals.interfaces.concrete.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manage.animals.attributes.entity.Actions;
import com.example.manage.animals.attributes.entity.AnimalType;
import com.example.manage.animals.attributes.entity.Color;
import com.example.manage.animals.attributes.entity.Dimension;
import com.example.manage.animals.attributes.entity.Voice;
import com.example.manage.animals.interfaces.Animal;
import com.example.manage.animals.interfaces.Bird;
import com.example.manage.animals.operational.entity.Attributes;

@Service
public class ManageAnimals {

	@Autowired
	private AnimalFactory factory;
	
	
	List<Animal> animals;
	
	
	@PostConstruct
	public void init() {
		animals = new ArrayList<Animal>();
		
		Attributes birdAttributes = 
				new Attributes(AnimalType.BIRD, Voice.SING, null, Arrays.asList(Actions.WALK, Actions.FLY), null, null, null);
		Animal bird = factory.getAnimal(birdAttributes);

		Attributes duckAttributes = 
				new Attributes(AnimalType.DUCK, Voice.BASIC_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY, Actions.SWIM), null, null, null);
		Animal duck = factory.getAnimal(duckAttributes);
		
		Attributes chickenAttributes = 
				new Attributes(AnimalType.CHICKEN, Voice.BASIC_VOICE, null, Arrays.asList(Actions.WALK), null, null, null);
		Animal chicken = factory.getAnimal(chickenAttributes);
		
		Attributes roosterAttributes = 
				new Attributes(AnimalType.ROOSTER, Voice.BASIC_VOICE, null, Arrays.asList(Actions.WALK), null, null, null);
		Animal rooster = factory.getAnimal(roosterAttributes);
		
		Attributes parrotWithDogAtt = 
				new Attributes(AnimalType.PARROT, Voice.LEARNABLE_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY), AnimalType.DOG, null, null);
		Animal parrotWithDog = factory.getAnimal(parrotWithDogAtt);
		
		Attributes parrotWithCatAtt = 
				new Attributes(AnimalType.PARROT, Voice.LEARNABLE_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY), AnimalType.CAT, null, null);
		Animal parrotWithCat = factory.getAnimal(parrotWithCatAtt);
		
		Attributes parrotWithRooAtt = 
				new Attributes(AnimalType.PARROT, Voice.LEARNABLE_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY), AnimalType.ROOSTER, null, null);
		Animal parrotWithRooster = factory.getAnimal(parrotWithRooAtt);
		
		animals.add(bird);
		animals.add(duck);
		animals.add(chicken);
		animals.add(rooster);
		animals.add(parrotWithDog);
		animals.add(parrotWithCat);
		animals.add(parrotWithRooster);
	
	}
	
}
