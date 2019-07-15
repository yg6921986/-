package com.alibaba.ant.serviceImpl;

import com.alibaba.ant.mapper.CheckGroupMapper;
import com.alibaba.ant.service.CheckgroupService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.libaba.ant.pojo.CheckGroup;
import com.libaba.ant.pojo.PageResult;
import com.libaba.ant.pojo.QueryPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Francis.G.Yang
 * @version v1.0
 * @date 2019/7/15 23:31
 * @description TODO
 **/
@Service(interfaceClass = CheckgroupService.class)
@Transactional
public class CheckgroupServiceImpl implements CheckgroupService {

    @Autowired
    private CheckGroupMapper checkGroupMapper;

    /**
     * 新增检查项
     * @param checkGroup
     */
    @Override
    public void add(CheckGroup checkGroup) {
     checkGroupMapper.insert(checkGroup);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult queryPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckGroup> page=checkGroupMapper.queryPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(),page.getResult());
    }


    /**
     * 根据id查询检查组
     * @param id
     * @return
     */
    @Override
    public CheckGroup queryById(Integer id) {
      return checkGroupMapper.selectByPrimaryKey(id);
    }

    /**
     * 编辑检查组
     * @param checkGroup
     */
    @Override
    public void update(CheckGroup checkGroup) {
        checkGroupMapper.updateByPrimaryKeySelective(checkGroup);
    }
}
