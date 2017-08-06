package com.ky.workover.boreturn.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.boreturn.mapper.BoreturnDetailMapper;
import com.ky.workover.boreturn.model.BoreturnDetail;
import com.ky.workover.common.json.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service
public class BoreturnDetailService {

    @Autowired
    private BoreturnDetailMapper boreturnDetailMapper;

    /**
     * 查询全部借还明细
     * @return
     */
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<BoreturnDetail> list = boreturnDetailMapper.findAll();
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
     * 查询借还明细By_id
     * @param boreturnDetail1
     * @return
     */
    public Map<String, Object> findById(BoreturnDetail boreturnDetail1){
        Map<String, Object> map = new HashMap<>();
        try{
            BoreturnDetail boreturnDetail = boreturnDetailMapper.selectByPrimaryKey(boreturnDetail1.getId());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(boreturnDetail,JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 新增借还明细
     * @param boreturnDetail
     * @return
     */
    public Map<String, Object> insertBoreturnDetail(BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = boreturnDetailMapper.insert(boreturnDetail);
            if(count != 0){
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
     * 删除借还明细
     * @param boreturnDetail
     * @return
     */
    public Map<String, Object> deleteBoreturnDetail(BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = boreturnDetailMapper.deleteByPrimaryKey(boreturnDetail.getId());
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
     * 回显借还明细
     * @param boreturnDetail
     * @return
     */
    public Map<String, Object> editBoreturnDetail(BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            BoreturnDetail boreturnDetail1 = boreturnDetailMapper.selectByPrimaryKey(boreturnDetail.getId());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(boreturnDetail1, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    public Map<String, Object> updateBoreturnDetail(BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = boreturnDetailMapper.updateByPrimaryKey(boreturnDetail);
            map.put("isSuccess", "1");
            map.put("msg", "更新成功！");
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "更新失败！");
        }
        return map;
    }
}
