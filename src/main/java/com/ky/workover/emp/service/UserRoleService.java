package com.ky.workover.emp.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.emp.mapper.UserRoleMapper;
import com.ky.workover.emp.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/23.
 */
@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 查询所有用户和角色的映射关系
     * @return
     */
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<UserRole> list =  userRoleMapper.findAll();
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
     * 查询用户和角色的映射关系 by_id
     * @param userRole1
     * @return
     */
    public Map<String, Object> selectByPrimaryKey(UserRole userRole1){
        Map<String, Object> map = new HashMap<>();
        try{
            UserRole userRole = userRoleMapper.selectByPrimaryKey(userRole1.getId());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(userRole,JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 添加映射关系
     * @param userRole
     * @return
     */
    public Map<String, Object> insertUserAndRole(UserRole userRole){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = userRoleMapper.insert(userRole);
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
     * 删除映射关系
     * @param userRole
     * @return
     */
    public Map<String, Object> deleteUserAndRole(UserRole userRole){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = userRoleMapper.deleteByPrimaryKey(userRole.getId());
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
     * @param userRole1
     * @return
     */
    public Map<String, Object> editUserAndRole(UserRole userRole1){
        Map<String, Object> map = new HashMap<>();
        try{
            UserRole userRole = userRoleMapper.selectByPrimaryKey(userRole1.getId());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(userRole, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 修改映射关系
     * @param userRole
     * @return
     */
    public Map<String, Object> updateUserAndRole(UserRole userRole){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = userRoleMapper.updateByPrimaryKey(userRole);
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
