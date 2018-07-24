package com.tenquare.base.service;

import com.tenquare.base.dao.LabelDao;
import com.tenquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Shaoyuan Du
 * @Description:
 * @Date: Created in 11:42 2018/7/23
 * @Version:
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     *
     * @Description: 查询全部标签
     *
     * @param: []
     * @return: java.util.List<com.tenquare.base.pojo.Label>
     *
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     *
     * @Description: 根据ID查询标签
     *
     * @param:
     * @return:
     *
     */
    public Label findLabelById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     *
     * @Description: 增加标签
     *
     * @param:
     * @return:
     *
     */
    public void add(Label label) {
        // 设置ID
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     *
     * @Description: 修改标签
     *
     * @param:
     * @return:
     *
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     *
     * @Description: 删除标签
     *
     * @param:
     * @return:
     *
     */
    public void delete(String id) {
        labelDao.deleteById(id);
    }
}
