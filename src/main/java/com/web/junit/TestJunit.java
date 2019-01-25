package com.web.junit;


import com.web.generator.dao.entity.Account;
import com.web.generator.dao.entity.Book;
import com.web.generator.dao.entity.Cost;
import com.web.generator.service.AccountService;
import com.web.generator.service.BookService;
import com.web.generator.service.CostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath*:spring.xml","classpath*:spring-mvc.xml"})
public class TestJunit {

    @Autowired
    private CostService costService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BookService bookService;

    @Test
    public void testTransaction() {
        Cost cost=new Cost();
        cost.setMoney(4);
        costService.transactionInsert(true,cost);
    }
    @Test
    public void addAccount(){
        Account account=new Account();
        account.setMoney(10000);
        account.setTelnum("15868454211");
        accountService.insert(account);
    }
    @Test
    public void buyBook(){
        List<Integer> idList=new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        bookService.buyBook(idList,"15868454211");
    }

}
