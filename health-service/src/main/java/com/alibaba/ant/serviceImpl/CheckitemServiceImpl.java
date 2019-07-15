package com.alibaba.ant.serviceImpl;

import com.alibaba.ant.mapper.CheckItemMapper;
import com.alibaba.ant.service.CheckitemService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.libaba.ant.pojo.CheckItem;
import com.libaba.ant.pojo.PageResult;
import com.libaba.ant.pojo.QueryPageBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Francis.G.Yang
 * @version v1.0
 * @date 2019/7/15 15:02
 * @description 检查项
 **/
@Service
public class CheckitemServiceImpl implements CheckitemService {
    @Autowired
    private CheckItemMapper checkItemMapper;
    /**
     * 增加检查项
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemMapper.insert(checkItem);
    }


    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult queryPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckItem> page=checkItemMapper.queryPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(),page.getResult());
    }


    /**
     * 删除检查项
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        //如果检查组有该项则不可以删除
        Integer count=checkItemMapper.queryCountFromGroup(id);
        if (count!=null&count>0){
            throw new RuntimeException("不可以乱删除哦，小护士");
        }
        checkItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id查询检查项
     *
     * @param id
     * @return
     */
    @Override
    public CheckItem queryById(Integer id) {
        return checkItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据id更新数据
     *
     * @param checkItem
     */
    @Override
    public void updateById(CheckItem checkItem) {
        checkItemMapper.updateByPrimaryKeySelective(checkItem);
    }

    /**
     * 查询所有检查项
     *
     * @return
     */
    @Override
    public List<CheckItem> queryAll() {
        return checkItemMapper.queryAll();
    }
}
