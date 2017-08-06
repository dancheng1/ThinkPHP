package com.ky.workover.job.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.job.model.JobResponsibilities;
import com.ky.workover.job.service.JobResponsibilitiesService;
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

@Controller
@RequestMapping(value = "job")
public class JobResponsibilitiesController extends BaseController {

	@Autowired
	private JobResponsibilitiesService jobResponsibilitiesService;

	@RequestMapping(method = RequestMethod.GET)
	public String toPage(HttpServletRequest request, HttpServletResponse response) {
		return "job/toPage";
	}
	@RequestMapping(value = "select",method = RequestMethod.GET)
	public String select(HttpServletRequest request, HttpServletResponse response) {
		return "/job/selectJob";
	}
	@RequestMapping(value = "insert",method = RequestMethod.GET)
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		return "/job/insertJob";
	}
	/**
	 * 查询岗位信息by_id
	 * @param jobResponsibilities
	 * @return
	 */
	@RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectByPrimaryKey(@RequestBody JobResponsibilities jobResponsibilities){
		Map<String, Object> map = new HashMap<>();
		try{
			map = jobResponsibilitiesService.findJobResponsibilitiesById(jobResponsibilities);
		} catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 查询所有岗位信息
	 * @param
	 * @return
	 */
	@RequestMapping(value = "selectJob", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectJob(){
		Map<String, Object> map = new HashMap<>();
		try{
			map = jobResponsibilitiesService.findJobResponsibilitiesList();
		} catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 新增岗位信息
	 * @param jobResponsibilities
	 * @return
	 */
	@RequestMapping(value = "insertJob", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertJob(@RequestBody JobResponsibilities jobResponsibilities){
		Map<String, Object> map = new HashMap<>();
		try{
			map = jobResponsibilitiesService.insertJobResponsibilities(jobResponsibilities);
		} catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 删除岗位信息
	 * @param jobResponsibilities
	 * @return
	 */
	@RequestMapping(value = "deleteJob", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteJob(@RequestBody JobResponsibilities jobResponsibilities){
		Map<String, Object> map = new HashMap<>();
		try{
			map = jobResponsibilitiesService.deleteJobResponsibilitiesById(jobResponsibilities);
		} catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 修改之前回显
	 * @param jobResponsibilities
	 * @return
	 */
	@RequestMapping(value = "editJob", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editJob(@RequestBody JobResponsibilities jobResponsibilities){
		Map<String, Object> map = new HashMap<>();
		try{
			map = jobResponsibilitiesService.editJob(jobResponsibilities);
		} catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 更新岗位信息
	 * @param jobResponsibilities
	 * @return
	 */
	@RequestMapping(value = "updateJob", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateJob(@RequestBody JobResponsibilities jobResponsibilities){
		Map<String, Object> map = new HashMap<>();
		try{
			map = jobResponsibilitiesService.updateJobResponsibilities(jobResponsibilities);
		} catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
}
