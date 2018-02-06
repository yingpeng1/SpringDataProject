package com.pengying.repository;

import com.pengying.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void findByName() {
        //org.springframework.data.jpa.repository.support.SimpleJpaRepository@45f24169
        System.out.println(employeeRepository);
        Employee employee = employeeRepository.findByName("张三");
        System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " + employee.getAge());
    }

    @Test
    public void findByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("b",30);
        for (Employee employee:employees){
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " + employee.getAge());
        }
    }

    @Test
    public void findByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("e",20);
        for (Employee employee:employees){
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " + employee.getAge());
        }
    }

    @Test
    public void findByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("amy");
        names.add("tom");
        names.add("jane");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names,18);
        for (Employee employee:employees){
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " + employee.getAge());
        }
    }

    @Test
    public void findByNameAndOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("amy");
        names.add("tom");
        names.add("jane");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names,16);
        for (Employee employee:employees){
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " + employee.getAge());
        }
    }

    @Test
    public void getEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " + employee.getAge());
    }

    @Test
    public void queryParams1(){
        List<Employee> employees = employeeRepository.queryParams1("张三",20);
        for(Employee employee:employees){
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " +employee.getAge());
        }
    }

    @Test
    public void queryParams2(){
        List<Employee> employees = employeeRepository.queryParams2("张三",20);
        for(Employee employee:employees){
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " +employee.getAge());
        }
    }

    @Test
    public void queryLike1(){
        List<Employee> employees = employeeRepository.queryLike1("o");
        for(Employee employee:employees){
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " +employee.getAge());
        }
    }

    @Test
    public void queryLike2(){
        List<Employee> employees = employeeRepository.queryLike2("m");
        for(Employee employee:employees){
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " age: " +employee.getAge());
        }
    }

    @Test
    public void getCount(){
        long count = employeeRepository.getCount();
        System.out.println("count: " + count);
    }


}