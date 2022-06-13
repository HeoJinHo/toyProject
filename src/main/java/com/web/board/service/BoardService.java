package com.web.board.service;

import com.web.board.dto.BoardForm;
import com.web.board.entity.LoungeBoard;
import com.web.board.mapper.TestBoardDAO;
import com.web.board.repository.LoungeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final LoungeBoardRepository loungeBoardRepository;

    private final TestBoardDAO testBoardDAO;

    /**
     * 게시글 조회 페이징
     * @param pageable : 페이징 객체
     * @return : 페이징 결과
     */
    public Page<LoungeBoard> getBoard(Pageable pageable) {

        return loungeBoardRepository.findAll(pageable);
    }

    /**
     * 게시글 등록
     * @param boardForm : 등록 폼 객체
     */
    @Transactional
    public void insertBoard(BoardForm boardForm) {
        testBoardDAO.insertBoard(boardForm);
    }

}
