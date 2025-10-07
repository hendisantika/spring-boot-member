package com.hendisantika.controller;

import com.hendisantika.entity.Member;
import com.hendisantika.repository.MemberRepository;
import com.hendisantika.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginForm";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("member", new Member());
        return "registerForm";
    }

    @PostMapping("/register")
    public String registerMember(@Valid Member member, Model model) {
        String email = member.getEmail();
        if (memberRepository.findByEmail(email) != null) {
            model.addAttribute("exist", true);
            return "registerForm";
        }
        memberService.createMember(member);
        model.addAttribute("success", true);
        return "loginForm";
    }
}
