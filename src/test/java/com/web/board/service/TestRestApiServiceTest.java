package com.web.board.service;

import com.web.board.entity.Category;
import com.web.board.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class TestRestApiServiceTest {


    @Autowired
    CategoryRepository categoryRepository;


    @Test
    @DisplayName("카테고리조회")
    @Transactional
    public void categorySearch(){
        //given
        Category category = categoryRepository.findById(38L).orElse(null);

        //when
        assert category != null;
        List<Category> child = category.getChild();
        Long id = 39L;
        for (Category category1 : child) {
            Assertions.assertThat(category1.getId()).isEqualTo(id);
            id ++;
        }


    }





}