package geekgrains.java.section4.level2.lesson7.service;

import geekgrains.java.section4.level2.lesson7.entity.Student;
import geekgrains.java.section4.level2.lesson7.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Student find(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void add(Student student) {
        studentRepository.save(student);
    }
    public void edit(Student student) { studentRepository.save(student); }
    public void delete(Long id) {studentRepository.deleteById(id);}
}
