package com.ky.workover.emp.mapper;

import com.ky.workover.emp.model.Permission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> findAll();

    List<Permission> findPerByRole(Integer id);
}