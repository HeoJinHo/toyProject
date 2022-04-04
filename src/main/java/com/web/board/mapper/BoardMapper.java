package com.web.board.mapper;

import com.web.board.entity.LoungeBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<LoungeBoard> findById();

}
