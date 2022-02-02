package com.cap.capconnect.service;

import java.util.List;
import org.slf4j.LoggerFactory;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cap.capconnect.entity.Query;
import com.cap.capconnect.exception.QueryNotFoundException;
import com.cap.capconnect.repository.IQueryRepository;

public class QueryServiceImpl implements IQueryService {
	  Logger log = LoggerFactory.getLogger(QueryServiceImpl.class);
	  
  @Autowired
  IQueryRepository queryRepository;

  //add
  @Override
	public  Query addQuery(Query query) throws QueryNotFoundException  {
		Optional<Query> opt = null;
		try {
			opt = queryRepository.findById(query.getPost_id());
			if (opt.isPresent()) {
				throw new QueryNotFoundException("Query name already exists");}
			else
				return queryRepository.save(query);
		} catch (Exception e) {
			throw new QueryNotFoundException("Query cannot be added");
		}
	}
	//delete

	@Override
	public Query deleteQuery(long post_id) throws QueryNotFoundException {
		try {
			Optional<Query> opt = queryRepository.findById(post_id);
			if (opt.isPresent()) {
				queryRepository.deleteById(post_id);
				return opt.get();

			} else {
				throw new QueryNotFoundException("Query not found in delete");
			}

		} catch (Exception e) {

			throw new QueryNotFoundException("Query not found in delete");

		}
	}
	
	//update
		@Override
		public Query updateQuery(Query query) throws QueryNotFoundException {
			Optional<Query> opt = null;
			try {
				opt = queryRepository.findById(query.getPost_id());
				if (opt.isPresent()) {

					queryRepository.save(query);
				} else {
					throw new QueryNotFoundException("Query details not found");
				}
			} catch (Exception e) {
				
				throw new QueryNotFoundException("Query cannot be updated");
			}
			return opt.get();
	}

		//view
		
		@Override
		public List<Query> viewQuery() {

			List<Query> queryList=null;
			try {

				queryList = queryRepository.findAll();

			} catch (Exception e) {

				log.error("View query Exception:", e);
			}

			return queryList;
		}

		
		@Override
		public Query viewQueryById(long post_id) throws QueryNotFoundException {
			
			Query query = null;
			try {
				Optional<Query> opt = queryRepository.findById(post_id);
				if (opt.isPresent()) {
					query = opt.get();
				} else {
					throw new QueryNotFoundException("Query id not found in view query by id");
				}
			} catch (Exception e) {

				throw new QueryNotFoundException("Query id not found in view query by id");
			}
			return query;
		}

		

		


}
