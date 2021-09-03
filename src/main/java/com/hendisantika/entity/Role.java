package com.hendisantika.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-member
 * User: TOSHIBA
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/2021
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Data
@NoArgsConstructor
public class Role {

    @Id
    private String name;

    @ManyToMany(mappedBy = "role")
    private List<Member> members;

    public Role(String name) {
        this.name = name;
    }

}
