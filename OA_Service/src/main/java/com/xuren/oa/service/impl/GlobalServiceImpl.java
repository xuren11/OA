package com.xuren.oa.service.impl;


import com.xuren.oa.dao.EmployeeDao;
import com.xuren.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xuren.oa.service.GlobalService;

@Service("globalService")
public class GlobalServiceImpl implements GlobalService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if(employee!=null&&employee.getPassword().equals(password)){
            return  employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
