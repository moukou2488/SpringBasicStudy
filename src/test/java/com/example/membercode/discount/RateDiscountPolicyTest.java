package com.example.membercode.discount;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("vip는 10% 할인 되야함")
    void vip_o(){
        Member member = new Member(1L,"kouou", Grade.VIP);
        int discount = discountPolicy.discount(member, 20000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("basic은 10% 할인 안되야함")
    void vip_x(){
        Member member = new Member(1L,"mouou", Grade.BASIC);
        int discount = discountPolicy.discount(member, 20000);
        assertThat(discount).isEqualTo(2000);
    }
}