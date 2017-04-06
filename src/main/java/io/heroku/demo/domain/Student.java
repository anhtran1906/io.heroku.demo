package io.heroku.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("students")
public class Student {
	private String firstName;
	private String lastName;
	private @Id String emailAddress;
	
	public Student(){
		
	}
	public Student(String firstName, String lastName, String emailAddress){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString(){
		return "Person [firstName =" + firstName + ", lastName =" + lastName + 
				", emailAddress =" + emailAddress + "]";
	}
	
}
