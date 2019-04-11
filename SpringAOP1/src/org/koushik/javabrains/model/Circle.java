package org.koushik.javabrains.model;

import javax.management.RuntimeErrorException;

public class Circle 
{
   private String name;
  
   public String getName()
   {
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
		System.out.println("From Circle Setter");
		throw new RuntimeException();
	}
	
	public RuntimeException setNameAndReturnException(String name) 
	{
		this.name = name;
		System.out.println("From Circle Setter");
		return new RuntimeException();
	}
}
