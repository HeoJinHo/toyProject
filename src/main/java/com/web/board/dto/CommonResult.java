package com.web.board.dto;

import lombok.Builder;

@Builder
public class CommonResult<T> {

    private String resultCd;

    private T result;
}
