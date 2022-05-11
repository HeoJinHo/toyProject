package com.web.board.service;

import com.web.board.construct.Person;
import com.web.board.entity.LoungeBoard;
import com.web.board.mapper.BoardMapper;
import com.web.board.repository.LoungeBoardRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestPropertySource(locations="classpath:application.yml")
public class BoardServiceTest {


    @Autowired
    BoardMapper boardMapper;
    @Autowired
    Person person;
    @Autowired
    LoungeBoardRepository loungeBoardRepository;


    @Test
    public void contextLoads() {

    }

    @Test
    @Rollback(value = false)
    public void setBoardData() {
        System.out.println("mapperTest();");
        for (int i = 0; i < 10; i++) {
            LoungeBoard board = new LoungeBoard();
            board.setUserNo(10L);
            board.setTitle("test"+i);
            board.setContent("content"+i);
            loungeBoardRepository.save(board);
            board.setBoardNo(null);
        }
    }



    @Test
    @DisplayName("MapperTest")
    public void mapperTest(){
        //given
        List<LoungeBoard> byId = boardMapper.findById();
        for (LoungeBoard loungeBoard : byId) {
            System.out.println("loungeBoard = " + loungeBoard);
        }
        //when

        //then
    }



}