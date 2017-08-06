package com.ky.workover.corp.web;

import com.ky.workover.corp.model.CorpSummaryDetail;
import com.ky.workover.corp.service.CorpSummaryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/17.
 */
@Controller
@RequestMapping(value ="corp")
public class CorpSummaryDetailController {

    @Autowired
    private CorpSummaryDetailService corpSummaryDetailService;

    @RequestMapping(method = RequestMethod.GET)
    public String toPage(HttpServletRequest request,HttpServletResponse response){return  "corp/toPage";}
    @RequestMapping( value = "select",method =  RequestMethod.GET)
    public String select(HttpServletRequest request,HttpServletResponse response){return  "corp/selectCorp";}
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String update(HttpServletRequest request,HttpServletResponse response){return "corp/insertCorp";};

    /**
     * 查询公司资产By_id
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "selectByPrimaryKey" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectByPrimaryKey (@RequestBody CorpSummaryDetail corpSummaryDetail){
        Map<String,Object> map=new HashMap<>();
        try{
            map = corpSummaryDetailService.selectByPrimaryKey(corpSummaryDetail);

        }catch(Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据资产类别查询资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "findByAssType" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findByAssType (@RequestBody CorpSummaryDetail corpSummaryDetail){
        Map<String,Object> map=new HashMap<>();
        try{
            map = corpSummaryDetailService.findByAssType(corpSummaryDetail);

        }catch(Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询公司全部资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "selectCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectCorp(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = corpSummaryDetailService.selectCorp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 新增公司资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "insertCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertCorp(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = corpSummaryDetailService.insertCorp(corpSummaryDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除公司资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "deleteCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteCorp(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = corpSummaryDetailService.deleteCorp(corpSummaryDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回显公司资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "editCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editSys(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = corpSummaryDetailService.editCorp(corpSummaryDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 更新公司资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "updateCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateCorp(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = corpSummaryDetailService.updateCorp(corpSummaryDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}

