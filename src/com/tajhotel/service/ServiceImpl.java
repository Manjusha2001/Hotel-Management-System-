package com.tajhotel.service;

import com.tajhotel.dao.Customer;
import com.tajhotel.persistance.Ipersistance;
import com.tajhotel.persistance.PersistanceImpl;


public class ServiceImpl implements Iservice {

	Ipersistance persistance=new PersistanceImpl();
	
	public int insert(Customer customer) {
		return persistance.insert(customer);
	}
	public Customer select(int id) {
		return persistance.select(id);
	}
	public int delete(int id) {
		return persistance.delete(id);
	}
	public int update(int id) {
		return persistance.update(id);
	}
	
}
