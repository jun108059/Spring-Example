package com.youngjun.jpa.web;

import com.youngjun.jpa.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 외부 API 에서 넘긴 파라미터로 Hello Dto 생성
     *
     * @param name   이름
     * @param amount 잔액
     * @return HelloResponseDto 객체
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
