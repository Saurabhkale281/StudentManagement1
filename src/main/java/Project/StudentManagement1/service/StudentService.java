package Project.StudentManagement1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.StudentManagement1.entity.StudentEntity;
import Project.StudentManagement1.repository.StudentRepository;
import Project.StudentManagement1.response.StudentResponse;
import Project.StudentManagement1.response.deleteResponse;

@Service
public class StudentService {
	
	@Autowired
    private StudentRepository studentRepository;
	

    public StudentResponse addStudent(StudentEntity student) {
    	System.out.println("Mobile Number: " + student.getMobileNo());
    	StudentEntity savedStudent = studentRepository.save(student);
        return new StudentResponse(savedStudent.getId(), "Student added successfully");
    }

    public StudentResponse updateStudent(Long id, StudentEntity student) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
        
        if (optionalStudent.isPresent()) {
        	StudentEntity existingStudent = optionalStudent.get();
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setMobileNo(student.getMobileNo());
            existingStudent.setGender(student.getGender());
            studentRepository.save(existingStudent);
            return new StudentResponse(existingStudent.getId(), "Student updated successfully");
        } else {
            return new StudentResponse(id, "Student not found");
        }
    }

    public deleteResponse deleteStudent(Long id) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
        	StudentEntity student = optionalStudent.get(); // Retrieve the student entity
            studentRepository.delete(student);
            return new deleteResponse("Student deleted successfully", student.getName());
        } else {
            return new deleteResponse("Student not found" ,null);
        }
    }

    public StudentEntity getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

}
