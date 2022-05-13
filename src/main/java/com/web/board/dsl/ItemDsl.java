package com.web.board.dsl;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.board.dto.ItemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.web.board.entity.item.QItem.item;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ItemDsl {

    private final JPAQueryFactory queryFactory;


    public Page<ItemDTO> getItemList(Pageable pageable) {


        QueryResults<ItemDTO> paging = queryFactory.select(
                        Projections.fields(
                                ItemDTO.class,
                                item.id,
                                item.name,
                                item.price,
                                item.stockQuantity
                        )
                )
                .from(item)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(item.id.desc())
                .fetchResults();

        List<ItemDTO> content = paging.getResults();
        long total = paging.getTotal();
        return new PageImpl<>(content, pageable, total);

    }

}
