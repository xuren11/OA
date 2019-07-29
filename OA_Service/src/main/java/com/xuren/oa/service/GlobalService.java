package com.xuren.oa.service;

import com.xuren.oa.entity.Employee;

public interface GlobalService {
    Employee login(String sn, String password);
    void changePassword(Employee employee);
}
