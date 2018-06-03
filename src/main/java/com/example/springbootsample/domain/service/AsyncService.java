package com.example.springbootsample.domain.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    public void sync(){
        System.out.println("service start.");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {}
        System.out.println("service end.");
    }

    @Async
    public int async(){
        System.out.println("service start.");
        try {
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {}
        System.out.println("service end.");
        return 1;
    }
}
