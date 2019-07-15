package com.alibaba.ant.mapper;


import com.github.pagehelper.Page;
import com.libaba.ant.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

public interface CheckItemMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加检查项
     * @param record
     * @return
     */
    int insert(CheckItem record);

    int insertSelective(CheckItem record);

    CheckItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckItem record);

    int updateByPrimaryKey(CheckItem record);

    /**分页查询
     * @param queryString
     * @return
     */
    Page<CheckItem> queryPage(@Param("queryString") String queryString);

    /**
     * 查询是否和检查组关联
     * @param id
     * @return
     */
    Integer queryCountFromGroup(@Param("checkitemId") Integer id);
}