package com.customer.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.Entity.ServiceRequest;

@Repository
public interface ServiceReqRepository extends JpaRepository<ServiceRequest, Integer> {
	@Query("select D from ServiceRequest D where D.customerid=:cid")
	List<ServiceRequest> findreqbycid(int cid);

	@Query("select D from ServiceRequest D where D.customerid=:cid and D.reqStatus=:status")
	List<ServiceRequest> findreqbystatus(int cid, String status);

	@Query("select D from ServiceRequest D where D.customerid=:customerid and D.requestId=:reqid")
	Optional<ServiceRequest> fetchrequest(int customerid, int reqid);

	

}
