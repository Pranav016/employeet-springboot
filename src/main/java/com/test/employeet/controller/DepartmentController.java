package com.test.employeet.controller;

import com.test.employeet.entity.Department;
import com.test.employeet.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> fetchAllDepartments(){
        return departmentService.fetchDepartmentList();
    }

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
        public String deleteDepartmentById (@PathVariable("id") Long departmentId){
            departmentService.deleteDepartmentById(departmentId);
            return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId, department);
    }
}
