package com.xinghj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.8:45
 * @description spring boot测试程序
 * RestController spring4之后新增的注解，原来返回json的话需要@RequestBody和@Controller配合使用
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private int age;
    @Value("${content}")
    private String content;
    @Autowired
    private DemoProperties demoProperties;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String sayHi() {
        //return "Hello,Spring Boot " + "cupSize: " + cupSize + " the girl's age is" + age;
        return content;
    }

    @RequestMapping(value = "/describeAgirl", method = RequestMethod.GET)
    public String describeAgirl() {

        return demoProperties.getName();
    }

    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    public String testSay(@PathVariable("id") Integer id) {
        return "id: " + id;
    }

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String testRequestParam(@RequestParam("id") Integer myid) {
        return "id equals " + myid;
    }

    @RequestMapping(value = "/sayId", method = RequestMethod.GET)
    public String testDefaultValue(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid) {
        return "id is " + myid;
    }


}
