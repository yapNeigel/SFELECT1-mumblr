package com.mumblr.select1.mumblr.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mumblr.select1.mumblr.model.Accounts;

public interface LoginRepository extends MongoRepository<Accounts, String> {
	public Accounts findByEmailAndPass(String email,String pass);
}