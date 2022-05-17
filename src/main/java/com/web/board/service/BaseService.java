package com.web.board.service;

import com.web.board.config.memberSercurity.dto.MemberDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    public Long getMemberNo() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MemberDTO userDetails = (MemberDTO)principal;
        return userDetails.getId();
    }

}
