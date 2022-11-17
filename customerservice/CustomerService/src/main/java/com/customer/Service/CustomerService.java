package com.customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.Customer;

import com.customer.Repository.CustomerRepository;



@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerrepo;

	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerrepo.save(customer);
	}

	public String authenticateuser(String username, String password) {

		String pwd = customerrepo.findByUsername(username);

		return pwd;
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerrepo.findAll();
	}

	public java.util.Optional<Customer> getCustomerById(int cid) {
		// TODO Auto-generated method stub
		return customerrepo.findById(cid);
	}

	public Customer updatecustomerDetails(int cid, Customer customer) {
		java.util.Optional<Customer> c1=customerrepo.findById(cid);
		// TODO Auto-generated method stub
		if(!c1.isEmpty()) {
			if(customer.getAddress()!=null) {
				c1.get().setAddress(customer.getAddress());
			}
			if(customer.getContactnumber()!=0) {
				c1.get().setContactnumber(customer.getContactnumber());
			}
			if(customer.getContactPreference()!=null) {
				c1.get().setContactPreference(customer.getContactPreference());
			}
			if(customer.getEmailId()!=null) {
				c1.get().setEmailId(customer.getEmailId());
			}
			if(customer.getPassword()!=null) {
				c1.get().setPassword(customer.getPassword());
			}
			if(customer.getCountry()!=null) {
				c1.get().setCountry(customer.getCountry());
			}
			if(customer.getCustomername()!=null) {
				c1.get().setCustomername(customer.getCustomername());
			}
			if(customer.getState()!=null) {
				c1.get().setState(customer.getState());
			}
			if(customer.getPan()!=null) {
				c1.get().setPan(customer.getPan());
			}
		}
		return customerrepo.save(c1.get());
	}
	

	
	
}
