package com.web.generator.service;

import com.web.generator.dao.entity.Account;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
public interface AccountService extends IService<Account> {

    boolean updateAccountByTel(String telnum,Integer price);

    Account accountByTelnum(String telnum);

}
