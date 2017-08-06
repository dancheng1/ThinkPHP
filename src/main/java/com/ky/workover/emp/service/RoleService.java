package com.ky.workover.emp.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.emp.mapper.PermissionMapper;
import com.ky.workover.emp.mapper.RoleMapper;
import com.ky.workover.emp.model.Permission;
import com.ky.workover.emp.model.PersonUser;
import com.ky.workover.emp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/22.
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;


    public Map<String, Object> findPerByRole(Role role){
        Map<String, Object> map = new HashMap<>();
        try{
            List<Permission> list = permissionMapper.findPerByRole(role.getId());
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
     * 查询用户角色
     * @param personUser
     * @return
     */
    public Map<String, Object> findByUserId(PersonUser personUser){
        Map<String, Object> map = new HashMap<>();
        try{
            List<Role> list = roleMapper.findByUserId(personUser.getId());
            map.put("rows", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
            map.put("isSuccess", "1");  //注入结果集
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 查询所有角色
     * @return
     */
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<Role> list = roleMapper.findAll();
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows1", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
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
     * 查询角色by_id
     * @param role1
     * @return
     */
    public Map<String, Object> selectByPrimaryKey(Role role1){
        Map<String, Object> map = new HashMap<>();
        try {
            Role role = roleMapper.selectByPrimaryKey(role1.getId());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(role,JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    public Map<String, Object> insertRole(Role role){
        Map<String, Object> map = new HashMap<>();
        try {
            int count = roleMapper.insert(role);
            if (count != 0) {
                map.put("isSuccess", "1");
                map.put("msg", "保存成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "保存失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "保存失败！");
        }
        return map;
    }

    /**
     * 删除角色信息
     * @param role
     * @return
     */
    public Map<String, Object> deleteRole(Role role){
        Map<String, Object> map = new HashMap<>();
        try {
            int count = roleMapper.deleteByPrimaryKey(role.getId());
            if (count != 0) {
                map.put("isSuccess", "1");
                map.put("msg", "删除成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "删除失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "删除失败！");
        }
        return map;
    }

    /**
     * 回显
     * @param role1
     * @return
     */
    public Map<String, Object> editRole(Role role1){
        Map<String, Object> map = new HashMap<>();
        try {
            Role role = roleMapper.selectByPrimaryKey(role1.getId());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(role, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    public Map<String, Object> updateRole(Role role){
        Map<String, Object> map = new HashMap<>();
        try {
            int count = roleMapper.updateByPrimaryKey(role);
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
