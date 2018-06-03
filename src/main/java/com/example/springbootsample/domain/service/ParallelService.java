package com.example.springbootsample.domain.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ParallelService {

    public int parallel1(){
        System.out.println("service start.");
        try {
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {}
        System.out.println("service end.");
        return 1;
    }

    public int parallel2(){
        System.out.println("service start.");
        try {
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {}
        System.out.println("service end.");
        return 2;
    }
}
