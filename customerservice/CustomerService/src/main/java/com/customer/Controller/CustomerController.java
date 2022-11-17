package com.customer.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Customer;

import com.customer.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerservice;

	@PostMapping("/register")
	public List<String> registerUser(@RequestBody Customer signUp) {

		Customer customer = new Customer();
		customer.setCustomername(signUp.getCustomername());
		customer.setPassword(signUp.getPassword());
		customer.setAddress(signUp.getAddress());
		customer.setState(signUp.getState());
		customer.setCountry(signUp.getCountry());
		customer.setEmailId(signUp.getEmailId());
		customer.setPan(signUp.getPan());
		customer.setContactnumber(signUp.getContactnumber());
		customer.setDob(signUp.getDob());
		customer.setContactPreference(signUp.getContactPreference());

		customerservice.save(customer);
		List<String> l = new ArrayList<String>();
		l.add("User registered successfully");
		return l;
	}

	@PostMapping("/login")
	public List<String> Login(@RequestBody Customer author) {
		String username = author.getCustomername();
		String password = author.getPassword();
		String pwd = customerservice.authenticateuser(username, password);
		// return pwd;
		List<String> l = new ArrayList<String>();
		if (pwd != null) {
			if (pwd.equals(password)) {
				l.add("User logged in successfully");
				return l;

			} else {
				l.add("failed to login");
				return l;
			}
		} else {
			l.add("Username not exists");
			return l;
		}
	}

	@GetMapping("/getCustomers")
	public List<Customer> getbooks() {
		return customerservice.getAllCustomers();
	}

	@GetMapping("/getcustomerid/{cid}")
	public Optional<Customer> getCustomerByID(@PathVariable int cid) {
		return customerservice.getCustomerById(cid);
	}
	
	@PutMapping("/updatecustomerdetails/{cid}")
	public Customer updatereq(@PathVariable int cid,@RequestBody Customer customer) {
		Customer c=customerservice.updatecustomerDetails(cid, customer);
		return c;
	}
}
