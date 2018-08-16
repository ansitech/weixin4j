package com.ansitech.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.weixin4j.spring.WeixinTemplate;

/**
 * IndexController
 *
 * @author yangqisheng
 */
@Controller
public class IndexController {

    @Autowired
    private WeixinTemplate weixinTemplate;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap) {
        modelMap.put("appId", weixinTemplate.getWeixinConfig().getAppid());
        return new ModelAndView("index");
    }
}
