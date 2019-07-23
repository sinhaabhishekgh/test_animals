package com.example.manage.animals.attributes.entity;

public enum Voice {

	NO_VOICE("Doesnt speak"), BASIC_VOICE("Basic Voice"), LEARNABLE_VOICE("Ability to learn speak"), SING("Ability to Sing as well");
	
	private String description; 
	  
    public String getDescription() 
    { 
        return this.description; 
    } 
  
    private Voice(String description) 
    { 
        this.description = description; 
    } 
}
