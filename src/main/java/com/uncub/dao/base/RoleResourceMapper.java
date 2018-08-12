package com.uncub.dao.base;

import com.uncub.condition.RoleResourceConditions;
import com.uncub.dto.base.RoleResource;
import com.uncub.framework.dao.Pagination;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface RoleResourceMapper {
    /**
    * 根据主键进行删除
    * @Param id
    * @auth tuwh
    */
    int deleteRoleResourceById(Integer id);

    /**
    * 根据主键进行新增,插入所有字段
    * @Param roleResource
    */
    int insert(RoleResource roleResource);

    /**
    * 根据主键进行新增,插入非空字段
    * @Param roleResource
    */
    int insertSelective(RoleResource roleResource);

    /**
    * 根据查询条件进行查找
    * @Param roleResource
    * @auth tuwh
    */
    List<RoleResource> queryRoleResourceByConditions(RoleResourceConditions roleResourceConditions);

    /**
    * 根据主键进行查找
    * @Param roleResource
    * @auth tuwh
    */
    RoleResource selectRoleResourceById(Integer id);

    /**
    * 根据主键进行更新，仅更新非主空字段
    * @Param roleResource
    */
    int updateRoleResourceByIdSelective(RoleResource roleResource);

    /**
    * 根据主键进行更新，更新所有字段
    * @Param roleResource
    */
    int updateRoleResourceById(RoleResource roleResource);

    /**
    * 根据所有不为空条件进行查询，分页。结果将传入@Param pagination 参数中
    */
    List<RoleResource> queryRoleResource(RoleResource roleResource, Pagination pagination);

    /**
    * 根据所有不为空条件进行查询，不分页
    */
    List<RoleResource> queryRoleResource(RoleResource roleResource);

    /**
    * 根据所有不为空条件进行查询，分页。结果将传入@Param pagination 参数中
    */
    List<RoleResource> queryRoleResourceByConditions(RoleResourceConditions roleResourceConditions, Pagination pagination);
}