package com.web.board.repository;

import com.web.board.entity.LoungeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoungeBoardRepository extends JpaRepository<LoungeBoard, Long> {

    Page<LoungeBoard> findAll(Pageable pageable);

}
