package com.ky.workover.job.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.job.mapper.DepartmentMapper;
import com.ky.workover.job.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/1/18.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询全部部门信息
     * @return
     */
    public Map<String, Object> findDepartmentList(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<Department> list = departmentMapper.findfindDepartmentList();
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
     * 利用dept_id查询部门信息
     * @param department1
     * @return
     */
    public Map<String, Object> findDepartmentById(Department department1){
        Map<String, Object> map = new HashMap<>();
        try{
            Department department = departmentMapper.selectByPrimaryKey(department1.getDept_id());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(department,JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 新增部门信息
     * @param department
     * @return
     */
    public Map<String, Object> insertDepartment(Department department){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = departmentMapper.insert(department);
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
     * 利用id删除部门信息
     * @param department
     * @return
     */
    public Map<String, Object> deleteDepartmentById(Department department){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = departmentMapper.deleteByPrimaryKey(department.getDept_id());
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
     * @param department1
     * @return
     */
    public Map<String, Object> editDepartment(Department department1){
        Map<String, Object> map = new HashMap<>();
        try{
            Department department = departmentMapper.selectByPrimaryKey(department1.getDept_id());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(department, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    public Map<String, Object> updateDepartment(Department department){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = departmentMapper.updateByPrimaryKey(department);
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
