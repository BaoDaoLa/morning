package com.otg.morning.controller;

import com.otg.morning.dto.OrderDTO;
import com.otg.morning.enums.ResultEnum;
import com.otg.morning.exception.SellException;
import com.otg.morning.service.OrderService;
import com.otg.morning.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by OTG on 2018/11/05.
 */
@RestController
//@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/pay")
    public PayResponse index(@RequestParam("openid") String openid,
                              @RequestParam("orderId") String orderId,
                              @RequestParam("returnUrl") String returnUrl,
                              Map<String,Object> map){
        log.info("openid={}",openid);
        //1.查询订单
//        String orderId="1234563";
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId("123453245");
        orderDTO.setBuyerName("123");
        orderDTO.setOrderAmount(new BigDecimal("0.1"));
        //2.发起支付
        orderDTO.setBuyerOpenid(openid);
        PayResponse payResponse=payService.create(orderDTO);
        return payResponse;
    }

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){
        //1.查询订单
        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        PayResponse payResponse=payService.create(orderDTO);

        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);

        return new ModelAndView("pay/create",map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){

        log.info("notifyData:{}",notifyData);
        payService.notify(notifyData);

        //返回给微信处理结果
//        String string="";
        return new ModelAndView("pay/success");
    }

}
