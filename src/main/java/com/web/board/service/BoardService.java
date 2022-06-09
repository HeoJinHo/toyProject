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

    public Page<LoungeBoard> getBoard(Pageable pageable) {

        return loungeBoardRepository.findAll(pageable);
    }

    @Transactional
    public void insertBoard(BoardForm boardForm) {
        testBoardDAO.insertBoard(boardForm);
    }

}
