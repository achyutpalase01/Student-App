package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Entity.Student;
import org.springframework.stereotype.Component;

public interface StudentRepository extends JpaRepository<Student, Integer>  {
	
}
