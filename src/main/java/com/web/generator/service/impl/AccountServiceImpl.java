package com.web.generator.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.web.generator.dao.entity.Account;
import com.web.generator.dao.entity.Book;
import com.web.generator.dao.mapper.AccountMapper;
import com.web.generator.dao.mapper.BookMapper;
import com.web.generator.service.AccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.web.generator.service.BookstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookstockService bookstockService;

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

    /**
     * 1、propagation
     * 2、isolation：指定事物的隔离级别，最常用的是READ_COMMITTED（读已提交）
     * 3、默认情况下，spring的声明式事物只对所有的运行时异常进行回滚。也可以通过对应的属性进行设置.通常情况下，默认值即可。
     * 4、使用readonly指定事物是否只读。表示这个事物只读取数据但不更新数据，
     * 这样可以帮助数据库引擎优化事物。若真的是一个只读取数据库值的方法，应设置readonly=true
     * 5、timeout 指定强制回滚之前事物可以占用的时间，若事物超时，则强制回滚。节省链接占用时间
     * @param telnum
     * @param id
     */
//    @Transactional(propagation = Propagation.REQUIRES_NEW , isolation = Isolation.READ_COMMITTED,noRollbackFor = {RuntimeException.class})
    @Transactional(propagation = Propagation.REQUIRES_NEW , isolation = Isolation.READ_COMMITTED,readOnly = false,timeout = 3)
    @Override
    public void buyBook(String telnum,Integer id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        Account account = this.accountByTelnum(telnum);
        Book book = bookMapper.selectById(id);
        //扣除账户余额
        boolean accountByTel = this.updateAccountByTel(telnum, book.getPrice().intValue());
        System.out.println("accountByTel : "+accountByTel);
        //扣除书本库存
        boolean stockNum = bookstockService.updateBookStockNum(1, book.getId());
        System.out.println("stockNum : "+stockNum);
        if (account.getMoney()<book.getPrice().intValue()){
            throw new RuntimeException("buyBook : 余额不足");
        }
    }
}
