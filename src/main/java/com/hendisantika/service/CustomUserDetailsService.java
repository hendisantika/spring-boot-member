package com.hendisantika.service;

import com.hendisantika.entity.Member;
import com.hendisantika.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-member
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/8/2025
 * Time: 6:30 AM
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .authorities(member.getRole().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                        .collect(Collectors.toList()))
                .build();
    }
}
