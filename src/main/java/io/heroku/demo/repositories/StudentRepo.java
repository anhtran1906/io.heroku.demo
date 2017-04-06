package io.heroku.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import io.heroku.demo.domain.Student;

public interface StudentRepo extends CrudRepository<Student, String> {

}
