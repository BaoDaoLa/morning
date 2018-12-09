package com.otg.morning.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SHNE on 2018/12/09.
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/check/url")
    public void checkUrl(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                         @RequestParam("signature") String signature,
                         @RequestParam("timestamp") String timestamp,
                         @RequestParam("nonce") String nonce,
                         @RequestParam("echostr") String echostr) throws IOException {
        log.info("进入checkUrl方法.......");
        if(!wxMpService.checkSignature(timestamp, nonce, signature)){
            log.info("非法请求，可能属于伪造的请求！");
        }else {
            httpServletResponse.getWriter().print(echostr);
        }
    }

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法.......");
        log.info("code={}",code);

        String url="https://api.weixin.qq.com/sns/oauth2/access_token?"
                +"appid=wxdcf91e9f784bfad0&secret=c467c06d98a2447f5ddef6ca8f47f268&code="+ code +"&grant_type=authorization_code";
        RestTemplate restTemplate=new RestTemplate();
        String response=restTemplate.getForObject(url,String.class);
        log.info("response={}",response);

    }

}
