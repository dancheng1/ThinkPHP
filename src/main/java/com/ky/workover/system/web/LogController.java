package com.ky.workover.system.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.system.service.LogsService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 日志controller
 * @author ty
 * @date 2015年1月14日
 */
@Controller
@RequestMapping("system/log")
public class LogController extends BaseController {

	@Autowired
	private LogsService logService;
	
	/**
	 * 默认页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(){
		return "system/logList";
	}
	/**
	 * 获取日志json
	 */
	@RequestMapping(value="json",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(@RequestBody com.ky.workover.system.model.Log log) {
		RowBounds rowBounds=getMybatisPage(log.getPage(),log.getRows());
		return logService.search(rowBounds, (com.ky.workover.common.log.basic.Log) log);
	}
	
	/**
	 * 删除日志
	 * @param log
	 */
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete(@RequestBody com.ky.workover.system.model.Log log) {
		Map<String, Object> map = logService.delete(log.getId());
		return map;
	}
	
	/**
	 * 批量删除日志
	 * @param idList
	 */
	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteBatch(@RequestBody List<Integer> idList) {
		Map<String, Object> map = logService.deleteBatch(idList);
		return map;
	}

	/**
	 * 导出excel
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("exportExcel")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		/*response.setContentType("application/msexcel;charset=GBK");
        
        List<Log> list = logService.getAll();//获取数据
        
        String title = "log";
        String[] hearders = new String[] {"操作编码", "详细描述", "执行时间(mm)", "操作系统", "浏览器", "IP","MAC","操作者","操作时间"};//表头数组
        String[] fields = new String[] {"operationCode", "description", "executeTime", "os", "browser", "ip","mac","creater","createDate"};//People对象属性数组
        TableData td = ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders),fields);
        JsGridReportBase report = new JsGridReportBase(request, response);
        report.exportToExcel(title, "admin", td);*/
	}
}
