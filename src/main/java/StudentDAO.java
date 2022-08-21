import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }

    public void save(Student student) {
        transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }
    public void update(Student student) {
        transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
    }
    public void delete(Student student) {
        transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
    }
    public Student findById(long id) {
        return session.find(Student.class, id);
    }
    public List<Student> findAll() {
        transaction = session.beginTransaction();
        List<Student> studentList = session
                .createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
        transaction.commit();

        return studentList;
    }
}
