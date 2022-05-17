package com.web.board.controller.item.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class SaveItemDTO {

    private Long itemId;

    private String itemName;

    private String itemContent;

    private int itemPrice;

    private int itemStockCnt;

    private int itemSalePercentage;

    private int itemPointPrice;

    private Long categoryId;



}
