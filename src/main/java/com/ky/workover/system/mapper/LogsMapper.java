package com.ky.workover.system.mapper;

import com.ky.workover.common.log.basic.Log;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by wanglqing on 2016/5/26.
 */
public interface LogsMapper {

    /**
     * 批量删除
     * @param idList
     */
    void deleteBatch(List<Integer> idList);

    /**
     * 查询日志列表
     * @param log
     * @return
     */
    List<Log> searchAll(Log log);

    /**
     * 保存日志
     * @param log
     */
    void insertLog(Log log);

    /**
     * 删除日志
     * @param id
     */
    void deleteLog(Integer id);

    /**
     * 查询日志列表
     * @param log
     * @return
     */
    List<Log> searchAll(RowBounds rowBounds, Log log);
}
