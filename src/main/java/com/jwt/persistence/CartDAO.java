package com.jwt.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jwt.domain.Cart;
import com.jwt.domain.Category;
import com.jwt.domain.Product;
import com.jwt.persistence.CustomerDAO;

public class CartDAO extends ConnectionFactory {

	private ArrayList<Product> allProducts = new ArrayList<Product>();
	private Cart cart;

	public Cart getCartProducts(int id) throws SQLException {
		PreparedStatement stmt = super.getConnection().prepareStatement("SELECT * FROM cart WHERE customer_id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			PreparedStatement stmtP = super.getConnection().prepareStatement("SELECT * FROM product WHERE id = ?");
			stmtP.setInt(1, rs.getInt("id"));
			ResultSet rsP = stmtP.executeQuery();
			while (rsP.next()) {
				Product product = new Product(rsP.getInt("id"), rsP.getString("name"), rsP.getString("image"),
						rsP.getInt("category_id"), rsP.getDouble("price"));
				allProducts.add(product);
			}
			cart = new Cart(rs.getInt("id"), rs.getInt("customer_id"), allProducts);
		}
		return cart;
	}
	
	
}
