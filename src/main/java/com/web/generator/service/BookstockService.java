package com.web.generator.service;

import com.web.generator.dao.entity.Bookstock;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
public interface BookstockService extends IService<Bookstock> {

    boolean updateBookStockNum(Integer num,Integer bookid);

}
