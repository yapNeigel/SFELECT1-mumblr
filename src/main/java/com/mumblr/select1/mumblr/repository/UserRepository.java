package com.mumblr.select1.mumblr.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mumblr.select1.mumblr.model.Accounts;

public interface UserRepository extends MongoRepository<Accounts, String> {
	public Accounts findByfname(String fname);
    public List<Accounts> findBylname(String lname);
}
