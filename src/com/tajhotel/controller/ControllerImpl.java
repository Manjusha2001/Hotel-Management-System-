package com.tajhotel.controller;

import java.util.Scanner;

import com.tajhotel.dao.Customer;
import com.tajhotel.service.Iservice;
import com.tajhotel.service.ServiceImpl;

public class ControllerImpl implements IController{
        
	Scanner sc=new Scanner(System.in);
    Iservice service =new ServiceImpl();
    
    public void insert() {
    	System.out.println("Id :: ");
    	int id=sc.nextInt();
    	
    	System.out.println("Name :: ");
    	String name=sc.next();
    	
    	System.out.println("Age :: ");
    	int age=sc.nextInt();
    	
    	System.out.println("City :: ");
    	String city=sc.next();
    	
    	System.out.println("Status :: ");
    	String status=sc.next();
    	
    	Customer c1=new Customer();
    	c1.setId(id);
    	c1.setName(name);
    	c1.setAge(age);
    	c1.setCity(city);
    	c1.setStatus(status);
    	
    	int rowAffect = service.insert(c1);
    	
    	if(rowAffect != 0) {
    		System.out.println("Data inserted Successfully");
    	}else {
    		System.out.println("Data Insertion Failed");
    	}
    	
    }
    public void select() {
    	System.out.println("Enter ID :: ");
    	int id =sc.nextInt();
    	
    	Customer c1=service.select(id);
    	
    	if(c1.getName() != null) {
    	//System.out.println(c1);
    	System.out.println("ID\tNAME\tAGE\tCITY\tSTATUS");
    	System.out.println(c1.getId()+"\t"+c1.getName()+"\t"+c1.getAge()+"\t"+c1.getCity()+"\t"+c1.getStatus());
    	
    	}
    	else {
    		System.out.println("Recored not found");
    	}
    }
	public void delete() {

		boolean flag =false;
		int rowAffect =0;
		System.out.println("Enter id :: ");
		int id =sc.nextInt();
		
		Customer c1 =service.select(id);
		
		if(c1.getName() != null) {
			System.out.println("ID\tName\tAGE\tCITY\tSTATUS");
			System.out.println(c1.getId()+"\t"+c1.getName()+"\t"+c1.getAge()+"\t"+c1.getCity()+"\t"+c1.getStatus());
			flag=true;
		}
		else {
			System.out.println("Record not Found");
		}

    	if(flag) {
    		System.out.println("do you want to delet this Record?[Y/N]");
    		String s=sc.next();
    		if(s.equalsIgnoreCase("y")) {
    		           rowAffect =service.delete(id);
    		}
    
    	}
    	if(rowAffect > 0) {
    		System.out.println("Record Deleted succesful");
    	}else {
    		System.out.println("Record Deletion Failed");
    	}
    	
    }
    public void update() {
    	System.out.println("1.Status update \n 2.Name update \n 3.Age update \n 4.City update");
    	System.out.println("Enter your Choise :: ");
    	int x=sc.nextInt();
    	int rowAffect=service.update(x);
    	if(rowAffect>0) {
    		System.out.println("Record update");
    	}else {
    		System.out.println("Record updation failed ");
    	}
    }
}
