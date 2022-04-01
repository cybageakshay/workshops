package com.cybage.dao;

import java.sql.SQLException;
import com.cybage.model.ProductPojo;

public interface ProductDao {
	public void addProduct(ProductPojo product) throws SQLException;
	public void displayProduct() throws SQLException;
	public void updateProductName(int id , String name) throws SQLException;
	public void updadateProductPrice(int id, double price ) throws SQLException;
	public void deleteProduct(int id) throws SQLException;
}
