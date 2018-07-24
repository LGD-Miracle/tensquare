package com.tenquare.base.dao;

import com.tenquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: Shaoyuan Du
 * @Description:
 * @Date: Created in 11:35 2018/7/23
 * @Version:
 */
@Repository
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
