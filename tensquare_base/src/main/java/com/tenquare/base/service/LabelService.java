package com.tenquare.base.service;

import com.tenquare.base.dao.LabelDao;
import com.tenquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    /**
     *
     * @Description: 构建查询条件
     *
     * @param: [searchMap]
     * @return: org.springframework.data.jpa.domain.Specification<com.tenquare.base.pojo.Label>
     *
     */
    private Specification<Label> createSpecification(Map searchMap) {

        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root,
                 CriteriaQuery<?> criteriaQuery,
                      CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(searchMap.get("labelName") != null &&
                        !searchMap.get("labelName").equals("")) {
                    predicates.add(cb.like(root.get("labelName").
                            as(String.class),"%" + (String)searchMap.get("labelName") + "%"));
                }

                if(searchMap.get("state") != null && !searchMap.get("state").equals("")) {
                    predicates.add(cb.equal(root.get("state").as(String.class),
                            (String)searchMap.get("state")));
                }

                if(searchMap.get("recommend") != null && !"".equals(searchMap.get("recommend"))) {
                    predicates.add(cb.equal(root.get("recommend").as(String.class),
                            (String)searchMap.get("recommend")));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    /**
     *
     * @Description: 条件查询
     *
     * @param: [searchMap]
     * @return: java.util.List<com.tenquare.base.pojo.Label>
     *
     */
    public List<Label> findSearch(Map searchMap) {
        Specification specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    /**
     *
     * @Description: 条件分页查询
     *
     * @param: [searchMap, page, size]
     * @return: org.springframework.data.domain.Page<com.tenquare.base.pojo.Label>
     *
     */
    public Page<Label> findSearch(Map searchMap, int page, int size) {
        Specification specification = createSpecification(searchMap);
        PageRequest request = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification, request);
    }
}
