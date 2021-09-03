package com.hendisantika.controller;

import com.hendisantika.repository.MemberRepository;
import com.hendisantika.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-member
 * User: TOSHIBA
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/2021
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginForm";
    }

}
