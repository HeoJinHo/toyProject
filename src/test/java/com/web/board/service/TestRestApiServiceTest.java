package com.web.board.service;

import com.web.board.entity.Category;
import com.web.board.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Arrays;
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


    @Test
    @Rollback(value = false)
    @DisplayName("카테고리 등록")
    public void categorySave(){
        //given
        Category category01 = new Category();
        category01.setName("test01");
        Category save01 = categoryRepository.save(category01);

        Category category02 = new Category();
        category02.setName("test02");
        category02.setParent(save01);
        Category category03 = new Category();
        category03.setName("test03");
        category03.setParent(save01);


        Category save02 = categoryRepository.save(category02);
        Category save03 = categoryRepository.save(category03);




        category01.setChild(Arrays.asList(save02, save03));



        //when

        //the

    }


}