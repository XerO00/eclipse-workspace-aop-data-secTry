package org.koushik.javabrains.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circle {
   
	private String name;
    @Id
	private int id; 

public Circle() {}

public Circle(int id , String name) {
	this.id=id;
	this.name=name;
}

public int getId() {
	   System.out.println("Circle getId()"+ id);
		return id;
	}

	public void setId(int id) {
		System.out.println("Circle setID "+ id);
		this.id = id;
	}

public String getName()
   {	
	    System.out.println("Circle getName");
		return name;
	}

	public void setName(String name) 
	{ 
		int count=0;
		this.name = name;
		System.out.println("Circle setName for " + name);
	    count++;	
	}
	


	
}
