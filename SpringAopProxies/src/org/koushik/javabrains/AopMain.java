package org.koushik.javabrains;

import org.koushik.javabrains.model.Circle;
import org.koushik.javabrains.model.Triangle;
import org.koushik.javabrains.service.FactoryService;
import org.koushik.javabrains.service.ShapeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.koushik.javabrains.service.ShapeService;
                                   	
public class AopMain {

	public static void main(String[] args) 
	{

		//AbstractApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
		//ShapeService shapeService= ctx.getBean("shapeService",ShapeService.class);	
       // System.out.println("Name of Circle  "+shapeService.getCircle().getName() 
        //		+ "\nName of Triangle  "+shapeService.getTriangle().getName()
        	//	+ "\nType of Triangle  "+shapeService.getTriangle().getType());
	 //   shapeService.getCircle().setName("Prasanna");
	//	shapeService.getCircle().setNameAndReturnException("sending Exception");
		System.out.println("above");
		 FactoryService factoryService = new FactoryService();
		 System.out.println("below");
		ShapeService shapeService = (ShapeService) factoryService.getBeans("shapeService");
		Triangle triangle = (Triangle) factoryService.getBeans("triangle");
		Circle circle = (Circle) factoryService.getBeans("circle");	 
		//System.out.println("Name of Circle  "+shapeService.getCircle());  //.getCircle().getName() );
		//System.out.println("Name of Circle  "+				circle.getName() );
		
		
		shapeService.getCircle();
		
		
	}

}
