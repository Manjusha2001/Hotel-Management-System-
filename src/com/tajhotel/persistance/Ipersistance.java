package com.tajhotel.persistance;

import com.tajhotel.dao.Customer;

public interface Ipersistance {
	public int insert(Customer customer);
	
	public Customer select(int id);
	
	public int delete(int id);
	
	public int update(int id);

}
