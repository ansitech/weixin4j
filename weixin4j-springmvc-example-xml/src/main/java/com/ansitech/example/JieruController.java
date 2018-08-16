package com.ansitech.example;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weixin4j.spring.web.WeixinJieruController;

/**
 * 微信接入
 *
 * @author yangqisheng
 */
@Controller
@RequestMapping("/weixin/jieru")
public class JieruController extends WeixinJieruController {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.get(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.post(request, response);
    }
}
