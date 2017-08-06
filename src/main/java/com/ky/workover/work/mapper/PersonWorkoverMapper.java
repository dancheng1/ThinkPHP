package com.ky.workover.work.mapper;

import com.ky.workover.work.model.PersonWorkover;
import java.util.List;

public interface PersonWorkoverMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PersonWorkover record);

    int insertSelective(PersonWorkover record);

    PersonWorkover selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonWorkover record);

    int updateByPrimaryKey(PersonWorkover record);

    List<PersonWorkover> findAll();

    int workAudit(PersonWorkover personWorkover);

    int batchInsert(List<PersonWorkover> wo);
}