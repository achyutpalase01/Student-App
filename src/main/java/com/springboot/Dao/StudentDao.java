package com.springboot.Dao;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Student;
import com.springboot.Repository.StudentRepository;

@Repository
@RequiredArgsConstructor
public class StudentDao {


	private final StudentRepository repo;
	
	public Student save(Student s) {
		return repo.save(s);
	}

	public Student findById(int id) {
		
		Optional<Student> s = repo.findById(id);
		if(s != null) {
			return s.get();
		}
		return null;
	}

	public Student updateStudent(int studentId, Student student) {
		Optional<Student> s = repo.findById(studentId);
		if(s.isPresent()) {
			student.setId(studentId);
			return repo.save(student);
		}
		return null;
	}

	public Student deleteById(int id) {
		Optional<Student> s = repo.findById(id);
		if(s.isPresent()) {
			Student ss= s.get();
			repo.delete(ss);
			return ss;
		}
		return null;
	}

}
