package com.ky.workover.system.service;

import com.ky.workover.common.log.basic.Log;
import com.ky.workover.system.mapper.LogsMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志service
 *
 * @author ty
 * @date 2015年1月14日
 */
@Service("logsService")
@Transactional(readOnly = true)
public class LogsService {

    @Autowired
    private LogsMapper logMapper;


    /**
     * 批量删除日志
     *
     * @param idList
     */
    @Transactional(readOnly = false)
    public Map<String, Object> deleteBatch(List<Integer> idList) {

        Map<String, Object> map = new HashMap<>();
        try {
            logMapper.deleteBatch(idList);
            map.put("isSuccess", "1");//成功
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.toString());
            map.put("isSuccess", "0");
        }
        return map;
    }

    /**
     * 删除日志
     *
     * @param id
     */
    public Map<String,Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
                logMapper.deleteLog(id);
                map.put("isSuccess", "1");//成功
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.toString());
            map.put("isSuccess","0");
        }
        return map;
    }

    /**
     * 保存日志
     *
     * @param log
     */
    public void save(Log log) {
        logMapper.insertLog(log);
    }

    /**
     * 查询日志
     *
     * @param rowBounds
     * @param log
     * @return
     */
    public Map<String,Object> search(RowBounds rowBounds, Log log) {
        Map<String, Object> logViewMap = new HashMap();
        List<Log> logs = logMapper.searchAll(log);
        List<Log> logList = logMapper.searchAll(rowBounds, log);
        logViewMap.put("isSuccess", "1");
        logViewMap.put("total", logs.size());
        logViewMap.put("rows", logList);
        return logViewMap;
    }
}
