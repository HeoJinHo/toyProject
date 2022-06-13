package com.web.board.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(locations="classpath:application.yml")
public class BoardServiceTest {
//
//
//    @Autowired
//    BoardMapper boardMapper;
//    @Autowired
//    Person person;
//    @Autowired
//    LoungeBoardRepository loungeBoardRepository;
//
//    @Autowired
//    JPAQueryFactory queryFactory;
//
//
//    @Test
//    public void contextLoads() {
//
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void setBoardData() {
//        System.out.println("mapperTest();");
//        for (int i = 0; i < 10; i++) {
//            LoungeBoard board = new LoungeBoard();
//            board.setUserNo(10L);
//            board.setTitle("test"+i);
//            board.setContent("content"+i);
//            loungeBoardRepository.save(board);
//            board.setBoardNo(null);
//        }
//    }
//
//
//
//    @Test
//    @DisplayName("MapperTest")
//    public void mapperTest(){
//        //given
//        //when
//
//        //then
//
//        queryFactory
//                .select(
//                    new CaseBuilder()
//                            .when(item.itemId.eq(1L))
//                            .then(item.itemId.count())
//                            .otherwise(0L).as("pointAmount")
//                )
//                .from(item)
//                .fetch();
//
//
//    }
//
//
//    @Test
//    @DisplayName("대소문자 구분 없이 체크")
//    public void checkString(){
//        //given
//        String keyword = "aNd";
//        String checkString = "AND";
//
//        //when
//        boolean b = checkString.equalsIgnoreCase(checkString);
//        Assertions.assertThat(b).isTrue();
//
//
//        //the
//
//    }
//


}