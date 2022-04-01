package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;
import com.cybage.model.ProductPojo;
import com.cybage.utilities.JDBCconnectivity;

public class ProductDaoImpl implements ProductDao {
	Connection con=JDBCconnectivity.getCon();
	Scanner sc=new Scanner(System.in);
	public void addProduct(ProductPojo product) throws SQLException {
		PreparedStatement pst=con.prepareStatement("insert into product(productname,price) values(?,?)");
		pst.setString(1, product.getName());
		pst.setDouble(2,product.getPrice());
		pst.executeUpdate();
		System.out.println("Product added Successfully");
	}
	public void displayProduct() throws SQLException{
		Statement state=con.createStatement();
		ResultSet res=state.executeQuery("select * from product");
		HashMap <Integer,ProductPojo> product=new HashMap<Integer,ProductPojo>();
		while(res.next())
		{
			product.put(res.getInt(1), new ProductPojo(res.getString(2),res.getDouble(3)) );
		}
		product.forEach(new BiConsumer<Integer, ProductPojo>() {
			public void accept(Integer key, ProductPojo value) {System.out.println("id "+key+" Product "+value.getName()+" Price "+value.getPrice());}
		});
	}
	
	public void updateProductName(int  id , String name) throws SQLException
	{
		PreparedStatement pst1=con.prepareStatement("update product set productname=? where id=?");
		pst1.setString(1,name);
		pst1.setInt(2,id);
		pst1.executeUpdate();
		System.out.println(" Product Name updated");
	}
	public void updadateProductPrice(int id, double price) throws SQLException {
		PreparedStatement pst2=con.prepareStatement("update product set price=? where id=?");
		pst2.setDouble(1,price);
		pst2.setInt(2,id);
		System.out.println(" Product Price updated");
	}
	public void deleteProduct(int id) throws SQLException {
		PreparedStatement pst2=con.prepareStatement("delete from product where id=?");
		pst2.setInt(1, id);
		pst2.executeUpdate();
	}
}
