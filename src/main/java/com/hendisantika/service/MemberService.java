package com.hendisantika.service;

import com.hendisantika.entity.Member;
import com.hendisantika.entity.Role;
import com.hendisantika.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Member createMember(Member member) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(memberRole);
        member.setRole(roles);
        memberRepository.save(member);
        return member;
    }
}
