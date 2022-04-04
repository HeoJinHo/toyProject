package com.web.board.construct;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  ErrorType {
    
    REST_TEST("E0001", "RestApi오류입니다.");
    
    private String cd;
    private String msg;

}
