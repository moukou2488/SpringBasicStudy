package com.example.membercode.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented // 원래 어노테이션 클래스 위에 있는 것들 복붙하기
@Qualifier("mainDiscountPolicy") //붙이려했던 어노테이션 넣어주기
public @interface MainDiscountPolicy {
}
