package com.alex.spring.jdbc.annotation;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

public class FirstNameById extends SqlFunction<String> {

	private static final String SQL_FUNCTION_CALL =
			"select getfirstnamebyid(?)";
	
	public FirstNameById(DataSource dataSource) {
		super(dataSource, SQL_FUNCTION_CALL);
		super.declareParameter(new SqlParameter(Types.INTEGER));
		compile();
	}
}
