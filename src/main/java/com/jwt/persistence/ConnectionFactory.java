package com.jwt.persistence;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		 try {
	            Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {
	            System.out.println("Class not found " + e);
	        }
		 String url = "jdbc:postgresql://ec2-79-125-110-209.eu-west-1.compute.amazonaws.com:5432/d9r13jlpn5bq9n";
		 Properties props = new Properties();
		 props.setProperty("user","lrspdxwbhbzgtk");
		 props.setProperty("password","7dc1f2651cd4f7a25d3993aa3e971b010ec6e8dc9961c1641460c469271102b7");
		 props.setProperty("ssl","true");
		 props.setProperty("sslfactory","org.postgresql.ssl.NonValidatingFactory");
		 Connection conn = DriverManager.getConnection(url, props);
		 return conn;
	}
	

}
