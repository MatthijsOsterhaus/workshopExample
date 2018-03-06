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
	
	public ArrayList<Customer> allCustomers() throws SQLException, ClassNotFoundException {
		conn = super.getConnection();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM customer");
		while (rs.next()) {
			Adress adress = new Adress(rs.getString("adress"), rs.getInt("streetnumber"), rs.getInt("id"));
			Customer customer = new Customer(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"),
					rs.getString("username"), rs.getString("password"), rs.getString("role"), adress);
			customers.add(customer);
		}
		// Adress adress = new Adress("Stromenlaan", 155);
		// Customer customer = new Customer("Sten", "Terwan", adress);
		// customers.add(customer);
		conn.close();
		return customers;
		
	}
	
	public int getCustomerID(String token) throws SQLException {
		int id = 0;
		PreparedStatement stmt = super.getConnection().prepareStatement("SELECT id FROM customer WHERE token = ?");
		stmt.setString(1, token);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			id = rs.getInt("id");
		}
		return id;		
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
