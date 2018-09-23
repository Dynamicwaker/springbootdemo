package com.xinghj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.9:51
 * @description
 */
@Controller
public class TestController {
    @Autowired
    private DemoProperties demoProperties;
    @RequestMapping(value = "/describe", method = RequestMethod.GET)
    public String describe() {
//        return demoProperties.getName();
        return "index";
    }
}
