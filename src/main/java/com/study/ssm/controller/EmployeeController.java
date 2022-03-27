package com.study.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.ssm.bean.Employee;
import com.study.ssm.bean.Msg;
import com.study.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ResponseBody
    @DeleteMapping("/emp/{ids}")
    public Msg deleteEmpById(@PathVariable("ids") String ids){
        if (ids.contains("-")){
            List<Integer> delIds = new ArrayList<Integer>();
            String[] strIds = ids.split("-");
            for (String strId : strIds) {
                delIds.add(Integer.parseInt(strId));
            }
            employeeService.deleteBatch(delIds);
        }else {
            int id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }
        return Msg.success();
    }

    @ResponseBody
    @PutMapping("/emp/{empId}")
    public Msg updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return null;
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return Msg.success().add("emp",emp);
    }

    @ResponseBody
    @PostMapping("/checkEmp")
    public Msg checkEmp(String empName){
        String regx = "(^[a-zA-Z]{1}[a-zA-Z\\s]{0,20}[a-zA-Z]{1}$)|(^(?:[\\u4e00-\\u9fa5·]{2,16})$)";
        if (!empName.matches(regx)){
            return Msg.fail().add("va_msg","用户名格式不合法！");
        }
        boolean b = employeeService.checkEmp(empName);
        if (b){
            return Msg.success();
        }else {
            return Msg.fail().add("va_msg","用户名已存在");
        }
    }

    @PostMapping("/emp")
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                map.put(error.getField(),error.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);
        } else {
            employeeService.saveEmp(employee);
            return Msg.success();
        }
    }

    @GetMapping({"/page/{pn}"})
    @ResponseBody
    public Msg getEmps(@PathVariable(value = "pn",required = false) Integer pn){
        if (pn==null) pn = new Integer(1);
        PageHelper.startPage(pn,5);
        List<Employee> emps = employeeService.getAll();
        PageInfo<Employee> pageInfo = new PageInfo(emps,5);
        return Msg.success().add("pageInfo",pageInfo);
    }

}
