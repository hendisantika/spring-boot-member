package com.hendisantika.service;

import com.hendisantika.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-member
 * User: TOSHIBA
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/2021
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

}
