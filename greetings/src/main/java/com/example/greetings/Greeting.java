package com.example.greetings;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Greeting")
public class Greeting {
	private String name;
	private String greetingcontent;
	private String id;
	
	private String name2;
	private String greetingcontent2;
	private String id2;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreetingcontent() {
		return greetingcontent;
	}

	public void setGreetingcontent(String greetingcontent) {
		this.greetingcontent = greetingcontent;
	}


	public String getName2() {
		return name2;
	}

	public void setName2(String name) {
		this.name2 = name;
	}

	public String getGreetingcontent2() {
		return greetingcontent2;
	}

	public void setGreetingcontent2(String greetingcontent2) {
		this.greetingcontent2 = greetingcontent2;
	}


	public String getId() {
		return id;
	}
	
	public String getId2() {
		return id2;
	}


	
	
	
	
}
