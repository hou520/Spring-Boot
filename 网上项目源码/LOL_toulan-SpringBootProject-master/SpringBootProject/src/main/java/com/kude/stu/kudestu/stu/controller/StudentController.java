package com.kude.stu.kudestu.stu.controller;

import com.kude.stu.kudestu.stu.entity.LayData;
import com.kude.stu.kudestu.stu.entity.Student;
import com.kude.stu.kudestu.stu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/s")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * 添加学生
     *
     * @param student 参数
     * @return
     */
    @PostMapping("/add")
    public Student save(Student student) {
        return studentService.save(student);
    }

    /**
     * 更新学生信息
     *
     * @param student 参数
     * @return
     */

    @PostMapping("/update")
    public Student update(Student student) {
        return studentService.update(student);
    }
//    @PathVariable("id")

    /**
     * 删除学生信息
     *
     * @param id
     */

    @GetMapping("/del/{id}")
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "delete yes";
    }

    /**
     * 通过名字查询学生信息
     *
     * @param name
     * @return
     */
    @GetMapping("/findByName/{name}")
    public List<Student> findStuByName(@PathVariable String name) {
        return studentService.findStuByName(name);
    }


    /**
     * 分页查询所有学生信息
     *
     * @param
     * @return
     */

    @GetMapping("/query")
    public LayData<Student> findByPage(Integer page, Integer limit, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        if (page == null || page <= 0) {
            page = 0;
        } else {
            page -= 1;
        }

        if (limit == null || limit <= 5) {
            limit = 5;
        }

        Page<Student> pageData = studentService.findAll(page, limit);
        LayData<Student> layData = new LayData<Student>();
        layData.setCode(0);
        layData.setCount(pageData.getTotalElements());
        layData.setData(pageData.getContent());

        return layData;
    }


    @GetMapping("/findById")
    public Student findStuById(int id) {
        return studentService.findStuById(id);
    }
}















