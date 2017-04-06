package io.heroku.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.heroku.demo.domain.Student;

@Controller
@RestController
@RequestMapping(value = "/students")
public class StudentController {
	private CrudRepository<Student,String> repository;
	
	@Autowired
	public StudentController(CrudRepository<Student,String> repository){
		this.repository = repository;
	}
	
	@RequestMapping(method = RequestMethod.GET) 
	
	public Iterable<Student> students() {
		return repository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Student add(@RequestBody @Valid Student student){
		return repository.save(student);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Student update(@RequestBody @Valid Student student){
		return repository.save(student);
	}
	
	@RequestMapping(value = "/{emailAddress:.+}", method = RequestMethod.GET)
	public Student getById(@PathVariable String emailAddress){
		return repository.findOne(emailAddress);
	}
	
	@RequestMapping(value = "/{emailAddress:.+}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable String emailAddress){
		repository.delete(emailAddress);
	}


}
