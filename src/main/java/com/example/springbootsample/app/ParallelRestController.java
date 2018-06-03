package com.example.springbootsample.app;


import com.example.springbootsample.domain.service.ParallelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class ParallelRestController {


    @Autowired
    ParallelService service;

    @GetMapping("/parallel")
    public int parallel(){
        System.out.println("controller start.");

        long startAll = System.currentTimeMillis();


        ExecutorService es = Executors.newWorkStealingPool();

        long start = System.currentTimeMillis();
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> service.parallel1(), es);
        long end = System.currentTimeMillis();
        System.out.println("f1:"  + (end - start)  + "ms");


        long start1 = System.currentTimeMillis();
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> service.parallel2(), es);
        long end1 = System.currentTimeMillis();
        System.out.println("f2:"  + (end1 - start1)  + "ms");

        int i = 0;
        try {
            i = f1.get() + f2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long endAll = System.currentTimeMillis();
        System.out.println("all:"  + (endAll - startAll)  + "ms");

        System.out.println("controller end.");
        return i;
    }

    @GetMapping("/series")
    public int series(){
        System.out.println("controller start.");
        long startAll = System.currentTimeMillis();

        long start = System.currentTimeMillis();
        int async1 = service.parallel1();
        long end = System.currentTimeMillis();
        System.out.println("f1:"  + (end - start)  + "ms");

        long start1 = System.currentTimeMillis();
        int async2 = service.parallel2();
        long end1 = System.currentTimeMillis();
        System.out.println("f2:"  + (end1 - start1)  + "ms");

        int i = async2 + async1;

        long endAll = System.currentTimeMillis();
        System.out.println("all:"  + (endAll - startAll)  + "ms");

        System.out.println("controller end.");
        return i;
    }

}
