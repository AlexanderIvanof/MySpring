package com.alex.spring.jdbc.dao.impl;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.alex.spring.jdbc.Contact;
import com.alex.spring.jdbc.dao.ContactDAO;

public class PlainContactDAO implements ContactDAO {

	private static Properties props = new Properties();
	private static String filePath = "src/main/resources/jdbc/spring_db.properties";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			props.load(new FileReader(filePath));
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PlainContactDAO() {
	}

	@Override
	public List<Contact> findAll() {
		List<Contact> result = new ArrayList<>();
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("select * from contact");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setFirstName(rs.getString("first_name"));
				contact.setLastName(rs.getString("last_name"));
				contact.setBirthDate(rs.getDate("birth_date"));
				result.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}

		return result.isEmpty() ? null : result;
	}

	@Override
	public List<Contact> findByFirstName(String firstName) {
		return null;
	}

	@Override
	public void insert(Contact contact) {
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("incert into contact(first_name, last_name, birth_date)" +
					" values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, contact.getFirstName());
			stmt.setString(2, contact.getLastName());
			stmt.setDate(3, contact.getBirthDate());
			stmt.execute();
			ResultSet generKeys = stmt.getGeneratedKeys();
			
			if(generKeys.next()){
				contact.setId(generKeys.getLong(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
	}

	@Override
	public void update(Contact contact) {
	}

	@Override
	public void delete(Long contactId) {
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("delete from contact where id=?");
			stmt.setLong(1, contactId);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}

	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(props.getProperty("jdbc.mysql.url"),
				props.getProperty("jdbc.mysql.username"),
				props.getProperty("jdbc.mysql.password"));
	}

	private void closeConnection(Connection conn) {
		if (conn == null) {
			return;
		}

		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

	@Override
	public String findFirstNameByID(Long id) {
		return null;
	}

	@Override
	public List<Contact> findAllWithDetail() {
		return null;
	}
}
