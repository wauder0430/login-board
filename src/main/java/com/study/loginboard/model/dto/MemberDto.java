package com.study.loginboard.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDto {
    private long memberSeq;
    private String name;
    private String id;
    private String password;
    private String jumin;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    private String role;        // 권한
    private LocalDateTime joinDate;
    private LocalDateTime updateDate;
    private String delYn;
}
