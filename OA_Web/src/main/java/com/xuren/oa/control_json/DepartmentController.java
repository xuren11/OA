package com.xuren.oa.control_json;

import com.xuren.oa.entity.Department;
import com.xuren.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller("jdepartmentController")
@ResponseBody
@RequestMapping("/jdepartment")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/list")
    public List<Department> list(){
        System.out.println("访问进来了");
        return departmentService.getAll();
    }

    @RequestMapping("/add")
    public void toAdd(@RequestBody Department department){
        departmentService.add(department);
    }

    @RequestMapping(value = "/update",params = "sn")
    public String toUpdate(String sn,Map<String,Object> map){
        map.put("department",departmentService.get(sn));
        return "department_update";
    }
    @RequestMapping("/update")
    public String update(Department department){
        departmentService.edit(department);
        return "redirect:list";
    }
    @RequestMapping(value = "/remove",params = "sn")
    public String remove(String sn){
        departmentService.remove(sn);
        return "redirect:list";
    }

}
