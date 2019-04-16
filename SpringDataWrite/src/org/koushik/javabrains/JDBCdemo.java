package org.koushik.javabrains;

import java.util.Iterator;

import org.koushik.javabrains.dao.JdbcDaoImpl;
import org.koushik.javabrains.model.Circle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCdemo {

	public static void main(String[] args) 
	{
     	AbstractApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
	    JdbcDaoImpl jdbcDaoImpl = ctx.getBean("JdbcDaoImpl" ,JdbcDaoImpl.class);
        
	    try {
	    //	 jdbcDaoImpl.setCircle(new Circle(4,"Anand"));

	    	 System.out.println("MAIN TRY");
	    //	 System.out.println("value of first object ");
	    //	 jdbcDaoImpl.createTriangle();
	    		
	    	 //Iterator<Circle> it=jdbcDaoImpl.getAllCircle().iterator();
             jdbcDaoImpl.insertCircleUsingNamedParameterJdbcTemplate(new Circle(9,"Cody"));
	        } 
	    catch (Exception e)
	        {
			
	    	System.out.println("main class catch");
			e.printStackTrace();
	    	}
	}

}



/*
while(it.hasNext())
{
	   int count=0;
	System.out.println("Printing count of Iterator for "+count);
	count++;
}	    	 


*/