package org.koushik.javabrains.dao;

import java.util.*;
import java.sql.*;
import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.koushik.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class JdbcDaoImpl {
 
	    @Autowired
	    private  DataSource dataSource ;
	    
		private JdbcTemplate jdbcTemplate= new JdbcTemplate() ;
	    
		private NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
	    
		private  Connection connect = null;
	    private  Statement statement = null;
	    private  ResultSet resultSet = null;

	    public  void getCircle() throws Exception {
	        try {

                System.out.println("above the connection process");                   
	            connect = dataSource.getConnection();
	            PreparedStatement statement = connect.prepareStatement("SELECT * from circle");
	            resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {
	                String id = resultSet.getString("id");
	                String name = resultSet.getString("name");
	                System.out.println("Printing From JDBC connection DAO class");
	                System.out.println("ID: " + id);
	                System.out.println("NAME: " + name);
	            }
	            
	        } catch (Exception e) {

                System.out.println("Inside the catch of connection");
	        	e.printStackTrace();;
	        } finally {

                System.out.println("Inside finally");
	        	close();
	        
	        }
	    }

	    private  void close() {
	        try {

                System.out.println("Indide close method");
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (Exception e) {

                System.out.println("Inside close catch");
	        }

	    }


public DataSource getDataSource() {
	return dataSource;
}

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
    this.jdbcTemplate= new JdbcTemplate(dataSource);
    this.namedParameterJdbcTemplate = new  NamedParameterJdbcTemplate(dataSource);
}

public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
	return namedParameterJdbcTemplate;
}

public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
}

public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}


public Circle getCircleObject(int circleId) {
	
	System.out.println("getCircleObject Method started");
	String sql ="SELECT * from circle where id=?";
	System.out.println("TEST 1");
	jdbcTemplate.setDataSource(dataSource );
	//return  jdbcTemplate.queryForObject(sql,new Object[] {1}, );;
	System.out.println("TEST 2");
    return jdbcTemplate.queryForObject(sql,new Object[] {circleId}, new CircleMapper());
	
 }

public List<Circle> getAllCircle() {
 
	System.out.println("getAllCircle Method started");
	String sql ="SELECT * from circle";
	jdbcTemplate.setDataSource(dataSource );
	System.out.println("ALL CIRCLE TEST 1");
	return jdbcTemplate.query(sql, new CircleMapper());
	
}

private static final class CircleMapper implements org.springframework.jdbc.core.RowMapper<Circle>{

	@Override
	public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		
		System.out.println("TEST 3");
		Circle circle = new Circle();
		circle.setId(resultSet.getInt("ID"));
		circle.setName(resultSet.getString("NAME"));
		System.out.println("TEST 4 " +circle.getName());
		return circle;
	}
	}

public void setCircle(Circle circle) {
 
	System.out.println("Inserting Circle setCircle(Circle circle){} ");
	String sql ="insert into circle values(?,?)";
	jdbcTemplate.setDataSource(dataSource );
	//System.out.println("String= ")   ;  new Object[] {circle.getId(), circle.getName()}
 	jdbcTemplate.update(sql,new Object[] {circle.getId(), circle.getName()} ); 	
}	
 
public void createTriangle() {
	System.out.println("createTriangle() ");
	String sql ="create table triangle (id integer, name varchar(50))";
	jdbcTemplate.setDataSource(dataSource );
	jdbcTemplate.execute(sql);
    //String sql1 ="select * from triangle";
	//jdbcTemplate.execute(sql1);
	
}

public void insertCircleUsingNamedParameterJdbcTemplate(Circle circle)
  {
	System.out.println("First InsertCircleUsingNamedParameterJdbcTemplate");
	String sql ="insert into circle (id, name) values(:id, :name) ";
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
	jdbcTemplate.setDataSource(dataSource);
	namedParameterJdbcTemplate.update(sql, sqlParameterSource ); 	
    System.out.println("Finally InsertCircleUsingNamedParameterJdbcTemplate");
   }	
}





