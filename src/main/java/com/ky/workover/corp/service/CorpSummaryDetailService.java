package com.ky.workover.corp.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.corp.mapper.CorpSummaryDetailMapper;
import com.ky.workover.corp.model.CorpSummaryDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/17.
 */
@Service
public class CorpSummaryDetailService {

    @Autowired
    private CorpSummaryDetailMapper corpSummaryDetailMapper;

    /**
     * 查询公司资产By_id
     * @param corpSummaryDetail1
     * @return
     */
    public Map<String,Object> selectByPrimaryKey(CorpSummaryDetail corpSummaryDetail1){
        Map<String, Object> map = new HashMap<>();
        try {
            CorpSummaryDetail corpSummaryDetail = corpSummaryDetailMapper.selectByPrimaryKey(corpSummaryDetail1.getAssetsno());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(corpSummaryDetail, JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        }catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 根据类别查询资产信息
     * @param corpSummaryDetail
     * @return
     */
    public Map<String,Object> findByAssType(CorpSummaryDetail corpSummaryDetail){
        Map<String, Object> map = new HashMap<>();
        try {
            List<CorpSummaryDetail> list = corpSummaryDetailMapper.findCorpByAssType(corpSummaryDetail.getAssetstype());
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
     * 查询公司全部资产
     * @return
     */
    public Map<String, Object> selectCorp() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<CorpSummaryDetail> list = corpSummaryDetailMapper.findAll();
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
     * 新增公司资产
     * @param corpSummaryDetail
     * @return
     */
    public Map<String, Object> insertCorp(CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<CorpSummaryDetail> list = corpSummaryDetailMapper.findAll();
            int ok = 1;
            for(CorpSummaryDetail corpSummaryDetail1 : list){
                if(corpSummaryDetail.getAssetsno().equals(corpSummaryDetail1.getAssetsno())){
                    ok = 0;
                }
            }
            if(ok == 1){
                int count = corpSummaryDetailMapper.insert(corpSummaryDetail);   //定义一个count   获取将要插入的数据
                if (count != 0) {
                    map.put("isSuccess", "1");
                    map.put("msg", "保存成功！");
                } else {
                    map.put("isSuccess", "0");
                    map.put("msg", "保存失败！");
                }
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "资产编号重复");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "保存失败！");
        }
        return map;
    }

    /**
     * 删除公司资产信息
     * @param corpSummaryDetail
     * @return
     */
    public Map<String, Object> deleteCorp(CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = corpSummaryDetailMapper.deleteByPrimaryKey(corpSummaryDetail.getAssetsno());
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
     * 回显公司资产
     * @param corpSummaryDetail1
     * @return
     */
    public Map<String, Object> editCorp(CorpSummaryDetail corpSummaryDetail1) {
        Map<String, Object> map = new HashMap<>();
        try {
            CorpSummaryDetail corpSummaryDetail = corpSummaryDetailMapper.selectByPrimaryKey(corpSummaryDetail1.getAssetsno());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(corpSummaryDetail, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    public Map<String, Object> updateCorp(CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = corpSummaryDetailMapper.updateByPrimaryKey(corpSummaryDetail);
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
