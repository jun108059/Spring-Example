package com.youngjun.jpa.web;

import com.youngjun.jpa.web.dto.HelloResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello controller", description = "Hello controller desc")
public class HelloController {

    @Operation(summary = "Test Hello Method", description = "Hello method description", tags = { "contact" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class)))) })
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
    public HelloResponseDto helloDto(@Parameter(description = "DTO Name") @RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
