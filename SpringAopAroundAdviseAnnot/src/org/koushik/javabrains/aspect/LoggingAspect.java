package org.koushik.javabrains.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

@After("allGetters()")	
public void AfterAnnotationMethod() {
	//System.out.println("AfterAnnotationMethod() for allGetters Pointcut");
}

@Pointcut("execution(* get*())")
public void  allGetters() {} 

@Around("@annotation(org.koushik.javabrains.aspect.Loggable)")
public Object aroundAdviceMethod(ProceedingJoinPoint preecdingJoinPoint) {
	
	Object retuenValue = null ;
	System.out.println("Inside aroundAdviceMethod()...");

	try {
		System.out.println("Before preecdingJoinPoint.proceed()");
		
		retuenValue= preecdingJoinPoint.proceed();
		
		System.out.println("After preecdingJoinPoint.proceed()");
		
	} catch (Throwable e) {
		
		System.out.println("Catching preecdingJoinPoint.proceed() exception ");
	}
	 return retuenValue;
}
	
}	
	
	/*    
  
  
       ******************************************************************************
       *
       *
       *
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
	
	
	
	*
	*
    *    
    *   
    *   
    *************************************************************************************8  
        
        
        
        
        
        
        
        @Before(value = "execution(public String org.koushik.javabrains.model.Circle.getName())")
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
*/
