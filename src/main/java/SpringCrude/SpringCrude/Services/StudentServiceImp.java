package SpringCrude.SpringCrude.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import SpringCrude.SpringCrude.Models.Students;
import SpringCrude.SpringCrude.Repository.StudentRepository;


@Service
public class StudentServiceImp implements StudentService{

@Autowired	
private StudentRepository studentrepositiry;

@Autowired
private PasswordEncoder passwordEncoder;


	public Students saveStudent(Students student) {
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		return studentrepositiry.save(student);
	}

	public List<Students> getAllStudents() {
		return studentrepositiry.findAll();
	}

	public Students getStudentId(int id) {
		return studentrepositiry.findById(id).orElseThrow(null);
	}

	public Students updateStudent(Students student,int id) {
		Students existingStudent = studentrepositiry.findById(id).orElseThrow(null);
		existingStudent.setLastName(student.getLastName());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setEmail(student.getEmail());
		studentrepositiry.save(existingStudent);
		return existingStudent;
		
	}

	public void deleteStudent(int id) {
		studentrepositiry.deleteById(id);
	}


}
