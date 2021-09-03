package com.hendisantika.controller;

import com.hendisantika.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
public class IndexController {

    @Autowired
    MemberRepository memberRepository;
}
