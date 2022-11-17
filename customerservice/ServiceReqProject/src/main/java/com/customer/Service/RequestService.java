package com.customer.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Clients.ServiRequestClient;
import com.customer.Entity.Customer;
import com.customer.Entity.ServiceRequest;
import com.customer.Exceptions.ServiceExceptions;
import com.customer.Repository.ServiceReqRepository;

@Service
public class RequestService {
	@Autowired
	private ServiceReqRepository Reqrepo;
@Autowired
private ServiRequestClient client;
public ServiceRequest createReqByCustomer(int customerid, ServiceRequest reqdetails) throws ServiceExceptions{
	java.util.Optional<Customer> customer= client.getCustomerByID(customerid);
	String customername=customer.get().getCustomername();
	ServiceRequest Reqdetails = new ServiceRequest();
	if (!customer.isEmpty()) {
 if (reqdetails.getServicetype() != null) {
	Reqdetails.setReqName(reqdetails.getReqName());
    Reqdetails.setCustomername(customername);
	Reqdetails.setCustomerid(customerid);
	Reqdetails.setReqdescription(reqdetails.getReqdescription());
	Reqdetails.setReqStatus(reqdetails.getReqStatus());
	Reqdetails.setAssignedto(reqdetails.getAssignedto());
	Reqdetails.setServicetype(reqdetails.getServicetype());
	Date date = new Date();
	Reqdetails.setDate(date);
	Reqrepo.save(Reqdetails);
 }
 else {
	 throw new ServiceExceptions("give all details");
 }
	}
	else {
		throw new ServiceExceptions("invalid customerId ");
	}
	return Reqdetails;
}
public List<ServiceRequest> getRequests() {
	// TODO Auto-generated method stub
	return Reqrepo.findAll();
}
public List<ServiceRequest> getrequestbycid(int cid) {
	// TODO Auto-generated method stub
	return Reqrepo.findreqbycid(cid);
}
public List<ServiceRequest> getrequestbystatus(int cid, String status) {
	// TODO Auto-generated method stub
	return Reqrepo.findreqbystatus(cid,status);
}
public ServiceRequest updatereqDetails(int customerid, int reqid, ServiceRequest reqdetails) {
	// TODO Auto-generated method stub
	Optional<ServiceRequest> request=Reqrepo.fetchrequest(customerid,reqid);
	if (!request.isEmpty()) {
		if(reqdetails.getAssignedto() != null){
			request.get().setAssignedto(reqdetails.getAssignedto());
		}
		if(reqdetails.getReqdescription()!=null) {
			request.get().setReqdescription(reqdetails.getReqdescription());
		}
		if(reqdetails.getServicetype()!=null) {
			request.get().setServicetype(reqdetails.getServicetype());
		}
		if(reqdetails.getReqName()!=null) {
			request.get().setReqName(reqdetails.getReqName());
		}
		if(reqdetails.getReqStatus()!=null) {
			request.get().setReqStatus(reqdetails.getReqStatus());
		}
		
	}
	return Reqrepo.save(request.get());
}
public String deletereq(int cid, int reqid) throws ServiceExceptions{
	Optional<ServiceRequest> req=Reqrepo.fetchrequest(cid, reqid);
	if(!req.isEmpty()) {
		Reqrepo.deleteById(req.get().getRequestId());
		return "deleted successfully";
	}else {
		return "req id not found";
	}
	
}
public Optional<ServiceRequest> findrequestbyid(int reqid) {
	// TODO Auto-generated method stub
	return Reqrepo.findById(reqid);
}
}
