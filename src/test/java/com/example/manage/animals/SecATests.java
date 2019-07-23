package com.example.manage.animals;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.manage.animals.attributes.entity.Actions;
import com.example.manage.animals.attributes.entity.AnimalType;
import com.example.manage.animals.attributes.entity.Color;
import com.example.manage.animals.attributes.entity.Dimension;
import com.example.manage.animals.attributes.entity.Voice;
import com.example.manage.animals.exception.CustomException;
import com.example.manage.animals.interfaces.Animal;
import com.example.manage.animals.interfaces.Bird;
import com.example.manage.animals.interfaces.concrete.impl.AnimalFactory;
import com.example.manage.animals.operational.entity.Attributes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecATests {
	
	@Autowired
	private AnimalFactory factory;

	@Test
	public void birdCanSing() {
		
		Attributes birdAttributes = 
				new Attributes(AnimalType.BIRD, Voice.SING, Color.MULTI_COLOR, Arrays.asList(Actions.WALK, Actions.FLY), null, null, Dimension.SMALL);
		Animal bird = factory.getAnimal(birdAttributes);
		
		try {
			assertTrue((((Bird)bird).walk()).contains(Actions.WALK.getDescription()));
			assertTrue((((Bird)bird).fly()).contains(Actions.FLY.getDescription()));
			assertTrue((((Bird)bird).sing()).contains("Bird singing"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void duckAndChickenDiffVoice() {
		
		Attributes duckAttributes = 
				new Attributes(AnimalType.DUCK, Voice.BASIC_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY, Actions.SWIM), null, null, null);
		Animal duck = factory.getAnimal(duckAttributes);
		
		Attributes chickenAttributes = 
				new Attributes(AnimalType.CHICKEN, Voice.BASIC_VOICE, null, Arrays.asList(Actions.WALK), null, null, null);
		Animal chicken = factory.getAnimal(chickenAttributes);
		
		
		try {
			assertTrue((((Bird)duck).speak()).contains("Quack, quack"));
			assertTrue((((Bird)duck).swim()).contains(Actions.SWIM.getDescription()));
			
			assertTrue((((Bird)chicken).speak()).contains("Cluck, cluck"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(expected = CustomException.class)
	public void chickenDoNotFLy() throws CustomException{
		Attributes chickenAttributes = 
				new Attributes(AnimalType.CHICKEN, Voice.BASIC_VOICE, null, Arrays.asList(Actions.WALK), null, null, null);
		Animal chicken = factory.getAnimal(chickenAttributes);
		String val = ((Bird)chicken).fly();
	}
	
	
	@Test
	public void roosterDifferentThanChicken() {
		
		Attributes roosterAttributes = 
				new Attributes(AnimalType.ROOSTER, Voice.BASIC_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY), null, null, null);
		Animal rooster = factory.getAnimal(roosterAttributes);
		
		
		try {
			assertTrue((((Bird)rooster).speak()).contains("Cock-a-doodle-doo"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void parrotWithDogCatAndRooster() {
		
		Attributes parrotWithDogAtt = 
				new Attributes(AnimalType.PARROT, Voice.LEARNABLE_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY), AnimalType.DOG, null, null);
		Animal parrotWithDog = factory.getAnimal(parrotWithDogAtt);
		
		Attributes parrotWithCatAtt = 
				new Attributes(AnimalType.PARROT, Voice.LEARNABLE_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY), AnimalType.CAT, null, null);
		Animal parrotWithCat = factory.getAnimal(parrotWithCatAtt);
		
		Attributes parrotWithRooAtt = 
				new Attributes(AnimalType.PARROT, Voice.LEARNABLE_VOICE, null, Arrays.asList(Actions.WALK, Actions.FLY), AnimalType.ROOSTER, null, null);
		Animal parrotWithRooster = factory.getAnimal(parrotWithRooAtt);
		
		
		try {
			assertTrue((((Bird)parrotWithDog).speak()).contains("Woof, woof"));
			assertTrue((((Bird)parrotWithCat).speak()).contains("Meow"));
			assertTrue((((Bird)parrotWithRooster).speak()).contains("Cock-a-doodle-doo"));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
