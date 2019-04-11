package org.koushik.javabrains.service;

import org.koushik.javabrains.aspect.LoggingAspect;
import org.koushik.javabrains.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		// TODO Auto-generated method stub
	    new LoggingAspect().loggingAspectBeforeAnnotationProxy();
		return super.getCircle();
	}	
}
