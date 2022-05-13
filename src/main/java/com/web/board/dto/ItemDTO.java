package com.web.board.dto;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ItemDTO {

    String dType;

    private Long id;

    private String name;
    private String imageUrl;

    private int price;

    private int stockQuantity;

}
