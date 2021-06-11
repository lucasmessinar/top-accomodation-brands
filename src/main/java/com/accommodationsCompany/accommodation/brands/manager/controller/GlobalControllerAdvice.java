package com.accommodationsCompany.accommodation.brands.manager.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

  private static Logger LOGGER = LoggerFactory.getLogger(GlobalControllerAdvice.class);

  @ExceptionHandler(Exception.class)
  public ResponseEntity handleException(HttpServletRequest request,
      Exception exception) {
    LOGGER.error("Unexpected error in " + request.getRequestURI(), exception);
    return new ResponseEntity("Our best engineers are working to solve your problem",
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
