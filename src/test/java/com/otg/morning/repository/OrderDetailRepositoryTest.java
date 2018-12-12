//package com.otg.morning.repository;
//
//import com.otg.morning.entity.OrderDetail;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.math.BigDecimal;
//import java.util.List;
//
///**
// * Created by OTG on 2018/11/18.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class OrderDetailRepositoryTest {
//
//    @Autowired
//    private OrderDetailRepository repository;
////
////    @Resource
////    private OrderDetailMapper orderDetailMapper;
//
//    @Test
//    public void saveTest(){
//        OrderDetail orderDetail=new OrderDetail();
//        orderDetail.setDetailId("1234567810");
//        orderDetail.setOrderId("111111111");
//        orderDetail.setProductIcon("http://xxx.jpg");
//        orderDetail.setProductId("111112");
//        orderDetail.setProductName("皮蛋粥");
//        orderDetail.setProductPrice(new BigDecimal(2.2));
//        orderDetail.setProductQuantity(3);
////        int result= orderDetailMapper.insert(orderDetail);
//        OrderDetail result=repository.save(orderDetail);
//        Assert.assertNotNull("1",result);
//
//    }
//    @Test
//    public void findByOrderId() {
//        List<OrderDetail> orderDetailList=repository.findByOrderId("111111111");
//        Assert.assertNotEquals(0,orderDetailList.size());
//
//    }
//}