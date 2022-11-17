package com.customer.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ServiceRequest {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	private String reqName;
	private String reqdescription;
	private String servicetype;
	private String assignedto;
	private String reqStatus;
	private Date date;
	private String customername;
	private int customerid;
	
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getReqName() {
		return reqName;
	}
	public void setReqName(String reqName) {
		this.reqName = reqName;
	}
	public String getReqdescription() {
		return reqdescription;
	}
	public void setReqdescription(String reqdescription) {
		this.reqdescription = reqdescription;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getAssignedto() {
		return assignedto;
	}
	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}
	
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ServiceRequest [requestId=" + requestId + ", reqName=" + reqName + ", reqdescription=" + reqdescription
				+ ", servicetype=" + servicetype + ", assignedto=" + assignedto + ", reqStatus=" + reqStatus + ", date="
				+ date + ", customername=" + customername + ", customerid=" + customerid + "]";
	}
	
	
}
