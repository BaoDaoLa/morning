package com.otg.morning.controller;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SHNE on 2018/12/09.
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @Autowired
    private WxMpService wxMpService;

    /**
     * 微信验证检查服务有效性
     * @param httpServletRequest
     * @param httpServletResponse
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @throws IOException
     */
    @GetMapping("/notify/mp/message")
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

    /**
     * 接收微信消息实现相应功能，点击事件，关注事件，等等
     * @param httpServletRequest
     * @param httpServletResponse
     * @param requestBody
     * @param signature
     * @param timestamp
     * @param nonce
     * @param encType
     * @param msgSignature
     * @throws IOException
     */
    @PostMapping("/notify/mp/message")
    public String messageHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                               @RequestBody(required = false) String requestBody,
                               @RequestParam("signature") String signature,
                               @RequestParam("timestamp") String timestamp,
                               @RequestParam("nonce") String nonce,
                               @RequestParam("encrypt_type") String encType,
                               @RequestParam("msg_signature") String msgSignature) throws IOException {
        log.info(
                "\n接收微信请求：[ signature=[{}], encType=[{}], msgSignature=[{}],"
                        + " timestamp=[{}], nonce=[{}]\n] ",
                 signature, encType, msgSignature, timestamp, nonce );
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            log.info("非法请求，可能属于伪造的请求！");
            return null;
        }
        String out = null;
        // aes加密的消息
        WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(requestBody,wxMpService.getWxMpConfigStorage(),timestamp,nonce,msgSignature);
        log.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
        // 全网发布测试用例
        if (StringUtils.equals(inMessage.getMsgType(), WxConsts.CUSTOM_MSG_TEXT)) {
            log.debug("\n进入回复消息处理=======================================：\n{} ", inMessage.toString());
            WxMpXmlOutMessage outMessage = WxMpXmlOutMessage.TEXT()
                    .content("content")
                    .fromUser(inMessage.getToUser())
                    .toUser(inMessage.getFromUser())
                    .build();
            out = outMessage.toXml();
            return out;
        }

    return null;
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
