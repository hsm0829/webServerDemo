package com.web.generator.controller;


import com.alibaba.fastjson.JSON;
import com.web.generator.dao.entity.Cost;
import com.web.generator.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hsm
 * @since 2019-01-08
 */
@Controller
@RequestMapping("/cost")
public class CostController {

    @Autowired
    private CostService costService;

    @RequestMapping(value = "/costListPage",method = RequestMethod.POST)
    @ResponseBody
    public String costMethodController(@RequestParam("size") int size,@RequestParam("current") int current){
        List<Cost> costList = costService.findCostPage(size, current, null);
        System.out.println("costList : "+ JSON.toJSONString(costList));
        return "costListPage";
    }
    @RequestMapping(value = "/saveCost",method = RequestMethod.POST)
    @ResponseBody
    public String saveCost(@RequestParam("money") int money){
        Cost cost=new Cost();
        cost.setMoney(money);
        boolean save = costService.saveCost(cost);
        return String.valueOf(save);
    }
    @RequestMapping(value = "/transactionSelect")
    @ResponseBody
    public List<Cost> transactionSelect(@RequestParam("money") int money){
        Cost cost=new Cost();
        cost.setMoney(money);
        return costService.selectList(cost);
    }
    @RequestMapping(value = "/transactionInsert")
    @ResponseBody
    public String transactionInsert(@RequestParam("flag") boolean flag,@RequestParam("money") int money){
        boolean res=false;
        try{
            Cost cost=new Cost();
            cost.setMoney(money);
            res= costService.transactionInsert(flag,cost);
        }catch(Exception e){
            e.printStackTrace();
        }
        return String.valueOf(res);
    }

}

