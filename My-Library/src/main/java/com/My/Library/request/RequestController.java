package com.My.Library.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.My.Library.studentbook.Sbook;
import com.My.Library.studentbook.SbookService;


@RestController
public class RequestController 
{
	@Autowired
	private RequestService requestService;
	@Autowired
	private SbookService sbookService;
	

	@RequestMapping("/requests") 
	public List<Request> getAllStatus()
	{
		return requestService.getAllStatus();
	}
	
	@RequestMapping("/requests/{id}") 
	public Request getStatus(@PathVariable String id)
	{
		return requestService.getStatus(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/{sbookId}/requests")
	public void addRequest(@RequestBody Request request,@PathVariable String sbookId)
	{	
		for(int i=0;i<sbookService.sbooks.size();i++)
		{
			Sbook t = sbookService.sbooks.get(i);
			if(t.getSb().equals(sbookId))
			{
				request.setSbook(new Sbook(sbookId));
				requestService.addRequest(request);
			}
		}
	}	
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/{sbookId}/requests/{id}") 
	public void updateRequest(@RequestBody Request request,@PathVariable String sbookId,@PathVariable String id) 
	{
		for(int i=0;i<sbookService.sbooks.size();i++)
		{
			Sbook t = sbookService.sbooks.get(i);
			if(t.getSb().equals(sbookId))
			{
				request.setSbook(new Sbook(sbookId));
				requestService.updateRequest(id,request);
			}
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{sbookId}/requests/{id}")
	public void deleteRequest(@PathVariable String id)
	{
		requestService.deleteRequest(id);
	}
}


