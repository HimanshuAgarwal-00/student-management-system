package com.himanshu.sms.service;




import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.himanshu.sms.entity.Student;
import com.himanshu.sms.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repo.findById(id);
    }

    public Student addStudent(Student student) {
        if (repo.existsByRollNumber(student.getRollNumber())) {
            throw new RuntimeException("Roll number already exists!");
        }
        return repo.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return repo.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setRollNumber(updatedStudent.getRollNumber());
            student.setMarks(updatedStudent.getMarks());
            return repo.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        repo.deleteById(id);
    }
}
 