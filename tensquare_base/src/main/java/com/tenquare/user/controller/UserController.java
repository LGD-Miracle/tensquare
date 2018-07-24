package com.tenquare.user.controller;

import com.tenquare.base.pojo.Label;
import com.tenquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: Shaoyuan Du
 * @Description: 标签控制层
 * @Date: Created in 11:50 2018/7/23
 * @Version:
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class UserController {

    @Autowired
    private LabelService labelService;

    /**
     *
     * @Description: 查询所有标签
     *
     * @param: []
     * @return: entity.Result<com.tenquare.base.pojo.Label>
     *
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<Label> findAll() {
        return new Result(true, StatusCode.OK,"查询成功!",labelService.findAll());
    }

    /**
     *
     * @Description: 根据ID查询标签
     *
     * @param: [id]
     * @return: entity.Result
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result<Label> findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findLabelById(id));
    }

    /**
     *
     * @Description: 增加标签
     *
     * @param:
     * @return:
     *
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result add(Label label) {
            labelService.add(label);
        return new Result(true, StatusCode.OK, "增加成功!");
    }

    /**
     *
     * @Description: 修改标签
     *
     * @param:
     * @return:
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Label label, String id) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功!");
    }

    /**
     *
     * @Description: 删除标签
     *
     * @param:
     * @return:
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        labelService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功!");
    }
    
    /**
     *
     * @Description: 根据条件查询
     *
     * @param: [searchMap]
     * @return: entity.Result<java.util.List>
     *
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result<List> findSearch(@RequestBody Map searchMap) {
        return new Result<>(true, StatusCode.OK, "查询成功!",
                labelService.findSearch(searchMap));
    }

    /**
     *
     * @Description: 条件分页查询
     *
     * @param: [searchMap, page, size]
     * @return: entity.Result<java.util.List>
     *
     */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result<List> findSearch(@RequestBody Map searchMap
            , @PathVariable int page, @PathVariable int size) {
        Page pageList = labelService.findSearch(searchMap, page, size);
        return new Result<>(true, StatusCode.OK,"查询成功!",
                new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
    }
}


