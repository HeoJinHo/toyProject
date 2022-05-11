package com.web.board.dto;

import com.web.board.construct.eum.Role;
import com.web.board.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDTO {


    private Long id;

    private String name;

    private String userId;
    private String password;

    private Role role;


    public Member toEntity() {
        return new Member(userId, name, password, role);
    }
}
