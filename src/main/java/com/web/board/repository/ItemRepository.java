package com.web.board.repository;

import com.web.board.entity.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository<T extends Item> extends JpaRepository<T, Long>{
}
