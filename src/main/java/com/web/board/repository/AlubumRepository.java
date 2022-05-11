package com.web.board.repository;

import com.web.board.entity.item.Alubum;
import com.web.board.entity.item.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlubumRepository extends JpaRepository<Alubum, Long> {
}
