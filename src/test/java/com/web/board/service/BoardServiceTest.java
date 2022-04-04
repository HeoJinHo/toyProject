package com.web.board.service;

import com.web.board.entity.LoungeBoard;
import com.web.board.mapper.BoardMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BoardServiceTest {


    @Test
    public void test(){

        List<String> list = Arrays.asList("sdasd", "asdasd", "asdasd");
        List<String> list2 = Arrays.asList("sdasd", "asdasd", "asdasd");


        System.out.println("Start1 : " + LocalDateTime.now().getSecond());
        String collect = list.stream().parallel().collect(Collectors.joining());
        System.out.println("End1 : " + LocalDateTime.now().getSecond());
        System.out.println("collect = " + collect);


        System.out.println("Start2 : " + LocalDateTime.now().getSecond());
        String collect1 = list2.stream().collect(Collectors.joining());
        System.out.println("End2 : " + LocalDateTime.now().getSecond());
        System.out.println("collect1 = " + collect1);

    }


    @Test
    @DisplayName("TDD TEST")
    public void tdd_test(){
        //given
        String test = "testTdd";

        //when
        assertThat("testTdd").isEqualTo(test);
        //then
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void connection_test(){
        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            System.out.println("커넥션 성공");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Autowired
    BoardMapper boardMapper;

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