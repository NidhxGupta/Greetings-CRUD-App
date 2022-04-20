package com.example.greetings;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MongoRepo extends MongoRepository <Greeting,String>{
	public List<Greeting> findAll();

	@Query("{greetingcontent : ?0}")                                       
        List<Greeting> getGreetingByContent(String name);
	
	@Query("{name : ?0}")                                       
    List<Greeting> getGreetingByName(String name);
	
}
