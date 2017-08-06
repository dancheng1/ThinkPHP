package com.ky.workover.emp.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.emp.model.Permission;
import com.ky.workover.emp.model.PermissionCustom;
import com.ky.workover.emp.model.Role;
import com.ky.workover.emp.model.RolePermission;
import com.ky.workover.emp.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/23.
 */
@Controller
@RequestMapping(value = "rper")
public class RolePermissionController extends BaseController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping(method = RequestMethod.GET)
    public String toPage(HttpServletRequest request, HttpServletResponse response) {
        return "dep/toPage";
    }
    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String select(HttpServletRequest request, HttpServletResponse response) {
        return "/Permission/RP";
    }

    /**
     * 查询所有权限映射
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
     @ResponseBody
     public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            map = rolePermissionService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询权限映射by_id
     * @param rolePermission
     * @return
     */
    @RequestMapping(value = "selectById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectByPrimaryKey(@RequestBody RolePermission rolePermission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = rolePermissionService.selectByPrimaryKey(rolePermission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 添加映射
     * @param rolePermission
     * @return
     */
    @RequestMapping(value = "insertRoleAndPer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertRoleAndPer(@RequestBody RolePermission rolePermission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = rolePermissionService.insertRoleAndPer(rolePermission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除映射
     * @param rolePermission
     * @return
     */
    @RequestMapping(value = "deleteRoleAndPer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteRoleAndPer(@RequestBody RolePermission rolePermission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = rolePermissionService.deleteRoleAndPer(rolePermission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回显
     * @param rolePermission
     * @return
     */
    @RequestMapping(value = "editRolePer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editRoleAndPer(@RequestBody RolePermission rolePermission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = rolePermissionService.editRoleAndPer(rolePermission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改角色所拥有的权限
     * @param permissionCustom
     * @return
     */
    @RequestMapping(value = "updateRolePers", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateRolePers(@RequestBody PermissionCustom permissionCustom){
        Map<String, Object> map = new HashMap<>();
        try{
            map = rolePermissionService.updateRolePers(permissionCustom);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 更新映射
     * @param rolePermission
     * @return
     */
    @RequestMapping(value = "updateRoleAndPer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateRoleAndPer(@RequestBody RolePermission rolePermission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = rolePermissionService.updateRoleAndPer(rolePermission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
