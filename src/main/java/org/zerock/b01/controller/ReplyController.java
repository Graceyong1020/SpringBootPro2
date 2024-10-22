package org.zerock.b01.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.b01.dto.ReplyDTO;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies") // /replies로 시작하는 모든 요청을 처리, get, post, put, delete 모두 처리
@Log4j2
public class ReplyController {

    @ApiOperation(value = "Replies POST", notes = "POST 방식 댓글 등록") // annotation을 사용하여 API 주석 추가
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(
            @Valid @RequestBody ReplyDTO replyDTO,
            BindingResult bindingResult) throws BindException {
        //@RequestBody: JSON 데이터를 객체로 변환

        log.info(replyDTO);

        if(bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", 111L);

        return resultMap;


    }
}
