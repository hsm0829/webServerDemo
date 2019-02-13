package com.web.generator.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.web.generator.dao.entity.Bookstock;
import com.web.generator.dao.mapper.BookstockMapper;
import com.web.generator.service.BookstockService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
@Service
public class BookstockServiceImpl extends ServiceImpl<BookstockMapper, Bookstock> implements BookstockService {
    @Autowired
    private BookstockMapper bookstockMapper;

    @Override
    public boolean updateBookStockNum(Integer num, Integer bookid) {
        Bookstock bookstock=new Bookstock();
        bookstock.setBookid(bookid);
        bookstock = bookstockMapper.selectOne(bookstock);
        bookstock.setNum(bookstock.getNum()-num);
        return bookstockMapper.updateById(bookstock)>0;
    }
}
