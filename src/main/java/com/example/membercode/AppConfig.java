package com.example.membercode;

import com.example.membercode.discount.DiscountPolicy;
import com.example.membercode.discount.FixDiscountPolicy;
import com.example.membercode.discount.RateDiscountPolicy;
import com.example.membercode.member.MemberRepository;
import com.example.membercode.member.MemberServiceImpl;
import com.example.membercode.member.MemoryMemberRepository;
import com.example.membercode.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberServiceImpl memberService(){
        return new MemberServiceImpl(memoryRepository());
    }

    @Bean
    public MemberRepository memoryRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderServiceImpl orderService(){
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
