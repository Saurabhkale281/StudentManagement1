package Project.StudentManagement1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.StudentManagement1.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	
	

}
