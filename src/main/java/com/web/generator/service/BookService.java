package com.web.generator.service;

import com.web.generator.dao.entity.Book;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
public interface BookService extends IService<Book> {

    void buyBook(List<Integer> idList, String telnum);
}
