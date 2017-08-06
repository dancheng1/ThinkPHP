package com.ky.workover.job.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.job.mapper.JobResponsibilitiesMapper;
import com.ky.workover.job.model.JobResponsibilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/18.
 */
@Service
public class JobResponsibilitiesService {
    @Autowired
    private JobResponsibilitiesMapper jobResponsibilitiesMapper;

    /**
     * 查询全部工位信息
     * @param
     * @return
     */
    public Map<String, Object> findJobResponsibilitiesList(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<JobResponsibilities> list = jobResponsibilitiesMapper.findJobResponsibilitiesList();
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
     * 利用Position_id查询岗位信息
     * @param jobResponsibilities1
     * @return
     */
    public Map<String, Object> findJobResponsibilitiesById(JobResponsibilities jobResponsibilities1){
        Map<String, Object> map = new HashMap<>();
        try{
            JobResponsibilities jobResponsibilities = jobResponsibilitiesMapper.selectByPrimaryKey(jobResponsibilities1.getPosition_id());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(jobResponsibilities,JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 新增岗位信息
     * @param jobResponsibilities
     * @return
     */
    public Map<String, Object> insertJobResponsibilities(JobResponsibilities jobResponsibilities){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = jobResponsibilitiesMapper.insert(jobResponsibilities);
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
     * 删除岗位信息
     * @param jobResponsibilities
     * @return
     */
    public Map<String, Object> deleteJobResponsibilitiesById(JobResponsibilities jobResponsibilities){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = jobResponsibilitiesMapper.deleteByPrimaryKey(jobResponsibilities.getPosition_id());
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
     * @param jobResponsibilities1
     * @return
     */
    public Map<String, Object> editJob(JobResponsibilities jobResponsibilities1){
        Map<String, Object> map = new HashMap<>();
       try{
           JobResponsibilities jobResponsibilities = jobResponsibilitiesMapper.selectByPrimaryKey(jobResponsibilities1.getPosition_id());
           map.put("isSuccess", "1");
           map.put("rows", JSON.parse(JSON.toJSONString(jobResponsibilities, JsonUtils.isNullFilter)));
           map.put("msg", "查询成功！");
       } catch (Exception e){
           e.printStackTrace();
           map.put("isSuccess", "0");
           map.put("msg", "查询失败！");
       }
        return map;
    }

    /**
     * 更改岗位信息
     * @param jobResponsibilities
     * @return
     */
    public Map<String, Object> updateJobResponsibilities(JobResponsibilities jobResponsibilities){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = jobResponsibilitiesMapper.updateByPrimaryKey(jobResponsibilities);
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
