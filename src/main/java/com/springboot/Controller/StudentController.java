package com.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Dto.StudentDto;
import com.springboot.Entity.Student;
import com.springboot.Service.StudentService;
import com.springboot.Util.ResponseStructure;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<StudentDto>> saveStudent(@RequestBody Student s) {
		return studentService.save(s);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseStructure<StudentDto>> get(@RequestParam int studentId){
		return studentService.findById(studentId);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<StudentDto>> updateStudent(@RequestParam int studentId, @RequestBody Student student){
		return studentService.updateStudent(studentId, student);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<ResponseStructure<StudentDto>> delete(@PathVariable int studentId){
		return studentService.deleteById(studentId);
	}

}
