package com.ky.workover.emp.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.emp.model.Permission;
import com.ky.workover.emp.model.Role;
import com.ky.workover.emp.service.PermissionService;
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
 * Created by Administrator on 2017/1/23.
 */
@Controller
@RequestMapping(value = "per")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping( value = "select",method =  RequestMethod.GET)
    public String select(HttpServletRequest request,HttpServletResponse response){return  "Permission/permission";}
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String update(HttpServletRequest request,HttpServletResponse response){return "index/index_v1";};

    /**
     * 查询所有权限信息
     * @return
     */
    @RequestMapping(value = "selectPer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectPer(){
        Map<String, Object> map = new HashMap<>();
        try{
            map = permissionService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询权限by_id
     * @param permission
     * @return
     */
    @RequestMapping(value = "selectById", method = RequestMethod.POST)
        @ResponseBody
        public Map<String, Object> selectByPrimaryKey(@RequestBody Permission permission){
            Map<String, Object> map = new HashMap<>();
            try{
                map = permissionService.selectByPrimaryKey(permission);
            } catch (Exception e){
                e.printStackTrace();
            }
            return map;
    }

    /**
     * 添加权限信息
     * @param permission
     * @return
     */
    @RequestMapping(value = "insertPer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertPer(@RequestBody Permission permission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = permissionService.insertPer(permission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除权限信息
     * @param permission
     * @return
     */
    @RequestMapping(value = "deletePer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deletePer(@RequestBody Permission permission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = permissionService.deletePer(permission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回显
     * @param permission
     * @return
     */
    @RequestMapping(value = "editPer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editPer(@RequestBody Permission permission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = permissionService.editPer(permission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改权限信息
     * @param permission
     * @return
     */
    @RequestMapping(value = "updatePer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePer(@RequestBody Permission permission){
        Map<String, Object> map = new HashMap<>();
        try{
            map = permissionService.updatePer(permission);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
