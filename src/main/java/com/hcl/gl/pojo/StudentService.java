package com.hcl.gl.pojo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	public void addStudent(String name, int m1, int m2, int m3, String password) {
		
		Student student = Student.builder().name(name).m1(m1).m2(m2).m3(m3).password(password).build();
		repo.save(student);
		
	}
	
	public void updateStudent(Student student) {
		repo.save(student);
		
	}
	
	public List<Student> getAllStudents(){
		
		return repo.findAll();
		
	}
	
	public void deleteStudent(Student student){
		
		repo.delete(student);
		
	}
	
	public Optional<Student> getById(int id) {
		return repo.findById(id);
	}
	
}
