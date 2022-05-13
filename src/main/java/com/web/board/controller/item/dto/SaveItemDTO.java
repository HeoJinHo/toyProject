package com.web.board.controller.item.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class SaveItemDTO {

    /*BOOK*/
    private String author;
    private String isbn;


    /*MOVIE*/
    private String director;
    private String actor;


    /*ALUBUM*/
    private String artist;
    private String etc;

    private String bType;


    private String name;

    private int price;

    private int stockQuantity;

    private String imageUrl;


}
