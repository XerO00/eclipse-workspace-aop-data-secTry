package org.koushik.javabrains.service;

import org.koushik.javabrains.model.Circle;
import org.koushik.javabrains.model.Triangle;

public class ShapeService {
    
	private Triangle triangle;
	
	private Circle circle ;

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	

}
