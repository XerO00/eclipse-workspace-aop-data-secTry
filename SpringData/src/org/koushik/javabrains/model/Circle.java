package org.koushik.javabrains.model;


public class Circle {

	private String name;
    private int id; 
  
   public int getId() {
	   System.out.println("Circle getId()");
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

public String getName()
   {
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
		System.out.println("Circle setName");
		
	}
	


	
}
