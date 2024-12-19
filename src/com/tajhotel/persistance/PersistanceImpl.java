package com.tajhotel.persistance;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tajhotel.dao.Customer;
import com.tajhotel.util.JdbcUtil;

public class PersistanceImpl implements Ipersistance{

	@Override
	public int insert(Customer customer) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		
		String insertSQLQuery ="Insert into customer value(?,?,?,?,?)";
		int rowAffect =0;
		try {
			connection =JdbcUtil.getConnection();
			if(connection != null) {
				pstmt =connection.prepareStatement(insertSQLQuery);
			}
			if(pstmt != null) {
				pstmt.setInt(1,customer.getId());
				pstmt.setString(2,customer.getName());
				pstmt.setInt(3,customer.getAge());
				pstmt.setString(4,customer.getCity());
				pstmt.setString(5,customer.getStatus());
				rowAffect=pstmt.executeUpdate();
				return rowAffect;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.cleanUp(connection,pstmt,null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rowAffect;
	}
	public Customer select(int id) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultset=null;
		Customer c1 =null;
		String selectSQLQuery ="select * from Customer where id =? ";
		try {
			connection =JdbcUtil.getConnection();
			pstmt=connection.prepareStatement(selectSQLQuery);
		if(connection != null){
			pstmt=connection.prepareStatement(selectSQLQuery);
		}
		if(pstmt != null) {
			pstmt.setInt(1,id);
			resultset = pstmt.executeQuery();
		}
		if(resultset != null) {
			c1=new Customer();
			while(resultset.next()) {
				c1.setId(resultset.getInt(1));
				c1.setName(resultset.getString(2));
				c1.setAge(resultset.getInt(3));
				c1.setCity(resultset.getString(4));
				c1.setStatus(resultset.getString(5));
			}
			return c1;
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.cleanUp(connection,pstmt,null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public int delete(int id) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		String deleteSQLQuey ="Delete from customer where id=?";
		int rowAffect =0 ;
		try {
			connection =JdbcUtil.getConnection();
			if(connection != null) {
				pstmt=connection.prepareStatement(deleteSQLQuey);
			}
			if(pstmt != null) {
				pstmt.setInt(1, id);
				rowAffect=pstmt.executeUpdate();
				return rowAffect;
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();

			}
		finally {
			try {
				JdbcUtil.cleanUp(connection,pstmt,null);
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
		return rowAffect;
		}
	public int update(int x) {
		Connection connection =null;
		PreparedStatement pstmt =null;
		String updateSQLQuery =null;
		Scanner sc =new Scanner(System.in);
		int rowAffect =0;
		
		try {
			connection =JdbcUtil.getConnection();
			if(x==1) {
				updateSQLQuery ="Update customer set status = ? = where id = ?";
				System.out.println("Enter id :: ");
				int id =sc.nextInt();
				System.out.println("Status :: ");
				String status =sc.next();
				if(connection != null) {
					pstmt = connection.prepareStatement(updateSQLQuery);
					pstmt.setString(1, status);
					pstmt.setInt(2, id);
				}
			}else if(x == 2) {
				updateSQLQuery="Update customer set Name = ? = where id = ? ";
				
				System.out.print("Enter id:: ");
				int id=sc.nextInt();
				
				System.out.println("Name :: ");
				String name =sc.next();
				if(connection != null) {
					pstmt =connection.prepareStatement(updateSQLQuery);
					pstmt.setString(1,name);
					pstmt.setInt(2, id);
				}
			}else if(x == 3) {
				updateSQLQuery="Update customer age  = ? = where id = ? ";
				
				System.out.print("Enter id:: ");
				int id=sc.nextInt();
				
				System.out.println("Age :: ");
				int age =sc.nextInt();
				if(connection != null) {
					pstmt =connection.prepareStatement(updateSQLQuery);
					pstmt.setInt(1,age);
					pstmt.setInt(2, id);
				}
			}else if(x == 4) {
				updateSQLQuery="Update customer set City = ? = where id = ? ";
				
				System.out.print("Enter id:: ");
				int id=sc.nextInt();
				
				System.out.println("City :: ");
				String City =sc.next();
				if(connection != null) {
					pstmt =connection.prepareStatement(updateSQLQuery);
					pstmt.setString(1,City);
					pstmt.setInt(2, id);
				}
			}
			if(pstmt != null) {
				rowAffect = pstmt .executeUpdate();
				return rowAffect;
			}


		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rowAffect;
	}
	}

