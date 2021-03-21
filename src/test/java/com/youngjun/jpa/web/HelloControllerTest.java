package com.youngjun.jpa.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello_리턴하기() throws Exception {
        String hello = "hello";

        // MockMvc 를 통해 /hello 주소로 HTTP GET 요청을 함
        mockMvc.perform(get("/hello")) // perform : 요청 후 결과 검증
                .andExpect(status().isOk()) // Status(200, 404, etc 검사)
                .andExpect(content().string(hello)); // 응답 내용은 검증
    }

}