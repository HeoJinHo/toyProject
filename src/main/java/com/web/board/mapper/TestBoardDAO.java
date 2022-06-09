package com.web.board.mapper;

import com.web.board.dto.BoardForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestBoardDAO {

    void insertBoard(BoardForm boardForm);

}
