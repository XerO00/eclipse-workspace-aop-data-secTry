package org.koushik.javabrains.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("args(name)")
	public void StringArgumentMethod(String name)
	{
		System.out.println("StingArgumentMethod has been called for "+ name );
	} 
	
	@AfterReturning(pointcut="args(name)", returning= "ex")
	public void StringArgumentMethodForAfterAnnotation(String name, Exception ex)
	{
		System.out.println("StingArgumentMethodForAfterAnnotation has been called for "+ name
				+" " +
				ex.getMessage());
	} 
	
	@AfterThrowing(pointcut="args(name)", throwing= "ex")
	public void StringArgumentMethodForAfterThrowingAnnotation(String name, Exception ex)
	{
		System.out.println("StingArgumentMethodForAfterThrowingAnnotation has been called for "+ name  
				+ ex.toString());
	} 
	
}

/*@Before(value = "execution(public String org.koushik.javabrains.model.Circle.getName())")
public void loggingAdvice()
{
	System.out.println("Logging Advise class !");
}  

@Pointcut("within(org.koushik.javabrains.model.Circle)")
public void allCircleMethods() {}; 
	@Before("allCircleMethods()")
public void loggingSecAdvice(Joinpoint joinPoint)
{
	System.out.println("Logging sec Advise for!" + joinPoint.toString() );
}

@Pointcut("execution(* get*())")
public void  allCircleMethods() {}; 
*/
