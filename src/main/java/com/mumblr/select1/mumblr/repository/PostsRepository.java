package com.mumblr.select1.mumblr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mumblr.select1.mumblr.model.Posts;

public interface PostsRepository extends MongoRepository<Posts, String>{
	
}
