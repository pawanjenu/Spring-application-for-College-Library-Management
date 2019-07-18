package com.My.Library.request;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.My.Library.studentbook.Sbook;

@Entity
public class Request 
{
	@Id
	private String rid;
	public String status;
	
	@OneToOne
	private Sbook sbook;

	public Request() {}
	
	public Request(String rid,String status)
	{
		super();
		this.rid = rid;
		this.status = status;
	}
	
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Sbook getSbook() {
		return sbook;
	}

	public void setSbook(Sbook sbook) {
		this.sbook = sbook;
	}
}
