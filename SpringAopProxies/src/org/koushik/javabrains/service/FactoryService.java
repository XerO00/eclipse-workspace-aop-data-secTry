package org.koushik.javabrains.service;

import org.koushik.javabrains.model.Circle;
import org.koushik.javabrains.model.Triangle;

public class FactoryService {

	public Object getBeans(String beanName) {
		
		if(beanName.equals("shapeService")) {return new ShapeServiceProxy();} 
		if(beanName.equals("circel")) {return new Circle();} 
		if(beanName.equals("triangle")) {return new Triangle();} 
			
			return null;
	}
}
