package com.pengying.dao;

import com.pengying.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOJdbcTemplateImplTest{

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO)ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void query() {
        List<Student> students = studentDAO.query();

        for(Student student : students){
            System.out.println("id: " + student.getId() + ", name: " + student.getName() + ", age: " +
                    student.getAge());
        }
    }

    @Test
    public void save() {
        Student student =new Student();
        student.setName("test");
        student.setAge(30);
        studentDAO.save(student);
    }
}