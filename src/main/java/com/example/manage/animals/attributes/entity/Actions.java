package com.example.manage.animals.attributes.entity;

public enum Actions {

	WALK("I am walking"), RUN("I am running"), FLY("I am flying"), SWIM("I am swiming"), CRAWL("I am crawling");
	
	private String description; 
	  
    public String getDescription() 
    { 
        return this.description; 
    } 
  
    private Actions(String description) 
    { 
        this.description = description; 
    } 
}
