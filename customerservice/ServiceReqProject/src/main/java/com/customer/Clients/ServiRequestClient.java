package com.customer.Clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.Entity.Customer;


@FeignClient("Customer-Service")
public interface ServiRequestClient {
	@GetMapping("/customer/getcustomerid/{cid}")
	Optional<Customer> getCustomerByID(@PathVariable int cid);
}
