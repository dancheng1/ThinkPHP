package com.ky.workover.corp.mapper;

import com.ky.workover.corp.model.CorpSummaryDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorpSummaryDetailMapper {

    int deleteByPrimaryKey(String assetsno);

    int insert(CorpSummaryDetail record);

    int insertSelective(CorpSummaryDetail record);

    CorpSummaryDetail selectByPrimaryKey(String assetsno);

    int updateByPrimaryKeySelective(CorpSummaryDetail record);

    int updateByPrimaryKey(CorpSummaryDetail record);

    List<CorpSummaryDetail> findAll();

    List<CorpSummaryDetail> findCorpByAssType(String value);

    int updateUsesTate(String value);

    int updateUsesTate1(String value);
}