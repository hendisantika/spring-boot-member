package com.hendisantika.controller;

import com.hendisantika.entity.Member;
import com.hendisantika.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-member
 * User: TOSHIBA
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/2021
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String showIndex(Model model, Principal principal) {
        if (principal == null) {
            return "loginForm";
        }
        Member member = memberRepository.findByEmail(principal.getName());
        model.addAttribute("message", "Hello everyone, we are go to back to Spring with together");
        model.addAttribute("date", new Date());
        model.addAttribute("members", member);
        return "index";
    }
}
