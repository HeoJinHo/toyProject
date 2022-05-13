package com.web.board.config.memberSercurity;

import com.web.board.config.memberSercurity.dto.MemberDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    Integer save(MemberDTO memberDTO);
}
