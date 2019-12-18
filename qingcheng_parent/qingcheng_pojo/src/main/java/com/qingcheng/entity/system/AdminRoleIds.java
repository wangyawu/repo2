package com.qingcheng.entity.system;

import com.qingcheng.pojo.system.Admin;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 86186
 * @Date 2019/10/14 18:23
 */
public class AdminRoleIds implements Serializable{
    private Admin admin;
    private List<Integer> roleIdList;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }
}
