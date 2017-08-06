package com.ky.workover.emp.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;

import com.ky.workover.emp.mapper.PersonUserMapper;

import com.ky.workover.emp.model.PersonUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lau on 2017/1/3.
 */
@Service
public class PersonUserService {


    @Autowired
    private PersonUserMapper personUserMapper;

    /**
     * 查询员工信息 all
     */
    public Map<String, Object> selectEmp(PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<PersonUser> list = personUserMapper.selectAll(personUser);
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
            map.put("total", list.size());  //对list的数量进行汇总
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息

        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }





    /**
     * 查询员工信息 by_id
     */
    public Map<String, Object> selectByPrimaryKey(PersonUser person) {
        Map<String, Object> map = new HashMap<>();
        try {
            PersonUser personUser = personUserMapper.selectByPrimaryKey(person.getId());
            map.put("isSuccess", "1");  //注入结果集
//            map.put("rows", personUser);   //获取信息
            map.put("rows", JSON.parse(JSON.toJSONString(personUser,JsonUtils.isNullFilter)));   //获取信息
//          map.put("total", list.size());  //对list的数量进行汇总
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }



    /**
     * 新增员工信息
     *
     * @param personUser
     * @return
     */
    public Map<String, Object> insertEmp(PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = personUserMapper.insertSelective(personUser);   //定义一个count   获取将要插入的数据
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
     * 删除员工信息
     *
     * @param personUser
     * @return
     */
    public Map<String, Object> deleteEmp(PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = personUserMapper.deleteByPrimaryKey(personUser.getId());
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
     *
     * @param personUser
     * @return
     */
    public Map<String, Object> editEmp(PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            PersonUser emp = personUserMapper.selectByPrimaryKey(personUser.getId());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(emp, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 更新员工信息
     *
     * @param personUser
     * @return
     */
    public Map<String, Object> updateEmp(PersonUser personUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = personUserMapper.updateByPrimaryKeySelective(personUser);
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
