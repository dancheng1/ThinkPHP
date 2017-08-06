package com.ky.workover.emp.mapper;


import com.ky.workover.emp.model.Role;

import java.util.List;

public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findAll();

    List<Role> findByUserId(String value);
}