package com.ky.workover.emp.model;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public class PermissionCustom {
    List<Permission> list;
    int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Permission> getList() {
        return list;
    }

    public void setList(List<Permission> list) {
        this.list = list;
    }
}
