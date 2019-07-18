package com.My.Library.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class RequestService 
{
	public List<Request> requests = new ArrayList<>(Arrays.asList());
	
	public List<Request> getAllStatus()
	{
		return requests;
	}
	
	public Request getStatus(String id)
	{
		return requests.stream().filter(t-> t.getRid().equals(id)).findFirst().get();
	}
	
	public void addRequest(Request request)
	{
		requests.add(request);
	}
	
	public void updateRequest(String id,Request request)
	{
		for(int i=0;i<requests.size();i++)
		{
			Request t = requests.get(i);
			if(t.getRid().equals(id))
			{
				requests.set(i,request);
				return;
			}
		}
	}
	
	public void deleteRequest(String id)
	{
		requests.removeIf(t->t.getRid().equals(id)); 
	}
}







