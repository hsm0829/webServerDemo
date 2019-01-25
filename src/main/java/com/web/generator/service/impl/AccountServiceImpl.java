package com.web.generator.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.web.generator.dao.entity.Account;
import com.web.generator.dao.mapper.AccountMapper;
import com.web.generator.service.AccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    @Override
    public boolean updateAccountByTel(String telnum, Integer price) {
        Account account=this.accountByTelnum(telnum);
        account.setMoney(account.getMoney()-price);
        return accountMapper.updateById(account)>0;
    }

    @Override
    public Account accountByTelnum(String telnum) {
        Account account=new Account();
        account.setTelnum(telnum);
        return accountMapper.selectOne(account);
    }
}
