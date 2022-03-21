package com.example.membercode.order;

import com.example.membercode.AppConfig;
import com.example.membercode.member.Grade;
import com.example.membercode.member.Member;
import com.example.membercode.member.MemberService;
import com.example.membercode.member.MemberServiceImpl;
import com.example.membercode.order.Order;
import com.example.membercode.order.OrderService;
import com.example.membercode.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderSericeTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    public void createOrder(){

        Long memberId = 1L;
        Member member = new Member(memberId, "mouou", Grade.VIP);
        memberService.join(member);
        Order orderitem = orderService.createOrder(memberId, "돼지귀", 10000);
        Assertions.assertThat(orderitem.getDiscountPrice()).isEqualTo(1000);
    }
}
