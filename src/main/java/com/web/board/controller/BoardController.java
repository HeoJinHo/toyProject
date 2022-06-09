package com.web.board.controller;

import com.web.board.dto.BoardForm;
import com.web.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;

    @GetMapping("/board")
    public String getBoard(Model model, @PageableDefault(size = 30, sort = "userNo", direction = Sort.Direction.DESC) Pageable pageable){

        model.addAttribute("list", boardService.getBoard(pageable).getContent());

        return "boardList";
    }

    @GetMapping("/form/board")
    public String formBoard() {

        return "pages/formBoard";
    }


    @PostMapping("/board/insert")
    public String insertBoard(BoardForm boardForm) {
        System.out.println("boardForm = " + boardForm.toString());
        boardService.insertBoard(boardForm);
        return "pages/formBoard";
    }

    
}
