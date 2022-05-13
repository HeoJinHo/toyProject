package com.web.board.config.memberSercurity;

import com.web.board.config.memberSercurity.dto.MemberDTO;
import com.web.board.entity.Member;
import com.web.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberDao;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member memberEntity = memberDao.findByUserId(userId).orElse(null);

        System.out.println("로그인인가??");
        System.out.println("memberEntity.getUserId() = " + memberEntity.getUserId());
        System.out.println("memberEntity.getName() = " + memberEntity.getName());

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        System.out.println("authorities = " + authorities);

        return new User(memberEntity.getName(), memberEntity.getPassword(), authorities);
    }

    @Transactional
    @Override
    public Integer save(MemberDTO memberTO) {
        Member member = memberTO.toEntity();

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberDao.save(member).getId().intValue();
    }

}
