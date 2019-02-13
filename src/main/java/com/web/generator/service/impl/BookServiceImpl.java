package com.web.generator.service.impl;

import com.web.generator.dao.entity.Account;
import com.web.generator.dao.entity.Book;
import com.web.generator.dao.mapper.BookMapper;
import com.web.generator.service.AccountService;
import com.web.generator.service.BookService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.web.generator.service.BookstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookstockService bookstockService;
    @Autowired
    private AccountService accountService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void buyBook(List<Integer> idList, String telnum) {
        for (Integer id:idList){
            accountService.buyBook(telnum,id);
        }
    }

}
