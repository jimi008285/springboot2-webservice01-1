package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter                     // 모든필드 getter생성
@RequiredArgsConstructor    // 선언된 모든 final포함 필드에 생성자 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
