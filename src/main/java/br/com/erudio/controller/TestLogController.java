package br.com.erudio.controller;

import br.com.erudio.service.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController .class.getName());

    @GetMapping("/teste")
    public String testeLog() {
        logger.info("This is info logger");
        logger.warn("This is warning logger");
        logger.error("This is error logger");
        return "Log generated sucessfully!";
    }

}
