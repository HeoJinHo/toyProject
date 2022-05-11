package com.web.board.controller;

import com.web.board.construct.ErrorType;
import com.web.board.construct.RestException;
import com.web.board.construct.Result;
import com.web.board.dto.BoardResultModel;
import com.web.board.dto.CommonResult;
import com.web.board.service.TestRestApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
public class TestRestApiController {

    private final TestRestApiService testRestApiService;


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

    @PostMapping("/address")
    public void memberAddressSettion(@RequestBody Map<String, Object> params) {
        log.info("================= /address =================");
        log.debug("params  : ", params);
        testRestApiService.setAddress(params);

    }


}
