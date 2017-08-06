package com.ky.workover.emp.web;

import com.ky.workover.emp.model.UserRole;
import com.ky.workover.emp.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/23.
 */
@Controller
@RequestMapping(value = "urole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 查询所有用户和角色的映射关系
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            map = userRoleService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询用户和角色的映射关系 by_id
     * @param userRole
     * @return
     */
    @RequestMapping(value = "selectById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectByPrimaryKey(@RequestBody UserRole userRole){
        Map<String, Object> map = new HashMap<>();
        try{
            map = userRoleService.selectByPrimaryKey(userRole);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 添加映射关系
     * @param userRole
     * @return
     */
    @RequestMapping(value = "insertUserAndRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertUserAndRole(@RequestBody UserRole userRole){
        Map<String, Object> map = new HashMap<>();
        try{
            map = userRoleService.insertUserAndRole(userRole);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除映射关系
     * @param userRole
     * @return
     */
    @RequestMapping(value = "deleteUserAndRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteUserAndRole(@RequestBody UserRole userRole){
        Map<String, Object> map = new HashMap<>();
        try{
            map = userRoleService.deleteUserAndRole(userRole);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回显
     * @param userRole
     * @return
     */
    @RequestMapping(value = "editUserAndRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editUserAndRole(@RequestBody UserRole userRole){
        Map<String, Object> map = new HashMap<>();
        try{
            map = userRoleService.editUserAndRole(userRole);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改映射关系
     * @param userRole
     * @return
     */
    @RequestMapping(value = "updateUserAndRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserAndRole(@RequestBody UserRole userRole){
        Map<String, Object> map = new HashMap<>();
        try{
            map = userRoleService.updateUserAndRole(userRole);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
