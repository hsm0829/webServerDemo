package com.web.generator.controller;


import com.web.generator.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
@Controller
@RequestMapping("/bookstock")
public class BookstockController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/buyBook")
    @ResponseBody
    public String buyBook(){
        List<Integer> idList=new ArrayList<>();
        idList.add(1);
        bookService.buyBook(idList,"15868454211");
        return "buyBook success";
    }

}

