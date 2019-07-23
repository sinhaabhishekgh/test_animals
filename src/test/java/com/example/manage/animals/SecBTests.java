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
import com.example.manage.animals.interfaces.Fish;
import com.example.manage.animals.interfaces.Mammal;
import com.example.manage.animals.interfaces.concrete.impl.AnimalFactory;
import com.example.manage.animals.operational.entity.Attributes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecBTests {
	
	@Autowired
	private AnimalFactory factory;

	@Test
	public void fishCanSwim() throws Exception{
		
		Attributes fishAttributes = 
				new Attributes(AnimalType.FISH, null, null, Arrays.asList(Actions.SWIM), null, null, null);
		Animal fish = factory.getAnimal(fishAttributes);
		
			assertTrue((((Fish)fish).swim()).contains(Actions.SWIM.getDescription()));
		
	}
	
	
	@Test
	public void sharkAndClownfishDiffDimension() throws Exception{
		
		Attributes sharkAttributes = 
				new Attributes(AnimalType.SHARK, null, Color.GREY, Arrays.asList(Actions.SWIM), null, null, Dimension.LARGE);
		Animal shark = factory.getAnimal(sharkAttributes);
		
		Attributes clownfishAttributes = 
				new Attributes(AnimalType.CLOWNFISH, null, Color.MULTI_COLOR, Arrays.asList(Actions.SWIM), null, null, Dimension.SMALL);
		Animal clownfish = factory.getAnimal(clownfishAttributes);
		
			assertTrue((((Fish)shark).toString()).contains(Dimension.LARGE.name()));
			assertTrue((((Fish)clownfish).toString()).contains(Dimension.SMALL.name()));
			assertTrue((((Fish)shark).toString()).contains(Color.GREY.name()));
			assertTrue((((Fish)clownfish).toString()).contains(Color.MULTI_COLOR.name()));
		
	}
	
	@Test
	public void dolphinCanSwim() throws Exception{
		
		Attributes dolphinAttributes = 
				new Attributes(AnimalType.DOLPHIN, null, null, Arrays.asList(Actions.SWIM), null, null, null);
		Animal dolphin = factory.getAnimal(dolphinAttributes);
		
			assertTrue((((Mammal)dolphin).swim()).contains(Actions.SWIM.getDescription()));
		
	}
	

}
