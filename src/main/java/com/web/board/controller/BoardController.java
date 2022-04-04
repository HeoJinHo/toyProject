package com.web.board.controller;

import com.web.board.dto.BoardResultModel;
import com.web.board.dto.CommonResult;
import com.web.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;

    @GetMapping("/board")
    public String getBoard(Model model, @PageableDefault(size = 30, sort = "userNo", direction = Sort.Direction.DESC) Pageable pageable){

        model.addAttribute("list", boardService.getBoard(pageable).getContent());

        return "boardList";
    }


    
}
