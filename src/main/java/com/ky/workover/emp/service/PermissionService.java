package com.ky.workover.emp.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.emp.mapper.PermissionMapper;
import com.ky.workover.emp.mapper.RoleMapper;
import com.ky.workover.emp.mapper.RolePermissionMapper;
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
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 查询所有权限信息
     * @return
     */
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<Permission> list = permissionMapper.findAll();
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
     * 查询权限by_id
     * @param permission1
     * @return
     */
    public Map<String, Object> selectByPrimaryKey(Permission permission1){
        Map<String, Object> map = new HashMap<>();
        try{
            Permission permission = permissionMapper.selectByPrimaryKey(permission1.getId());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(permission,JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 添加权限信息
     * @param permission
     * @return
     */
    public Map<String, Object> insertPer(Permission permission){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = permissionMapper.insert(permission);
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
     * 删除权限信息
     * @param permission
     * @return
     */
    public Map<String, Object> deletePer(Permission permission){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = permissionMapper.deleteByPrimaryKey(permission.getId());
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
     * @param permission1
     * @return
     */
    public Map<String, Object> editPer(Permission permission1){
        Map<String, Object> map = new HashMap<>();
        try{
            Permission permission = permissionMapper.selectByPrimaryKey(permission1.getId());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(permission, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 修改权限信息
     * @param permission
     * @return
     */
    public Map<String, Object> updatePer(Permission permission){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = permissionMapper.updateByPrimaryKey(permission);
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
