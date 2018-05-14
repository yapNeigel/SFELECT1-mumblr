package com.mumblr.select1.mumblr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mumblr.select1.mumblr.model.Comments;

public interface CommentRepository extends MongoRepository<Comments, String>{
	public List<Comments>findBypostId(String postId);
	public Comments findByid(String id);
	public Long deleteByid(String id);
}
