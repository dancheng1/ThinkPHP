package com.ky.workover.emp.mapper;

import com.ky.workover.emp.model.PersonUser;

import java.util.List;

public interface PersonUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(PersonUser record);

    int insertSelective(PersonUser record);

    PersonUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonUser record);

    int updateByPrimaryKey(PersonUser record);
    List<PersonUser>selectAll(PersonUser personUser);
}