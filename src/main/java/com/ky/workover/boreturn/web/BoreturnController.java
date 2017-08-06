package com.ky.workover.boreturn.web;

import com.ky.workover.boreturn.model.Boreturn;
import com.ky.workover.boreturn.model.BoreturnCustom;
import com.ky.workover.boreturn.model.BoreturnDetail;
import com.ky.workover.boreturn.service.BoreturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 */
@Controller
@RequestMapping(value = "/bor")
public class BoreturnController {

    @Autowired
    private BoreturnService boreturnService;

    @RequestMapping(method = RequestMethod.GET)
    public String toPage(HttpServletRequest request,HttpServletResponse response){return  "corp/toPage";}
    @RequestMapping( value = "borrow",method =  RequestMethod.GET)
    public String select(HttpServletRequest request,HttpServletResponse response){return  "corp/borrowCorp";}
    @RequestMapping(value = "return",method = RequestMethod.GET)
    public String update(HttpServletRequest request,HttpServletResponse response){return "";};

    /**
     * 查询全部借还单子
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询借还单子By_id
     * @param boreturn
     * @return
     */
    @RequestMapping(value = "findById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findById(@RequestBody Boreturn boreturn){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnService.findById(boreturn);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据物品号模糊查询所有单子信息
     * @param boreturnDetail
     * @return
     */
    @RequestMapping(value = "findListByCorpId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findListByCorpId(@RequestBody BoreturnDetail boreturnDetail){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnService.findListByCorpId(boreturnDetail);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 插入借单子
     * @param boreturnCustom
     * @return
     */
    @RequestMapping(value = "insertBoreturn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertBoreturn(@RequestBody BoreturnCustom boreturnCustom){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnService.insertBoreturn(boreturnCustom);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 插入还单子
     * @param boreturnCustom
     * @return
     */
    @RequestMapping(value = "insertBoreturn1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertBoreturn1(@RequestBody BoreturnCustom boreturnCustom){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnService.insertBoreturn1(boreturnCustom);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除借还单子
     * @param boreturn
     * @return
     */
    @RequestMapping(value = "deleteBoreturn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteBoreturn(@RequestBody Boreturn boreturn){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnService.deleteBoreturn(boreturn);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回显借还单子
     * @param boreturn
     * @return
     */
    @RequestMapping(value = "editBoreturn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editBoreturn(@RequestBody Boreturn boreturn){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnService.editBoreturn(boreturn);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改借还单子
     * @param boreturn
     * @return
     */
    @RequestMapping(value = "updateBoreturn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateBoreturn(@RequestBody Boreturn boreturn){
        Map<String, Object> map = new HashMap<>();
        try{
            map = boreturnService.updateBoreturn(boreturn);
        } catch (Exception e){
            e.printStackTrace();
        }

        return map;
    }
}
