package com.web.board.dto;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ItemDTO {


    private Long itemId;

    private String itemName;

    private int itemPrice;

    private int itemStockCnt;

}
