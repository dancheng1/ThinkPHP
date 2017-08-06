package com.ky.workover.emp.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.emp.mapper.RolePermissionMapper;
import com.ky.workover.emp.model.Permission;
import com.ky.workover.emp.model.PermissionCustom;
import com.ky.workover.emp.model.Role;
import com.ky.workover.emp.model.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/22.
 */
@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * 查询所有权限映射
     * @return
     */
    public Map<String,Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<RolePermission> list = rolePermissionMapper.findAll();
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
            map.put("total", list.size());  //对list的数量进行汇总
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 查询权限映射by_id
     * @param rolePermission1
     * @return
     */
    public Map<String, Object> selectByPrimaryKey(RolePermission rolePermission1){
        Map<String, Object> map = new HashMap<>();
        try{
            RolePermission rolePermission = rolePermissionMapper.selectByPrimaryKey(rolePermission1.getId());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(rolePermission, JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 添加映射
     * @param rolePermission
     * @return
     */
    public Map<String, Object> insertRoleAndPer(RolePermission rolePermission){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = rolePermissionMapper.insert(rolePermission);
            if (count != 0) {
                map.put("isSuccess", "1");
                map.put("msg", "保存成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "保存失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "保存失败！");
        }
        return map;
    }

    /**
     * 删除映射
     * @param rolePermission
     * @return
     */
    public Map<String, Object> deleteRoleAndPer(RolePermission rolePermission){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
            if (count != 0) {
                map.put("isSuccess", "1");
                map.put("msg", "删除成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "删除失败！");
        }
        return map;
    }

    /**
     * 回显
     * @param rolePermission1
     * @return
     */
    public Map<String, Object> editRoleAndPer(RolePermission rolePermission1){
        Map<String, Object> map = new HashMap<>();
        try{
            RolePermission rolePermission = rolePermissionMapper.selectByPrimaryKey(rolePermission1.getId());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(rolePermission, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 修改角色所拥有的权限
     * @param permissionCustom
     * @return
     */
    public Map<String, Object> updateRolePers(PermissionCustom permissionCustom){
        boolean pd = true;
        Map<String, Object> map = new HashMap<>();
        try{
            int roleId = permissionCustom.getRoleId();
            List<Permission> permissions = permissionCustom.getList();
            int count = rolePermissionMapper.deleteByRoleId(roleId);
            if(count == 0){
                pd = false;
            } else {
                for(Permission permission : permissions){
                    RolePermission rolePermission = new RolePermission();
                    rolePermission.setRoleId(roleId);
                    rolePermission.setPermissionId(permission.getId());
                    count = rolePermissionMapper.insert(rolePermission);
                    if(count == 0){
                        pd = false;
                        break;
                    }
                }
            }
            if (pd == true) {
                map.put("isSuccess", "1");
                map.put("msg", "修改成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "修改失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "修改失败！出现异常！");
        }
        return map;
    }

    /**
     * 更新映射
     * @param rolePermission
     * @return
     */
    public Map<String, Object> updateRoleAndPer(RolePermission rolePermission){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = rolePermissionMapper.updateByPrimaryKey(rolePermission);
            map.put("isSuccess", "1");
            map.put("msg", "更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "更新失败！");
        }
        return map;
    }





























}
