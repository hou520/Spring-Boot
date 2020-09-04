package com.kude.stu.kudestu.stu.service;

import com.kude.stu.kudestu.stu.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;


public interface StudentService {

    Student save(Student student);

    Student update(Student student);

    void delete(Integer id);

    Student findStuById(Integer id);

    List<Student> findStuByName(String name);

    /**
     * 分页查询所有页
     *
     * @param page     当前页，
     * @param pageSize 每页几条数据
     * @return
     */
    Page<Student> findAll(int page, int pageSize);

}
