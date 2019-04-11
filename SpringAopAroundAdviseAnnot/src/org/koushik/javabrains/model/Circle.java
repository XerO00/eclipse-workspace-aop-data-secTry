package org.koushik.javabrains.model;

import java.lang.annotation.Annotation;

import javax.management.RuntimeErrorException;

import org.koushik.javabrains.aspect.Loggable;
import org.springframework.context.annotation.Lazy;

public class Circle {
   private String name;
  
   @Loggable()
   public String getName()
   {
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
		System.out.println("From Circle Setter");
		//throw new RuntimeException();
	}
	
	public RuntimeException setNameAndReturnException(String name) 
	{
		this.name = name;
		System.out.println("From Circle Setter with RuntimeException return type");
		return new RuntimeException();
	}

	
}
