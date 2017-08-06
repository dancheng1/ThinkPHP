package com.ky.workover.boreturn.mapper;

import com.ky.workover.boreturn.model.Boreturn;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoreturnMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Boreturn record);

    int insertSelective(Boreturn record);

    Boreturn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Boreturn record);

    int updateByPrimaryKey(Boreturn record);
    
    List<Boreturn> findAll();

    List<Boreturn> findByOrder(String value);

    Boreturn findByOrderId(String value);
}