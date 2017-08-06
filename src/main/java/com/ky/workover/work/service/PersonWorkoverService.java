package com.ky.workover.work.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.work.mapper.PersonWorkoverMapper;
import com.ky.workover.work.model.PersonWorkover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/14.
 */
@Service
public class PersonWorkoverService {

    @Autowired
    private PersonWorkoverMapper personWorkoverMapper;

    /**
     * 查询所有加班信息
     * @return
     */
    public Map<String, Object> findAll() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<PersonWorkover> list = personWorkoverMapper.findAll();
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
     * 查询加班信息By_id
     * @param personWorkover
     * @return
     */
    public Map<String,Object> selectByPK(PersonWorkover personWorkover){
        Map<String, Object> map = new HashMap<>();
        try {
            PersonWorkover personWorkover1 = personWorkoverMapper.selectByPrimaryKey(personWorkover.getId());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(personWorkover1,JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        }catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 新增加班信息
     * @param personWorkover
     * @return
     */
    public Map<String, Object> insertPersonWorkover(PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            System.out.println(personWorkover);
            int count = personWorkoverMapper.insert(personWorkover);   //定义一个count   获取将要插入的数据
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
     * 新增多条加班信息
     * @param personWorkover
     * @return
     */
    public Map<String, Object> insertListPersonWorkover(List<PersonWorkover> personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = personWorkoverMapper.batchInsert(personWorkover);   //定义一个count   获取将要插入的数据
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
     * 删除加班信息
     * @param personWorkover
     * @return
     */
    public Map<String, Object> deletePersonWorkover(PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = personWorkoverMapper.deleteByPrimaryKey(personWorkover.getId());
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
     * 回显加班记录
     * @param personWorkover
     * @return
     */
    public Map<String, Object> editPersonWorkover(PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            PersonWorkover personWorkover1 = personWorkoverMapper.selectByPrimaryKey(personWorkover.getId());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(personWorkover1, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 修改加班记录
     * @param personWorkover
     * @return
     */
    public Map<String, Object> updatePersonWorkover(PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = personWorkoverMapper.updateByPrimaryKey(personWorkover);
            map.put("isSuccess", "1");
            map.put("msg", "更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "更新失败！");
        }
        return map;
    }

    /**
     * 加班审核
     * @param personWorkover
     * @return
     */
    public Map<String,Object>workAudit(PersonWorkover personWorkover){
        Map<String,Object> map=new HashMap<>();
        try{
            int count = personWorkoverMapper.workAudit(personWorkover);
            map.put("isSuccess", "1");
            map.put("msg", "更新成功！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "更新失败！");
        }

        return map;
    }

}
