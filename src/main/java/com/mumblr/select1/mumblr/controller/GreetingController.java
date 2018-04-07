package com.mumblr.select1.mumblr;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	private CustomerRepository cust;
	
    @RequestMapping("/saveCustomer")
    public String greeting() {
		Customer customer = new Customer("John","David",true);
		cust.save(customer);
		return "HELLO WORLD";
    }
}