package com.study.ssm.dao;


import com.study.ssm.bean.Department;
import com.study.ssm.bean.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")*/
public class MapperTest {

    /*@Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD(){
//        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));

//        employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@qq.com",1,null));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String s = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Employee(null,s,"M",s+"@qq.com",1,null));
        }
        System.out.println("批量完成");
    }
*/
}
