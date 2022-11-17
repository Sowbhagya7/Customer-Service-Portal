package com.customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.ServiceRequest;
import com.customer.Exceptions.ServiceExceptions;
import com.customer.Service.RequestService;

@RestController
@RequestMapping("/customers/serviceRequest")
public class ServicerequestController {
	@Autowired
	private RequestService Reqservice;

	@PostMapping("/{customerid}/createrequest")
	public ServiceRequest createSR(@PathVariable int customerid, @RequestBody ServiceRequest reqdetails) throws ServiceExceptions {

		ServiceRequest request = Reqservice.createReqByCustomer(customerid, reqdetails);
		return request;
	}
	@GetMapping("/findrequestbyID/{reqid}")
	public Optional<ServiceRequest> findrequests(@PathVariable int reqid) {
		Optional<ServiceRequest> request=Reqservice.findrequestbyid(reqid);
		return request;
	}

	@GetMapping("/getlistofrequests")
	public List<ServiceRequest> getRequests() {
		return Reqservice.getRequests();
	}

	@GetMapping("/findReqbycustomerid/{cid}")
	public List<ServiceRequest> getrequestbycid(@PathVariable int cid) {
		return Reqservice.getrequestbycid(cid);
	}

	@GetMapping("/findReqby/{cid}/{status}")
	public List<ServiceRequest> getrequestbystatus(@PathVariable int cid, @PathVariable String status) {
		return Reqservice.getrequestbystatus(cid, status);
	}

	@PutMapping("/{customerid}/updaterequest/{reqid}")
	public ServiceRequest updatereq(@PathVariable int customerid,@PathVariable int reqid,@RequestBody ServiceRequest reqdetails) {
		ServiceRequest req=Reqservice.updatereqDetails(customerid, reqid, reqdetails);
		return req;
	}
	
	@DeleteMapping("/deletereq/{cid}/{reqid}")
	public String deletereq(@PathVariable int cid,@PathVariable int reqid) throws ServiceExceptions {
		return Reqservice.deletereq(cid,reqid);
	}
}
