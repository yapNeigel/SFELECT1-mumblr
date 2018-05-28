package com.mumblr.select1.mumblr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mumblr.select1.mumblr.model.Follow;

public interface FollowRepository extends MongoRepository<Follow, String>{
	public List<Follow>findByuserID(String userID);
	public Long deleteByid(String id);
}
