package geekgrains.java.section4.level2.lesson7.repository;

import geekgrains.java.section4.level2.lesson7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
