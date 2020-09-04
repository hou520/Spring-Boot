package com.kude.stu.kudestu.stu.dao;

import com.kude.stu.kudestu.stu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer> {

    /**
     * 通过Id查询成员信息
     *
     * @param id
     * @return
     */
    Student findStudentById(Integer id);

    /**
     * 通过Name查询成员信息
     *
     * @param name
     * @return
     */
    @Query(name = "findStuByName", nativeQuery = true, value =
            "select * from student where name=:name")
    List<Student> findStuByName(@Param("name") String name);

    void deleteById(Integer id);
}
