package com.xinghj.controller;

import com.xinghj.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.13:23
 * @description
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private Girlservice girlservice;

    /**
     * 查询所有女生列表
     *
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param cupSize
     * @param age
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    @PostMapping(value = "/girlAdd")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     *
     * @param id
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新
     *
     * @param id
     * @param age
     * @param cupSize
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    @PutMapping(value = "/girlsUpate/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除女生
     *
     * @param id
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    @DeleteMapping(value = "/deleteGirl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 扩展按年龄查找，借口中方法名定义规范
     *
     * @param
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListFindByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/addtwo")
    public void girlAddTwo() {
        girlservice.insertTwo();
    }
}
