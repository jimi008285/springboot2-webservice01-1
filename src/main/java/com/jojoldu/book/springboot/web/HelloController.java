package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 반환하는 컨트롤러로 만듬. 예전 @ResponseBody역할
@RestController
public class HelloController {
    // HTTP GET요청을 받는 API. @RequestMapping역할. /hello 요청오면 hello문자열 반환기능
    @GetMapping("/hello/")
    public String hello(){
        return "hello";
    }
    // @RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    // 여기선 외부 name(@RequestParam("name"))으로 넘김 파라미터를 String name에 저정
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
