package com.alibaba.ant.service;

import com.libaba.ant.pojo.CheckItem;
import com.libaba.ant.pojo.PageResult;
import com.libaba.ant.pojo.QueryPageBean;

import java.util.List;

public interface CheckitemService {
    /**
     * 增加检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult queryPage(QueryPageBean queryPageBean);

    /**
     * 删除检查项
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id查询检查项
     * @param id
     * @return
     */
    CheckItem queryById(Integer id);

    /**
     * 根据id更新数据
     * @param checkItem
     */
    void updateById(CheckItem checkItem);

    /**
     * 查询所有检查项
     * @return
     */
    List<CheckItem> queryAll();
}
