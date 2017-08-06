package com.ky.workover.emp.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.emp.model.PersonUser;
import com.ky.workover.emp.model.Role;
import com.ky.workover.emp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/23.
 */
@Controller
@RequestMapping(value = "role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "findPerByRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findPerByRole(@RequestBody Role role){
        Map<String, Object> map = new HashMap<>();
        try{
            map = roleService.findPerByRole(role);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            map = roleService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询用户角色
     * @param personUser
     * @return
     */
    @RequestMapping(value = "findByUserId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findByUserId(@RequestBody PersonUser personUser){
        Map<String, Object> map = new HashMap<>();
        try{
            map = roleService.findByUserId(personUser);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询角色by_id
     * @param role
     * @return
     */
    @RequestMapping(value = "selectById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectByPrimaryKey(@RequestBody Role role){
        Map<String, Object> map = new HashMap<>();
        try{
            map = roleService.selectByPrimaryKey(role);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    @RequestMapping(value = "insertRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertRole(@RequestBody Role role){
        Map<String, Object> map = new HashMap<>();
        try{
            map = roleService.insertRole(role);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除角色信息
     * @param role
     * @return
     */
    @RequestMapping(value = "deleteRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteRole(@RequestBody Role role){
        Map<String, Object> map = new HashMap<>();
        try{
            map = roleService.deleteRole(role);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回显
     * @param role
     * @return
     */
    @RequestMapping(value = "editRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editRole(@RequestBody Role role){
        Map<String, Object> map = new HashMap<>();
        try{
            map = roleService.editRole(role);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    @RequestMapping(value = "updateRole", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateRole(@RequestBody Role role){
        Map<String, Object> map = new HashMap<>();
        try{
            map = roleService.updateRole(role);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
