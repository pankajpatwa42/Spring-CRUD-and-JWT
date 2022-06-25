package SpringCrude.SpringCrude.Services;

import java.util.List;

import SpringCrude.SpringCrude.Models.Students;


public interface StudentService {
Students saveStudent(Students student);
	
	List<Students> getAllStudents();
	
	Students getStudentId(int id);
	
	Students updateStudent(Students student,int id);
	
	void deleteStudent(int id);
}
