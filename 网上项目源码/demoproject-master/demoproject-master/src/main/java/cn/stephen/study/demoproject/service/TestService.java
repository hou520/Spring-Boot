package cn.stephen.study.demoproject.service;

import cn.stephen.study.demoproject.dao.TestDao;
import cn.stephen.study.demoproject.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired(required = false)
    private TestDao testDao ;

    public TestEntity getById(Integer id){
        return testDao.getById(id);
    }
}
