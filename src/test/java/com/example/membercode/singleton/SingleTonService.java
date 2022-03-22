package com.example.membercode.singleton;

public class SingleTonService {

    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance(){
        return instance;
    }

    private SingleTonService(){}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호ddd출");    }
}
