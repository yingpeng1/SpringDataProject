package com.pengying.repository;

import com.pengying.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import static org.junit.Assert.*;

public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    /**
     * 1.分页
     * 2.排序
     * 3.查询条件:age>50
     */
    @Test
    public void query(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);

        //page:index是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(1,9,sort);

        /**
         * root:就是我们要查询的类型（Employee)
         * query:添加查询条件
         * cb:构建predicate
         */
        Specification<Employee> employeeSpecification = new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {

                //root(Employee(age))
                Path path = root.get("age");
                return cb.gt(path,50);
            }
        };

        Page<Employee> page = employeeJpaRepository.findAll(employeeSpecification,pageable);

        System.out.println("查询的总页数: " + page.getTotalPages());
        System.out.println("查询的总记录数: " + page.getTotalElements());
        System.out.println("查询的当前第几页: " + (page.getNumber() + 1));
        System.out.println("查询的当前页面的集合: " + page.getContent());
        System.out.println("查询的当前页面的记录数: " + page.getNumberOfElements());
    }
}
