package com.alibaba.ant.controller;

import com.alibaba.ant.common.MessageConstant;
import com.alibaba.ant.service.CheckitemService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.libaba.ant.pojo.CheckItem;
import com.libaba.ant.pojo.PageResult;
import com.libaba.ant.pojo.QueryPageBean;
import com.libaba.ant.pojo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Francis.G.Yang
 * @version v1.0
 * @date 2019/7/15 14:54
 * @description TODO
 **/
@RestController
@RequestMapping("checkitem")
public class CheckitemController {

    @Reference
    private CheckitemService checkitemService;

    /**
     * 增加检查项
     * @param checkItem
     * @return
     */
    @RequestMapping("add")
    public Result add(@RequestBody CheckItem checkItem){
        try {
            checkitemService.add(checkItem);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }


    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @RequestMapping("queryPage")
    public PageResult queryPage(@RequestBody QueryPageBean queryPageBean){
            return checkitemService.queryPage(queryPageBean);
    }

    /**
     * 根据id删除检查项
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public Result delete(Integer id){
        try {
            checkitemService.delete(id);
        } catch (RuntimeException e){
            return new Result(false,e.getMessage());
        }catch (Exception e) {
            return new Result(false,MessageConstant.DELETE_CHECKGROUP_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_CHECKGROUP_SUCCESS);
    }

    /**
     * 根据id查询检查项
     * @param id
     * @return
     */
    @RequestMapping("queryById")
    public Result queryById(Integer id){
        try {
            CheckItem checkItem=checkitemService.queryById(id);
            return new Result(true,checkItem);
        } catch (Exception e) {
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }

    /**
     * 根据id更新数据
     * @param checkItem
     * @return
     */
    @RequestMapping("update")
    public Result updateById(@RequestBody CheckItem checkItem){
        try {
            checkitemService.updateById(checkItem);
            return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);
        } catch (Exception e) {
            return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
        }
    }


    /**
     * 查询所有检查项
     * @return
     */
    @RequestMapping("queryAll")
    public Result queryAll(){
        try {
            List<CheckItem> list=checkitemService.queryAll();
            return new Result(true,list);
        } catch (Exception e) {
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }

    }
}
