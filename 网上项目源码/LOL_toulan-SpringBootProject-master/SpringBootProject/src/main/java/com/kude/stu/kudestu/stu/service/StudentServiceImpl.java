package com.kude.stu.kudestu.stu.service;

import com.kude.stu.kudestu.stu.dao.StudentDao;
import com.kude.stu.kudestu.stu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student findStuById(Integer id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public List<Student> findStuByName(String name) {
        return studentDao.findStuByName(name);
    }

    /**
     * @param page     当前页，
     * @param pageSize 每页几条数据
     * @return
     */
    @Override
    public Page<Student> findAll(int page, int pageSize) {
        Pageable pageble = PageRequest.of(page, pageSize);
        return studentDao.findAll(pageble);
    }
}
