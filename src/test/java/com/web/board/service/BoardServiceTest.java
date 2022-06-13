package com.web.board.service;

import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.board.config.ParameterStoreProperties;
import com.web.board.construct.Person;
import com.web.board.entity.LoungeBoard;
import com.web.board.mapper.BoardMapper;
import com.web.board.repository.LoungeBoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import static com.web.board.entity.item.QItem.item;


@SpringBootTest
@TestPropertySource(locations="classpath:application.yml")
public class BoardServiceTest {


    @Autowired
    BoardMapper boardMapper;
    @Autowired
    Person person;
    @Autowired
    LoungeBoardRepository loungeBoardRepository;

    @Autowired
    JPAQueryFactory queryFactory;


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
        //when

        //then

        queryFactory
                .select(
                    new CaseBuilder()
                            .when(item.itemId.eq(1L))
                            .then(item.itemId.count())
                            .otherwise(0L).as("pointAmount")
                )
                .from(item)
                .fetch();


    }


    @Test
    @DisplayName("대소문자 구분 없이 체크")
    public void checkString(){
        //given
        String keyword = "aNd";
        String checkString = "AND";

        //when
        boolean b = checkString.equalsIgnoreCase(checkString);
        Assertions.assertThat(b).isTrue();


        //the

    }

    @Autowired
    private ParameterStoreProperties properties;

    @Test
    @DisplayName("파리머터 스토어 테스트")
    public void parameter_store_test(){
        //given


        //when

        //then
        Assertions.assertThat(properties.getEncryptKey()).isEqualTo("testtest");
    }


}