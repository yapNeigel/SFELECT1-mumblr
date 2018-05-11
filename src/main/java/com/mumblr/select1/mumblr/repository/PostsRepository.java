package com.mumblr.select1.mumblr.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mumblr.select1.mumblr.model.Posts;

public interface PostsRepository extends MongoRepository<Posts, String>{
	public List<Posts> findByPosterID(String posterID);
	public Posts findByid(String postID);
	public Long deleteByid(String postID);
}
