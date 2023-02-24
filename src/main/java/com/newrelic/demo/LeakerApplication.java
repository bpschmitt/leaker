package com.newrelic.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LeakerApplication {

    private static List<byte[]> memoryLeakList = new ArrayList<>();
    private static final int HALFMEGABYTE = 1024 * 512;

    public static void main(String[] args) {
        SpringApplication.run(LeakerApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world! This is a fun message.";
    }

    @GetMapping("/leak")
    public String leak() {
//        int memoryUsed = 0;
        while (true) {
            memoryLeakList.add(new byte[HALFMEGABYTE]);
//            memoryUsed += HALFMEGABYTE;
//            if (memoryUsed >= (Runtime.getRuntime().maxMemory() * 0.9)) {
//                break;
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        return "Memory leak simulation complete.";
    }
}