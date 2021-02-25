package com.astontech.hr.rest;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Employee> getAll() {
        return employeeService.listAllEmployees();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Employee getById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee save(@ModelAttribute("employee") Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            employeeService.deleteEmployee(id);
            result = true;
        } catch (Exception ex) {

        }
        return result;
    }
}
