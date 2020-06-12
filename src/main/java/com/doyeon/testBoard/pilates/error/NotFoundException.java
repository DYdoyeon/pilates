package com.doyeon.testBoard.pilates.error;

import com.doyeon.testBoard.pilates.controller.boardController;
import com.doyeon.testBoard.pilates.domain.result.ObjectResult;
import com.doyeon.testBoard.pilates.domain.result.ResultPrint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class NotFoundException implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping("/error")
    public @ResponseBody
    Map<String,String> handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));
        log.info("httpStatus : "+httpStatus.toString());

        Map <String,String> map = new HashMap<String,String>();

        map.put("code", status.toString());
        map.put("msg", httpStatus.getReasonPhrase());


        return map;
    }

}


