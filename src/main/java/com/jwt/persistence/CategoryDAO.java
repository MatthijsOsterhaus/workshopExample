package com.jwt.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jwt.domain.Category;
import com.jwt.domain.Product;

public class CategoryDAO extends ConnectionFactory {
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Product> allProducts = new ArrayList<Product>();
	private ArrayList<Product> products = new ArrayList<Product>();

	public ArrayList<Category> allCategories() throws SQLException {
		PreparedStatement stmt = super.getConnection().prepareStatement("SELECT * FROM category");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			PreparedStatement stmtP = super.getConnection()
					.prepareStatement("SELECT * FROM product WHERE category_id = ?");
			stmtP.setInt(1, rs.getInt("id"));
			ResultSet rsP = stmtP.executeQuery();
			while (rsP.next()) {
				Product product = new Product(rsP.getInt("id"), rsP.getString("name"), rsP.getString("image"),
						rsP.getInt("category_id"), rsP.getDouble("price"));
				allProducts.add(product);
				System.out.println(allProducts.size());
			}
			Category category = new Category(rs.getInt("id"), rs.getString("name"), allProducts);
			categories.add(category);
		}
		return categories;
	}
	public ArrayList<Product> allProductsPerCategory(int category_id) throws SQLException{
		allCategories();
		for(Category category : categories) {
			System.out.println("Category id = " + category.getId());
			if(category.getId() == category_id) {
				System.out.println("yes");
				for(Product product : category.getProducts()) {
					products.add(product);
					System.out.println(product.getName());
				}
			}
		}
		return products;
	}
}
