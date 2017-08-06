package com.ky.workover.emp.mapper;

import com.ky.workover.emp.model.RolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteByRoleId(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    List<RolePermission> findAll();

}