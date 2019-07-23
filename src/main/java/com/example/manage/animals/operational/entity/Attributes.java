package com.example.manage.animals.operational.entity;

import java.io.Serializable;
import java.util.List;

import com.example.manage.animals.attributes.entity.Actions;
import com.example.manage.animals.attributes.entity.AnimalType;
import com.example.manage.animals.attributes.entity.Color;
import com.example.manage.animals.attributes.entity.Dimension;
import com.example.manage.animals.attributes.entity.Location;
import com.example.manage.animals.attributes.entity.Voice;

public class Attributes implements Serializable{


	private static final long serialVersionUID = -945054963033294384L;

	private AnimalType type;
	
	private Voice voice;
	
	private Color color;
	
	private List<Actions> actions;
	
	private AnimalType neighbour;
	
	private Location location;
	
	private Dimension dimension;

	public Attributes(AnimalType type, Voice voice, Color color, List<Actions> actions, AnimalType neighbour,
			Location location, Dimension dimension) {
		super();
		this.type = type;
		this.voice = voice;
		this.color = color;
		this.actions = actions;
		this.neighbour = neighbour;
		this.location = location;
		this.dimension = dimension;
	}

	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
		this.type = type;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Actions> getActions() {
		return actions;
	}

	public void setActions(List<Actions> actions) {
		this.actions = actions;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public AnimalType getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(AnimalType neighbour) {
		this.neighbour = neighbour;
	}
	
	
	
}
