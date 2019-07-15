package com.alibaba.ant.service;

import com.libaba.ant.pojo.CheckGroup;
import com.libaba.ant.pojo.PageResult;
import com.libaba.ant.pojo.QueryPageBean;

public interface CheckgroupService {


    /**
     * 新增检查项
     * @param checkGroup
     */
    void add(CheckGroup checkGroup);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult queryPage(QueryPageBean queryPageBean);

    /**
     * 根据id查询检查组
     * @param id
     * @return
     */
    CheckGroup queryById(Integer id);

    /**
     * 编辑检查组
     * @param checkGroup
     */
    void update(CheckGroup checkGroup);

    /**
     * 删除检查组
     * @param id
     */
    void delete(Integer id);
}
