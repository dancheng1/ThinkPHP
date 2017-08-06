package com.ky.workover.boreturn.mapper;

import com.ky.workover.boreturn.model.BoreturnDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoreturnDetailMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BoreturnDetail record);

    int insertSelective(BoreturnDetail record);

    BoreturnDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoreturnDetail record);

    int updateByPrimaryKey(BoreturnDetail record);

    List<BoreturnDetail> findAll();

    List<BoreturnDetail> findListByCorpId(String value);

    List<BoreturnDetail> findListByBorrowId(String value);
}