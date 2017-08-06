package com.ky.workover.emp.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.emp.model.PersonUser;
import com.ky.workover.emp.service.PersonUserService;
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
 * 员工信息控制类
 */
@Controller
@RequestMapping(value = "/emp")
public class EmployeerController extends BaseController {

    @Autowired
    private PersonUserService personUserService;

    @RequestMapping(method = RequestMethod.GET)
    public String toPage(HttpServletRequest request, HttpServletResponse response) {
        return "emp/toPage";
    }
    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String select(HttpServletRequest request, HttpServletResponse response) {
        return "/emp/selectEmp";
    }
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(HttpServletRequest request, HttpServletResponse response) {
        return "/emp/insertEmp";
    }
    /**
     * 查询员工信息by_id
     * @param personUser
     * @return
     */
    @RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectByPrimaryKey(@RequestBody PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personUserService.selectByPrimaryKey(personUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 查询所有员工信息
     *
     * @param personUser
     * @return
     */
    @RequestMapping(value = "selectEmp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectEmp(@RequestBody PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personUserService.selectEmp(personUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 新增员工信息
     *
     * @param personUser
     * @return
     */
    @RequestMapping(value = "insertEmp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertEmp(@RequestBody PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personUserService.insertEmp(personUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除员工作息
     *
     * @param personUser
     * @return
     */
    @RequestMapping(value = "deleteEmp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteEmp(@RequestBody PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personUserService.deleteEmp(personUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改之前回显
     *
     * @param personUser
     * @return
     */
    @RequestMapping(value = "editEmp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editEmp(@RequestBody PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personUserService.editEmp(personUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
        /*return "emp/editEmp";*/
    }
    /**
     * 更新员工信息
     *
     * @param personUser
     * @return
     */
    @RequestMapping(value = "updateEmp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateEmp(@RequestBody PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personUserService.updateEmp(personUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
