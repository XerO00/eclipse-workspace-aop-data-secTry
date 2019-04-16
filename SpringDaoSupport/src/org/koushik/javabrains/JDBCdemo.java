
package org.koushik.javabrains;

import org.koushik.javabrains.dao.JdbcDaoImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCdemo {

	public static void main(String[] args) 
	{
     	AbstractApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
	    JdbcDaoImpl jdbcDaoImpl = ctx.getBean("JdbcDaoImpl" ,JdbcDaoImpl.class);
        
	    try {
	    	 System.out.println("Inside the main try and printing list size"+   jdbcDaoImpl.getAllCircle().size());
	       		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("main class catch");
			e.printStackTrace();
		}
	}

}
