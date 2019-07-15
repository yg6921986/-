package com.alibaba.ant.mapper;


import com.github.pagehelper.Page;
import com.libaba.ant.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

public interface CheckGroupMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增检查组
     * @param record
     * @return
     */
    int insert(CheckGroup record);

    int insertSelective(CheckGroup record);

    CheckGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckGroup record);

    int updateByPrimaryKey(CheckGroup record);

    /**
     * 分页查询
     * @param queryString
     * @return
     */
    Page<CheckGroup> queryPage(@Param("queryString") String queryString);
}