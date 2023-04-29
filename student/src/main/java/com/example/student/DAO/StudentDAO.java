package com.example.student.DAO;

import com.example.student.domain.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.SessionFactory;
//import com.mysql.cj.xdevapi.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveStudent(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public void updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = getStudentById(studentId);
        sessionFactory.getCurrentSession().delete(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudents() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        criteria.from(Student.class);
        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }


}

