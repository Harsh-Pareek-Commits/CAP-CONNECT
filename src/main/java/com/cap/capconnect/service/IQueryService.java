package com.cap.capconnect.service;

import java.util.List;
import com.cap.capconnect.entity.Query;
import com.cap.capconnect.exception.QueryNotFoundException;

public interface IQueryService {

	
	public  Query  addQuery(Query query) throws QueryNotFoundException;
	public  Query deleteQuery(long post_id) throws QueryNotFoundException;
	public  Query updateQuery(Query query,long post_id) throws QueryNotFoundException;
	public  List<Query> viewQuery() throws QueryNotFoundException;
	public Query viewQueryById(long post_id)  throws QueryNotFoundException;
	
	
	
}
