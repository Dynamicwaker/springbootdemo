package com.xinghj.controller;

import com.xinghj.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.13:27
 * @description
 */

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // 通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
