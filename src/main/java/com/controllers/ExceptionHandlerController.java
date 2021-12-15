//package com.controllers;
//
//
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//@ControllerAdvice
//public class ExceptionHandlerController {
//
//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(value= HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ModelAndView requestHandlingNoHandlerFound(ModelAndView model) {
//    	System.out.println("Invalid URL");
//    	model.setViewName("404");
//        return model;
//        
//    }
//}