package com.kude.stu.kudestu.stu.dao;

import com.kude.stu.kudestu.stu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserDao extends JpaRepository<User, Integer> {
    /**
     * 根据id查询
     */
    User findUserById(int id);

    /**
     * 登录的实现
     */
    @Query(name = "login", nativeQuery = true, value = "select *from user where username=:username and password =:password")
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 删除成员
     */
    //@Query(name = "delete",nativeQuery = true,value = "delete FROM user where id =:id");
    void deleteById(int Id);
}
