package org.koushik.javabrains.dao;

import javax.sql.DataSource;

//this is unnecessary class to avoid red cross sign error


import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class SimpleJdbcDaoImpl extends SimpleJdbcCall{

	public SimpleJdbcDaoImpl(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

}
