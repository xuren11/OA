package com.xuren.oa.service;


import com.xuren.oa.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department get(String sn);
    List<Department> getAll();
}
