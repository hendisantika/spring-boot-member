package com.hendisantika.repository;

import com.hendisantika.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-member
 * User: TOSHIBA
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/2021
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
