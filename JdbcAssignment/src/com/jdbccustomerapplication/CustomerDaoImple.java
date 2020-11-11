package com.jdbccustomerapplication;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CustomerDaoImple implements CustomerDao {

	
	private Connection connection;

	public CustomerDaoImple() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addCustomer(Customer customer){
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = connection
					.prepareStatement
					("insert into customerdetails(id,name,phone,email,dob,address,purchasecap) values (?,?,?,?,?,?,?)");
			pstmt.setInt(1,customer.getId());
			pstmt.setString(2,customer.getName());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getEmail());
			pstmt.setDate(5, new Date(customer.getDob().getTime()));
			pstmt.setString(6, customer.getAddress());
			pstmt.setDouble(7, customer.getPurchasecap());
			pstmt.executeUpdate();

		} catch (SQLException e) {
		   e.printStackTrace();
		}

		
	}

	@Override
	public void delCustomer(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> customer=getCustomerById(id);
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("delete from customer_details where id=?");
			pstmt.setInt(1,id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(int id, double purchase_capacity) {
		// TODO Auto-generated method stub
		Optional<Customer> customer=getCustomerById(id);
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("update customerdetails set purchasecap=? where id=?");
			pstmt.setDouble(1, purchase_capacity);
			pstmt.setInt(2,id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<>();
		Customer customer = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");

			while (rs.next()) {
				

				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
						rs.getDate("dob"),rs.getString("address"), rs.getDouble("purchasecap"));

				customers.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
		
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		Customer customer = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from customer where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
						rs.getDate("dob"),rs.getString("address"), rs.getDouble("purchasecap"));

				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(customer);
	}

	

	@Override
	public List<Customer> getSelectedCustomer(double purchasecap) {
		// TODO Auto-generated method stub
		        List<Customer> customers = new ArrayList<>();
				Customer customer = null;
				try {
					PreparedStatement pstmt = connection.prepareStatement("select * from customer where purchasecap>?");
					pstmt.setDouble(1, purchasecap);

					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
								rs.getDate("dob"),rs.getString("address"), rs.getDouble("purchasecap"));
						customers.add(customer);
						
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return customers;
			}

			
	}