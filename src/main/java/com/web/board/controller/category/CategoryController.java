package com.web.board.controller.category;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_USER')")
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/lists")
    public String getCategoryList(Model model, Pageable pageable) {

        categoryService.getCategoryList(model, pageable);
        return "/pages/categoryList";
    }

}
