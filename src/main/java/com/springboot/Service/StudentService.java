package com.springboot.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.Dao.StudentDao;
import com.springboot.Dto.StudentDto;
import com.springboot.Entity.Student;
import com.springboot.Exception.NotFoundException;
import com.springboot.Util.ResponseStructure;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	@Autowired
	ModelMapper mapper; 

	public ResponseEntity<ResponseStructure<StudentDto>> save(Student s) {
		
		Student dbStudent = studentDao.save(s);
		StudentDto dto = this.mapper.map(dbStudent, StudentDto.class);
		
		ResponseStructure<StudentDto> structure = new ResponseStructure<>();
		structure.setMsg("Student Saved Successfully");
		structure.setHttpCode(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<StudentDto>> findById(int id) {
		Student dbStudent = studentDao.findById(id);
		if(dbStudent != null) {
			 StudentDto dto = this.mapper.map(dbStudent, StudentDto.class);
			 ResponseStructure<StudentDto> structure = new ResponseStructure<>();
			 structure.setMsg("Student Found Successfully");
			 structure.setHttpCode(HttpStatus.FOUND.value());
			 structure.setData(dto);
			 
			 return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new NotFoundException("Sorry failed to find the Student");
		}
	}

	public ResponseEntity<ResponseStructure<StudentDto>> updateStudent(int studentId, Student student) {
		Student dbStudent = studentDao.updateStudent(studentId,student);
		if(dbStudent != null) {
			StudentDto dto = this.mapper.map(dbStudent, StudentDto.class);
			
			ResponseStructure<StudentDto> structure = new ResponseStructure<>();
			structure.setMsg("Student Updated Successfully");
			structure.setData(dto);
			structure.setHttpCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<StudentDto>>(structure, HttpStatus.OK);
		}else {
			throw new NotFoundException("Sorry Student Not Updated");
		}
		
	}

	public ResponseEntity<ResponseStructure<StudentDto>> deleteById(int id) {
		Student dbStudent = studentDao.deleteById(id);
		
		if (dbStudent != null) {
			StudentDto dto =  this.mapper.map(dbStudent, StudentDto.class);
				
				ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
				structure.setMsg("Address Deleted Successfully");
				structure.setHttpCode(HttpStatus.GONE.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<StudentDto>>(structure, HttpStatus.GONE);
			}
			throw new NotFoundException("Sorry Failed to Find the Student");
	}
	
}
