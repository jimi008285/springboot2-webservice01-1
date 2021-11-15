package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

// JUnit 연결자 역할
@RunWith(SpringRunner.class)
// spring mvc관련 어노테이션
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // spirngBean 주입
    @Autowired
    // webAPI 테스트 시작점(GET, POST API테스트)
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))              // MockMvc통한 GET요청
                .andExpect(status().isOk())                // header Status에 200, 400, 500 결과검증(OK = 200)
                .andExpect(content().string(hello));       // 응답본문검증(Controller의 Return값이 hello인지 검증)
    }
//    @Test
//    public void helloDto가_리턴된다() throws Exception{
//        String name = "hello";
//        int amount = 1000;
//
//        mvc.perform(get("/hello/dto")
//        .param("name", name)                         // key, value로 String값으로 변경
//        .param("amount", String.valueOf(amount)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is(name)))            // json응답값을 필드별로 검증하는 메서드
//                .andExpect(jsonPath("$.amount", is(amount)));       // $로 필드명을 명시 name을 $name으로 검증
//
//    }
}
