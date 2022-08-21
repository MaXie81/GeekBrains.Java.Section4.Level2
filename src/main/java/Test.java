import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Factory.getSessionFactory();
        Session session = sessionFactory.openSession();

        Student student1 = new Student("Student 1", null);
        Student student2 = new Student("Student 2", null);
        Student student3 = new Student("Student 3", null);

        StudentDAO studentDAO = new StudentDAO(Factory.getSessionFactory());
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        student1.setMark("A");
        studentDAO.update(student1);
        System.out.println(studentDAO.findById(1L));

        studentDAO.delete(student3);

        List<Student> studentList = studentDAO.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }

        for (int i = 3; i <= 1_000 ; i++) {
            studentDAO.save(new Student("student " + i, null));
        }

        session.close();
        sessionFactory.close();
    }
}
