package com.codestates.stackoverflow.user.dto;


import com.codestates.stackoverflow.user.entity.User;
import lombok.Getter;

@Getter
public class UserDto {
    private Long userId;
    private String name;
    private String email;

    public UserDto(User user){
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public User getId(){
        return User.builder().userId(userId).build();
    }
}
