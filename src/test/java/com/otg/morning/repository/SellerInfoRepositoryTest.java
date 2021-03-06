//package com.otg.morning.repository;
//
//import com.otg.morning.entity.SellerInfo;
//import com.otg.morning.utils.KeyUtil;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * Created by OTG on 2018/11/31.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SellerInfoRepositoryTest {
//
//    @Autowired
//    private SellerInfoRepository repository;
//
//    @Test
//    public void save(){
//        SellerInfo sellerInfo=new SellerInfo();
//        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
//        sellerInfo.setUsername("admin");
//        sellerInfo.setPassword("admin");
//        sellerInfo.setOpenid("abc");
//
//        SellerInfo result=repository.save(sellerInfo);
//        Assert.assertNotNull(result);
//    }
//
//    @Test
//    public void findByOpenid() throws Exception{
//        SellerInfo result=repository.findByOpenid("abc");
//        Assert.assertEquals("abc",result.getOpenid());
//
//    }
//}