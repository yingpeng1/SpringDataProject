package com.pengying.dao;

import com.pengying.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void query() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for(Student student : students){
            System.out.println("id: " + student.getId() + ", name: " + student.getName() + ", age: " +
                    student.getAge());
        }
    }

    @Test
    public void save(){
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student =new Student();
        student.setName("test");
        student.setAge(30);
        studentDAO.save(student);
    }
}