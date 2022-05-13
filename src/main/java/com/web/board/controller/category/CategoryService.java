package com.web.board.controller.category;

import com.web.board.controller.category.dto.CategoryDTO;
import com.web.board.entity.Category;
import com.web.board.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;


    public void getCategoryList(Model model, Pageable pageable) {
        Page<Category> categoryList = categoryRepository.findAll(pageable);

        log.debug("categoryList : {} ", categoryList.getContent());
        model.addAttribute("list", modelMapper.map(categoryList.getContent(), new TypeToken<List<CategoryDTO>>() {}.getType()));
        model.addAttribute("page", categoryList.getTotalPages());
    }

}
