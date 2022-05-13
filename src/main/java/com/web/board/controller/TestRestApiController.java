package com.web.board.controller;

import com.web.board.component.S3Uploader;
import com.web.board.construct.Result;
import com.web.board.dto.BoardResultModel;
import com.web.board.dto.CommonResult;
import com.web.board.service.TestRestApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
public class TestRestApiController {

    private final TestRestApiService testRestApiService;

    private final S3Uploader s3Uploader;

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
