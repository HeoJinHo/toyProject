package com.web.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.board.construct.ErrorType;
import com.web.board.construct.RestException;
import com.web.board.entity.Category;
import com.web.board.entity.Member;
import com.web.board.entity.item.Alubum;
import com.web.board.repository.CategoryRepository;
import com.web.board.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;
import java.util.List;

import static com.web.board.entity.QMember.member;
import static com.web.board.entity.item.QItem.item;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestPropertySource(locations="classpath:application.yml")
public class CommonTest {


    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    JPAQueryFactory queryFactory;


    @Test
    @Transactional
    public void contextLoads() throws Throwable {


        Long itemId = 4L;

        Alubum alubum = (Alubum) itemRepository.findById(itemId).orElseThrow(() -> new RestException(ErrorType.REST_TEST));


        List<Category> categories = alubum.getCategories();
        System.out.println("categories = " + categories);

        assertThat(alubum.getId()).isEqualTo(itemId);


    }


    @Test
    @DisplayName("ItemSearch")
    public void getItemList(){
        //given
        queryFactory
                .selectFrom(item)
                .fetch();

        //when

        //the

    }



    @Test
    @DisplayName("QueryDSL TEST")
    public void queryDslTest(){
        //given
        String userId = "hjh701234";

        //when
        Member member1 = queryFactory.selectFrom(member)
                .where(
                        member.userId.eq(userId)
                )
                .fetchOne();

        //then
        assertThat(member1.getUserId()) .isEqualTo(userId);

    }


    @Test
    @DisplayName("카테고리넣기")
    @Rollback(value = false)
    @Transactional
    public void saveCategory(){
        //given
        int cnt = 10;

        //when
        for (int i = 0; i < cnt; i++) {
            Category category = new Category();
            category.setId(null);
            category.setName("카테고리"+i);
            categoryRepository.save(category);

        }

        //the

    }


}