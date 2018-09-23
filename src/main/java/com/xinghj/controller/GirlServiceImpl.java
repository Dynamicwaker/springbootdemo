package com.xinghj.controller;

import com.xinghj.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.14:00
 * @description
 */
@Service
public class GirlServiceImpl implements Girlservice {

    @Autowired
    private GirlRepository girlRepository;
    // 事务，查询不需要加事务
    @Override
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(24);
        girlRepository.save(girlB);
    }
}
