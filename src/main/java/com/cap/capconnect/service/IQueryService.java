package com.cap.capconnect.service;

import com.cap.capconnect.entity.Query;

public interface IQueryService {

	
	public  Query  addQuery(Query query);
	public  Query deleteQuery(long query_id);
	public  Query updateQuery(Query query);
	
	
	
}
