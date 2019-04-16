package org.koushik.javabrains.dao;

import javax.persistence.Access;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {

	private SessionFactory sessionFactory;
	
	public int getCirleCount() {
	    
		System.out.println("HibernateDaoImpl class method getCircle");
	    String hql ="SELECT COUNT(*) FROM CIRCLE";
	    //jdbcTemplate.setDataSource(getDataSource());
        // int count = jdbcTemplate.queryForObject(sql, new Object[] {  }, Integer.class);   
	    Query query=getSessionFactory().openSession().createQuery(hql);
	    return (int) query.uniqueResult();   
	}
    @Autowired
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
