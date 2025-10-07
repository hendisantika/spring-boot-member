package com.hendisantika.config;

import com.hendisantika.entity.Member;
import com.hendisantika.entity.Role;
import com.hendisantika.repository.MemberRepository;
import com.hendisantika.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-member
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/8/2025
 * Time: 6:30 AM
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        // Create ADMIN role if not exists
        Role adminRole = roleRepository.findById("ADMIN")
                .orElseGet(() -> {
                    Role role = new Role("ADMIN");
                    roleRepository.save(role);
                    log.info("Created ADMIN role");
                    return role;
                });

        // Create default admin user if not exists
        String adminEmail = "admin@example.com";
        if (memberRepository.findByEmail(adminEmail) == null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            List<Role> roles = new ArrayList<>();
            roles.add(adminRole);

            Member admin = new Member(
                    adminEmail,
                    "Admin",
                    "User",
                    encoder.encode("admin")
            );
            admin.setRole(roles);
            memberRepository.save(admin);

            log.info("======================================");
            log.info("Default admin user created:");
            log.info("Email: admin@example.com");
            log.info("Password: admin");
            log.info("======================================");
        }
    }
}
