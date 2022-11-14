package com.hcl.gl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.gl.pojo.Student;
import com.hcl.gl.pojo.StudentService;

@Controller
public class AppController {

	@Autowired
	StudentService service;
	
	@GetMapping("/")
	public String home() {
		//this is for loading the welcome.jsp file
		return "welcome"; // /webapp/jsp/welcome.jsp
	}
	
	@GetMapping("/teacher/home")
	public String teacherHome(HttpServletRequest request) {
		
		boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginteacher") != null ) {
			validLogin = true;
		}
		
		if(validLogin ) {
			return "teacherhome"; // /webapp/jsp/welcome.jsp
		}
		else{
			return "teacherlogin"; // /webapp/jsp/welcome.jsp
		}
	}
	
	//to validate the teacher login uusing username and password (admin/admin)
	@PostMapping("/teacher/teacherloginverify")
	public String teacherloginverify(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		
		if( username.compareTo("admin") == 0 && password.compareTo("admin") == 0 ) {
			request.getSession().setAttribute("loginteacher", 1);
			return "teacherhome";
		}
		return "teacherlogin";
	}
	
	//destroying the session using invalidate function
	@GetMapping("/teacher/logout")
	public String teacherlogout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "welcome";
	}
	
	//adding new student to the db using service
	@GetMapping("/teacher/addstudentform")
	public String teacherAddStudentForm(HttpServletRequest request) {
		boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginteacher") != null ) {
			validLogin = true;
		}
		
		if(validLogin ) {
			//show the form page
			return "teacheraddstudentform";
		}
		else{
			return "teacherlogin";
		}
	}
	
	@PostMapping("/teacher/savestudent")
	public String teacherSaveStudent(@RequestParam String name, @RequestParam int m1, @RequestParam int m2, @RequestParam int m3, @RequestParam String password, HttpServletRequest request) {
		//this is used to mark whether we have valid session or not
		boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginteacher") != null ) {
			validLogin = true;
		}
		
		if(validLogin ) {
			//show the form page
			service.addStudent(name, m1, m2, m3, password);
			return "teacheraddstudentform";
		}
		else{
			return "teacherlogin";
		}
		
	}
	
	@GetMapping("/teacher/viewallstudents")
	public String teacherViewAllStudents(HttpServletRequest request, ModelMap map) {
		boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginteacher") != null ) {
			validLogin = true;
		}
		
		if(validLogin ) {
			//show the form page
			List<Student> students = service.getAllStudents();
			map.addAttribute("data", students);
			return "teacherviewallstudents";
		}
		else{
			return "teacherlogin";
		}
	}
	
	/*
	@GetMapping("/teacher/studentdelete")
	public String teacherDeleteStudent(int id, HttpServletRequest request, ModelMap map) {
		boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginteacher") != null ) {
			validLogin = true;
		}
		
		if(validLogin ) {
			//show the form page
			Student deleteStudent = Student.builder().id(id).build();
			service.deleteStudent(deleteStudent);
			List<Student> students = service.getAllStudents();
			map.addAttribute("data", students);
			return "teacherviewallstudents";
		}
		else{
			return "teacherlogin";
		}
	}
	*/
	
	@GetMapping("/teacher/studentdelete/{id}")
	public String teacherDeleteStudent(@PathVariable("id") int id, HttpServletRequest request, ModelMap map) {
		boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginteacher") != null ) {
			validLogin = true;
		}
		
		if(validLogin ) {
			//show the form page
			Student deleteStudent = Student.builder().id(id).build();
			service.deleteStudent(deleteStudent);
			List<Student> students = service.getAllStudents();
			map.addAttribute("data", students);
			return "teacherviewallstudents";
		}
		else{
			return "teacherlogin";
		}
	}
	
	@GetMapping("/teacher/studentupdateform")
	public String teacherShowUpdateForm(int id, HttpServletRequest request, ModelMap map) {
boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginteacher") != null ) {
			validLogin = true;
		}
		
		if(validLogin ) {
			//show the form page
			Optional<Student> studentOptional = service.getById(id);
			if( studentOptional.get() == null ) {
				return "teacherviewallstudents";
			}
			else {
				Student student = studentOptional.get();
				map.addAttribute("data", student);
				return "teacherstudentupdateform";
			}
			
		}
		else{
			return "teacherlogin";
		}
	}
	
	@PostMapping("/teacher/updatestudent")
	public String teacherUpdateStudent(@RequestParam int id, @RequestParam String name, @RequestParam int m1, @RequestParam int m2, @RequestParam int m3, @RequestParam String password, HttpServletRequest request, ModelMap map ) {
		
		boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginteacher") != null ) {
			validLogin = true;
		}
		
		if(validLogin ) {
			Student student = Student.builder().id(id).name(name).m1(m1).m2(m2).m3(m3).password(password).build()			;
			service.updateStudent(student);
			List<Student> students = service.getAllStudents();
			map.addAttribute("data", students);
			return "teacherviewallstudents";
		}
		else{
			return "teacherlogin";
		}
		
	}
	
	//student controllers	
	@PostMapping("/student/studentloginverify")
	public String studentloginverify(@RequestParam int id, @RequestParam String password, HttpServletRequest request, ModelMap map) {

		Optional<Student> studentOpt = service.getById(id);
		
		if( studentOpt == null ) {
			return "studentlogin";
		}
		
		Student student = studentOpt.get();
		
		if( student.getPassword().compareTo(password) == 0 ) {
			request.getSession().setAttribute("loginstudent", id);
			map.addAttribute("student", student);
			return "studenthome";
		}
		else {
			return "studentlogin";
		}		
	}
	
	@GetMapping("/student/home")
	public String studentHome(HttpServletRequest request, ModelMap map) {
		
		boolean validLogin = false;
		
		if( request.getSession().getAttribute("loginstudent") != null ) {
			validLogin = true;
		}
		
		if( validLogin ){
			int id = (int) request.getSession().getAttribute("loginstudent");
			Optional<Student> studentOpt = service.getById(id);
			Student student = studentOpt.get();
			map.addAttribute("student", student);
			return "studenthome";
		}
		else {
			return "studentlogin";
		}
	}
	
}
