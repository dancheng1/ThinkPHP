package com.ky.workover.boreturn.web;

import com.ky.workover.boreturn.model.BoreturnDetail;
import com.ky.workover.boreturn.service.BoreturnDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 */
@Controller
@RequestMapping(value = "/bord")
public class BoreturnDetailController {

    @Autowired
    private BoreturnDetailService boreturnDetailService;

    /**
     * 查询全部借还明细
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnDetailService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询明细By_id
     * @param boreturnDetail
     * @return
     */
    @RequestMapping(value = "findById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findById(@RequestBody BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnDetailService.findById(boreturnDetail);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 新增明细信息
     * @param boreturnDetail
     * @return
     */
    @RequestMapping(value = "insertBoreturnDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertBoreturnDetail(@RequestBody BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnDetailService.insertBoreturnDetail(boreturnDetail);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除明细信息
     * @param boreturnDetail
     * @return
     */
    @RequestMapping(value = "deleteBoreturnDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteBoreturnDetail(@RequestBody BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnDetailService.deleteBoreturnDetail(boreturnDetail);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回显明细信息
     * @param boreturnDetail
     * @return
     */
    @RequestMapping(value = "editBoreturnDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editBoreturnDetail(@RequestBody BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnDetailService.editBoreturnDetail(boreturnDetail);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改明细信息
     * @param boreturnDetail
     * @return
     */
    @RequestMapping(value = "updateBoreturnDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateBoreturnDetail(@RequestBody BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnDetailService.updateBoreturnDetail(boreturnDetail);
        } catch (Exception e){
            e.printStackTrace();
        }

        return map;
    }
}
