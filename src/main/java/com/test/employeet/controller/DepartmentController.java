package com.test.employeet.controller;

import com.test.employeet.entity.Department;
import com.test.employeet.error.DepartmentNotFoundException;
import com.test.employeet.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/departments")
    public List<Department> fetchAllDepartments(){
        return departmentService.fetchDepartmentList();
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside save department of DepartmentController.");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
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

    @GetMapping("/departments/name/{name}")
        public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
            return departmentService.fetchByDepartmentName(departmentName);
    }
}
