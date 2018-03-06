package com.jwt.persistence;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jwt.domain.*;

public class ProductDAO {

	private ConnectionFactory connFactory = new ConnectionFactory();
	private Connection conn;

	public ArrayList<Product> allProducts() throws SQLException, ClassNotFoundException {
		conn = connFactory.getConnection();
		ArrayList<Product> products = new ArrayList<Product>();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Product");
		while (rs.next()) {
			Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("image"), rs.getInt("category_id"), rs.getDouble("price"));
			products.add(product);
		}
		return products;
	}
}
