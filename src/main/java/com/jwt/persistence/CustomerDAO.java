package com.jwt.persistence;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jwt.domain.*;




public class CustomerDAO extends ConnectionFactory{

	private ConnectionFactory connFactory = new ConnectionFactory();
	private Connection conn;
	
	
	public Customer getCustomer(int id) throws Exception {
        	Connection connect = null;
        	connect = getConnection();
        	Customer customer = null;
            

        	PreparedStatement stmt = connect.prepareStatement("SELECT firstname, lastname, adress, streetnumber FROM customer WHERE id = ?;");
    		stmt.setInt(1, id);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    		customer = new Customer(rs.getString("firstname"), rs.getString("lastname"),rs.getString("adress"), rs.getInt("streetnumber"));
    		}
    		connect.close();
    	return customer;
    }
	
	public void AddCustomer(String naam, String achternaam, String adres, int streetnumber ) throws Exception {
        try {
        	Connection connect = null;
        	connect = getConnection();

        PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Customer(id, firstname, lastname, username, password, adress, streetnumber, role) VALUES(?,?, ?, ?, ?, ?,?,?)");
        preparedStatement.setInt(1, 5);
        preparedStatement.setString(2, naam);
        preparedStatement.setString(3, achternaam);
        preparedStatement.setString(4, "test");
        preparedStatement.setString(5, "test");
        preparedStatement.setString(6, adres);
        preparedStatement.setInt(7, streetnumber);
        preparedStatement.setString(8, "test");

          preparedStatement.executeUpdate();
          System.out.println("Gelukt!");
          connect.close();


        } catch (Exception e) {
            throw e;
        } 

    }
	
	public void DeleteCustomer(int id) throws Exception {
        try {
        	Connection connect = null;
        	connect = getConnection();
            

          PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM customer WHERE id = ?;");
        preparedStatement.setInt(1, id);

          preparedStatement.executeUpdate();
          System.out.println("Gelukt!");
          connect.close();


        } catch (Exception e) {
            throw e;
        } 

    }
	public void UpdateCustomer(String naam, String achternaam, String adres, int streetnumber, int id) throws Exception {
        try {
        	Connection connect = null;
        	connect = getConnection();
            

          PreparedStatement preparedStatement = connect.prepareStatement("UPDATE CUSTOMER SET firstname = ?, lastname = ?, adress = ?, streetnumber = ? WHERE id = ?;");
          preparedStatement.setString(1, naam);
          preparedStatement.setString(2, achternaam);
  
          preparedStatement.setString(3, adres);
          preparedStatement.setInt(4, streetnumber);
          preparedStatement.setInt(5, id);
          preparedStatement.executeUpdate();
          System.out.println("Gelukt!");
          connect.close();


        } catch (Exception e) {
            throw e;
        } 

    }
}
