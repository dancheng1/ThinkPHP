package com.ky.workover.job.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.job.model.Department;
import com.ky.workover.job.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/18.
 */
@Controller
@RequestMapping(value = "/dep")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.GET)
    public String toPage(HttpServletRequest request, HttpServletResponse response) {
        return "dep/toPage";
    }
    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String select(HttpServletRequest request, HttpServletResponse response) {
        return "/dep/selectDep";
    }
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(HttpServletRequest request, HttpServletResponse response) {
        return "/dep/insertDep";
    }

    /**
     * 查询部门信息By_Id
     * @param department
     * @return
     */
    @RequestMapping(value = "findDepartmentById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findDepartmentById(@RequestBody Department department){
        Map<String, Object> map = new HashMap<>();
        try{
            map = departmentService.findDepartmentById(department);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询所有部门信息
     * @return
     */
    @RequestMapping(value = "selectAll", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            map = departmentService.findDepartmentList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 新增部门信息
     * @param department
     * @return
     */
    @RequestMapping(value = "insertDepartment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertDepartment(@RequestBody Department department){
        Map<String, Object> map = new HashMap<>();
        try{
            map = departmentService.insertDepartment(department);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除部门信息
     * @param department
     * @return
     */
    @RequestMapping(value = "deleteDepartment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteDepartment(@RequestBody Department department){
        Map<String, Object> map = new HashMap<>();
        try{
            map = departmentService.deleteDepartmentById(department);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改之前回显
     * @param department
     * @return
     */
    @RequestMapping(value = "editDepartment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editDepartment(@RequestBody Department department){
        Map<String, Object> map = new HashMap<>();
        try{
            map = departmentService.editDepartment(department);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    @RequestMapping(value = "updateDepartment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateDepartment(@RequestBody Department department){
        Map<String, Object> map = new HashMap<>();
        try{
            map = departmentService.updateDepartment(department);
        } catch (Exception e){
            e.printStackTrace();
        }

        return map;
    }

}
