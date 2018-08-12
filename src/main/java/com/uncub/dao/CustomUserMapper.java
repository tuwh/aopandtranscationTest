package com.uncub.dao;

import com.uncub.dto.ResourcePermission;
import com.uncub.dto.base.Role;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface CustomUserMapper {

    List<Role> queryRoleByUserId(Integer id);

    List<ResourcePermission> queryPermissionByUserId(Integer id);

}
