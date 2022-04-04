package com.web.board.construct;

/*
 * Result.java
 * v1.0.0
 * 2018. 1. 1.
 * Copyright (c) 2018 RouteLab Co. All rights Reserved.
 */

import java.io.Serializable;

import lombok.*;


/**
 * 응답결과.
 *
 * @author ssm@hsociety.co.kr
 * @version 1.0.0
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 2252549863897641644L;

    /** 결과코드 */
    @Builder.Default
    private String resultCd = "0000";

    /** 결과메시지 */
    @Builder.Default
    private String resultMsg = "성공";

    /** 결과 */
    private T result;

    public static Result<String> success(){
        return Result.<String>builder()
                .build();
    }

    public static Result<String> failure(){
        return Result.<String>builder()
                .resultCd("9999")
                .build();
    }

    public static Result<String> success(String message){
        return Result.<String>builder()
                .result(message)
                .build();
    }



}