package SpringCrude.SpringCrude.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringCrude.SpringCrude.Models.Students;
import SpringCrude.SpringCrude.Services.StudentService;


@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	

	
	@PostMapping("/signup")
	public ResponseEntity<Students> saveStudent(@RequestBody Students student)
	{
		return new ResponseEntity<Students>(studentservice.saveStudent(student),HttpStatus.CREATED);
		
	}
	@GetMapping
	public List<Students> getAllStudent(){return studentservice.getAllStudents();}
	
	@GetMapping("{id}")
	public ResponseEntity<Students> getStudentId(@PathVariable("id") int id)
	{
		return new ResponseEntity<Students>(studentservice.getStudentId(id),HttpStatus.OK);		
	}
	@PutMapping("{id}")
	public ResponseEntity<Students> updateStudent(@PathVariable("id") int id,@RequestBody Students student)
	{
		return new ResponseEntity<Students>(studentservice.updateStudent(student,id),HttpStatus.OK);		
	}
	
	@DeleteMapping("{id}")
	public String deleteStudent (@PathVariable("id") int id) {
		studentservice.deleteStudent(id);
		return  "Successfully Deleted";
	}
}
	
