package com.mumblr.select1.mumblr.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mumblr.select1.mumblr.model.Accounts;

public interface UserRepository extends MongoRepository<Accounts, String> {
	public List<Accounts> findByfullNameLikeIgnoreCase(String fullName);
    public Accounts findByid(String id);
    public Accounts findByemail(String email);
    public Accounts findBypass(String pass);
}
