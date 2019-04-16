
package org.koushik.javabrains;

import org.koushik.javabrains.dao.HibernateDaoImpl;
import org.koushik.javabrains.dao.JdbcDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCdemo {

	public static void main(String[] args) 
	{
     	ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
	    //JdbcDaoImpl jdbcDaoImpl = ctx.getBean("JdbcDaoImpl" ,JdbcDaoImpl.class);
	    HibernateDaoImpl hibernateDaoImpl = (HibernateDaoImpl) ctx.getBean("HibernateDaoImpl" ,HibernateDaoImpl.class);
        
	    try {
	    	
	    	System.out.println("INSIDE THE MAIN TRY"+hibernateDaoImpl.getCirleCount());
	    	
	       		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("main class catch");
			e.printStackTrace();
		}
	}

}
