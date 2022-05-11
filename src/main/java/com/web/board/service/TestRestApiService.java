package com.web.board.service;

import com.web.board.entity.Address;
import com.web.board.entity.Member;
import com.web.board.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestRestApiService {

    private final MemberRepository memberRepository;

    @Transactional
    public void setAddress(Map<String, Object> params) {
        log.info("============== setAddress ==============");
        log.debug("params  : ", params);


        Member member = new Member();

        member.setName((String)params.get("name"));
        member.setAddress(new Address((String)params.get("city"), (String)params.get("street"), (String)params.get("zipcode")));


        log.debug("member  : ", member);

        memberRepository.save(member);



    }



}
