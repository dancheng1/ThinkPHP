package com.ky.workover.work.web;

import com.ky.workover.work.model.PersonWorkover;
import com.ky.workover.work.service.PersonWorkoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/14.
 */
@Controller
@RequestMapping(value = "work")
public class PersonWorkoverController {

    @Autowired
    private PersonWorkoverService personWorkoverService;

    @RequestMapping(method = RequestMethod.GET)
    public String toPage(HttpServletRequest request,HttpServletResponse response){return  "work/toPage";}
    @RequestMapping( value = "select",method =  RequestMethod.GET)
    public String select(HttpServletRequest request,HttpServletResponse response){return  "work/showWorkOver";}
    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String update(HttpServletRequest request,HttpServletResponse response){return "work/updateWorkOver";};
    /**
     * 查询全部加班信息
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectWork() {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personWorkoverService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 加班信息查询By_id
     * @param personWorkover
     * @return
     */
    @RequestMapping(value = "selectByPK", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectByPrimaryKey(@RequestBody PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personWorkoverService.selectByPK(personWorkover);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 新增加班信息
     * @param personWorkover
     * @return
     */
    @RequestMapping(value = "insertWork", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertWork(@RequestBody PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personWorkoverService.insertPersonWorkover(personWorkover);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 增加多条加班信息
     * @param personWorkover
     * @return
     */
    @RequestMapping(value = "batchInsert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> batchInsert(List<PersonWorkover> personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personWorkoverService.insertListPersonWorkover(personWorkover);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除加班信息
     * @param personWorkover
     * @return
     */
    @RequestMapping(value = "deleteWork", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteWork(@RequestBody PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personWorkoverService.deletePersonWorkover(personWorkover);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 回显加班信息
     * @param personWorkover
     * @return
     */
    @RequestMapping(value = "editWork", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editWork(@RequestBody PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personWorkoverService.editPersonWorkover(personWorkover);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改加班信息
     * @param personWorkover
     * @return
     */
    @RequestMapping(value = "updateWork", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateWork(@RequestBody PersonWorkover personWorkover) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = personWorkoverService.updatePersonWorkover(personWorkover);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 加班审核
     * @param personWorkover
     * @return
     */
    @RequestMapping(value = "workAudit" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> workAudit(@RequestBody PersonWorkover personWorkover){
        Map<String,Object> map= new HashMap<>();
        try{
            map = personWorkoverService.workAudit(personWorkover);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
