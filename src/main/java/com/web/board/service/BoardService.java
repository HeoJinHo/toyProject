package com.web.board.service;

import com.web.board.entity.LoungeBoard;
import com.web.board.repository.LoungeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final LoungeBoardRepository loungeBoardRepository;


    public Page<LoungeBoard> getBoard(Pageable pageable) {

        return loungeBoardRepository.findAll(pageable);
    }

}
