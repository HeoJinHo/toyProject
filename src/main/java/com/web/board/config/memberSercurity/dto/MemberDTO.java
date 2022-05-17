package com.web.board.config.memberSercurity.dto;

import com.web.board.construct.eum.Role;
import com.web.board.entity.Member;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class MemberDTO  implements UserDetails {


    private Long id;

    private String username;

    private String userId;
    private String password;

    private Role role;


    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private Collection<? extends GrantedAuthority> authorities;



    public Member toEntity() {
        return new Member(userId, username, password, role);
    }

}
