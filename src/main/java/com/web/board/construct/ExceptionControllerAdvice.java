package com.web.board.construct;

import java.util.Arrays;
import java.util.Locale;


import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 예외처리 Advice
 *
 * @author sungmok.sohn
 * @version 1.0.0
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {


    /** 메시지 소스 */
    private final MessageSource messageSource;

    @ExceptionHandler({RestException.class})
    public ResponseEntity<Result<?>> handleRestException(RestException ex) {

        log.info("========== handleRestException(RestException ex) ==========");
        log.error("에러가 발생하였습니다. =============", ex);

        String args = null;
        if (ex.getArgs() != null) {
            args = Arrays.toString(Arrays.stream(ex.getArgs()).toArray(String[]::new));
        }

        log.debug("ex.getErrorType().name() ========== {}", ex.getErrorType().name());
        log.debug("ex.getMessage() ========== {}", ex.getErrorMsg());
        log.debug("ex.getArgs() ========== {}", args);
        log.debug("Locale.getDefault() ========== {}", Locale.getDefault());

        Result<?> result = Result.builder()
                .resultCd(ex.getErrorType().getCd())
                .resultMsg(ex.getErrorMsg())
                .build();

        log.info("result ========== {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}