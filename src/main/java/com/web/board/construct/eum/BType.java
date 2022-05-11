package com.web.board.construct.eum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BType {


    ALUBUM("A", "앨범"),
    BOOK("B", "책"),
    MOVIE("M", "영화");


    private String value;

    private String name;


}
