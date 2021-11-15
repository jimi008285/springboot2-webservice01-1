package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing          // JPA Auditing 활성화
@SpringBootApplication      // springboot의 자동설정, springBean read, create 자동 설정
public class Application {
    public static void main(String[] args){
        // 내장WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
