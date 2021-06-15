package com.banghyunwoo.springbootservice.web;

import com.banghyunwoo.springbootservice.web.dto.HelloResponseDto;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto hello(@RequestParam("name") String name,
                                  @RequestParam("amount") int amount){

        return new HelloResponseDto(name, amount);
    }

    @GetMapping("/travis")
    public String travisTest() {
        return "test";
    }

    @CrossOrigin("*") // CORS 애노테이션
    @GetMapping("/cookie")
    public String cookieTest(@CookieValue(value="cookie", required = false) Cookie reqCookie, HttpServletResponse response){
        System.out.println("+111");
        Cookie cookie = new Cookie("cookie","cookietest");
        cookie.setMaxAge(0);
        cookie.setPath("/");

        System.out.println("reqCookie ===" + reqCookie);

        response.addCookie(cookie);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "*");

        return "test";
    }

    @CrossOrigin("*") // CORS 애노테이션
    @GetMapping("/cookie2")
    public JSONObject cookieTest2(@CookieValue(value="cookie", required = false) Cookie reqCookie, HttpServletResponse response){
        JSONObject json = new JSONObject();
        System.out.println("+cookieTest222");
        System.out.println("reqCookie ===" + reqCookie);

        json.put("key", "value");

        return json;
    }
}
