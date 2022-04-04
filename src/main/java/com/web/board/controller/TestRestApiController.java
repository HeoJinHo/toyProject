package com.web.board.controller;

import com.web.board.construct.ErrorType;
import com.web.board.construct.RestException;
import com.web.board.construct.Result;
import com.web.board.dto.BoardResultModel;
import com.web.board.dto.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestApiController {


    @GetMapping("/restGet")
    public CommonResult<?> commonResult() {
        BoardResultModel model = new BoardResultModel();

        model.setMsg("asdasd");
        return CommonResult.<BoardResultModel>builder().result(model).build();
    }

    @GetMapping("/getAPI")
    public Result<?> test() {
        BoardResultModel model = new BoardResultModel();
        model.setMsg("asdas5d");

        return Result.<BoardResultModel>builder().result(model).build();
    }


    public void tsss(String asdas, Long awsd) {

    }
}
