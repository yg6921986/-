package com.alibaba.ant.controller;

import com.alibaba.ant.common.MessageConstant;
import com.alibaba.ant.service.CheckgroupService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.libaba.ant.pojo.CheckGroup;
import com.libaba.ant.pojo.PageResult;
import com.libaba.ant.pojo.QueryPageBean;
import com.libaba.ant.pojo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Francis.G.Yang
 * @version v1.0
 * @date 2019/7/15 23:23
 * @description 处理检查组逻辑
 **/

@RequestMapping("checkgroup")
@RestController
public class CheckgroupController {

    @Reference
    private CheckgroupService checkgroupService;


    /**
     * 新增检查项
     * @param checkGroup
     * @return
     */
    @RequestMapping("add")
    public Result add(@RequestBody CheckGroup checkGroup){
        try {
            checkgroupService.add(checkGroup);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @RequestMapping("queryPage")
    public PageResult queryPage(@RequestBody QueryPageBean queryPageBean){
            return checkgroupService.queryPage(queryPageBean);
    }

    /**
     * 根据id查询检查组
     * @param id
     * @return
     */
    @RequestMapping("queryById")
    public Result queryById(Integer id){
        try {
            CheckGroup checkGroup=checkgroupService.queryById(id);
            return new Result(true,checkGroup);
        } catch (Exception e) {
            return new Result(false,MessageConstant.FLUSH_FAIL);
        }
    }
}
