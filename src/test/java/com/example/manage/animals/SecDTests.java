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
public class SecDTests {
	
	@Autowired
	private AnimalFactory factory;

	@Test
	public void butterflyCanFly() throws Exception{
		
		Attributes butterflyAttributes = 
				new Attributes(AnimalType.BUTTERFLY, Voice.NO_VOICE, null, Arrays.asList(Actions.FLY), null, null, null);
		Animal butterfly = factory.getAnimal(butterflyAttributes);
		
			assertTrue((((Bird)butterfly).fly()).contains(Actions.FLY.getDescription()));
		
	}
	
	@Test(expected = CustomException.class)
	public void butterCannotSpeak() throws Exception{
		
		Attributes butterflyAttributes = 
				new Attributes(AnimalType.BUTTERFLY, Voice.NO_VOICE, null, Arrays.asList(Actions.FLY), null, null, null);
		Animal butterfly = factory.getAnimal(butterflyAttributes);
			String speak = ((Bird)butterfly).speak();
		
	}
	
	@Test(expected = CustomException.class)
	public void catterPillarCannotFly() throws Exception{
		
		Attributes caterpilarAttributes = 
				new Attributes(AnimalType.CATTERPILOR, Voice.NO_VOICE, null, Arrays.asList(Actions.CRAWL), null, null, null);
		Animal catterpilar = factory.getAnimal(caterpilarAttributes);
			String speak = ((Bird)catterpilar).fly();
		
	}
	
}
