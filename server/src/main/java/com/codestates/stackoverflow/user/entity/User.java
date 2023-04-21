package com.codestates.stackoverflow.user.entity;

import com.codestates.stackoverflow.user.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "유저")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User (Long userId, String name, String email, Role role){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User update(String name, String email){
        this.name = name;
        this.email = email;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
