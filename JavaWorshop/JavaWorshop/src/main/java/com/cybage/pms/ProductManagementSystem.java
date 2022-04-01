package com.cybage.pms;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.cybage.dao.ProductDaoImpl;
import com.cybage.model.ProductPojo;
import com.cybage.utilities.JDBCconnectivity;

public class ProductManagementSystem {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=JDBCconnectivity.getCon();
		System.out.println("Connection Established");
		con.close();
		ProductDaoImpl test =new ProductDaoImpl();
		boolean flag=true;
		while(flag)
		{
			System.out.println("1) Enter a new Product 2) Display Products 3) Update Product details 4) Delete product 5) Exit");
			switch(sc.nextInt())
			{
			case 1: System.out.println("Enter the name of product and price of product");
					ProductPojo p= new ProductPojo(sc.next(),sc.nextInt());
					test.addProduct(p);
					break;
			case 2: test.displayProduct();
			break;
			case 3: System.out.println("1) Update Product name 2) Update price");
					switch(sc.nextInt())
					{
					case 1: System.out.println("Enter the id and  name to update");
							test.updateProductName(sc.nextInt(), sc.next());
					break;
					case 2: System.out.println("Enter the id and  price to update");
							test.updadateProductPrice(sc.nextInt(),sc.nextDouble());
					break;
					}
					break;
			case 4: System.out.println("Enter product id");
			        test.deleteProduct(sc.nextInt());
			        break;
			case 5: con.close();
					  sc.close();
					  flag=false;
					  break;
					 
			}
		}
	}

}
