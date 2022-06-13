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

    /**
     * 게시글 조회 리스트
     * @param model : 모델
     * @param pageable : 페이징 객체
     * @return 페이지
     */
    @GetMapping("/board")
    public String getBoard(Model model, @PageableDefault(size = 30, sort = "userNo", direction = Sort.Direction.DESC) Pageable pageable){

        model.addAttribute("list", boardService.getBoard(pageable).getContent());

        return "boardList";
    }

    /**
     * 게시글 등록 화면
     * @return : 페이지
     */
    @GetMapping("/form/board")
    public String formBoard() {

        return "pages/formBoard";
    }


    /**
     * 게시글 등록
     * @param boardForm : 게시글 등록 객체
     * @return : 등록 후 페이지
     */
    @PostMapping("/board/insert")
    public String insertBoard(BoardForm boardForm) {
        boardService.insertBoard(boardForm);
        return "pages/formBoard";
    }

    
}
