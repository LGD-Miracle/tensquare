package com.tenquare.user.controller;

import com.tenquare.base.pojo.Label;
import com.tenquare.base.service.LabelService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return new Result(true, 20000,"查询成功!",labelService.findAll());
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
        return new Result(true, 20000, "查询成功", labelService.findLabelById(id));
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
    public Result add() {
        Label label = new Label();
        System.out.println("进入了......");
        for (int i = 1; i <= 100; i++) {
            label.setId(i + "");
            label.setCount((long)(i+50));
            label.setFans((long)(i+5000));
            label.setLabelName("标签" + i);
            if(i%2 == 0) {
                label.setRecommend("是");
            } else {
                label.setRecommend("否");
            }
            label.setState("状态" + i);
            labelService.add(label);
        }
        return new Result(true, 20000, "增加成功!");
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
        return new Result(true, 20000, "修改成功!");
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
        return new Result(true, 20000, "删除成功!");
    }
}


