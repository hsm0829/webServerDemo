package com.web.generator.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.web.generator.dao.entity.Cost;
import com.web.generator.dao.mapper.CostMapper;
import com.web.generator.service.CostService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hsm
 * @since 2019-01-08
 */
@Slf4j
@Service
public class CostServiceImpl extends ServiceImpl<CostMapper, Cost> implements CostService {
    @Autowired
    private CostMapper costMapper;

    @Override
    public List<Cost> findCostPage(int pageSize, int current, Cost cost) {
        log.info("findCostPage params : pageSize:{},current,cost:{}",pageSize,current, JSON.toJSONString(cost));
        EntityWrapper ew=null;
        if(cost!=null){
            ew=new EntityWrapper();//mybatis-plus 条件构造器
            ew.where("money={0}",cost.getMoney());
        }
        Page<Cost> page=new Page<>(current,pageSize);
        List<Cost> list = costMapper.selectPage(page, ew);
        return list;
    }

    @Override
    public boolean saveCost(Cost cost) {
        return costMapper.insert(cost)>0;
    }

    @Override
    public boolean transactionInsert (boolean flag,Cost cost) throws Exception {
        this.saveCost(cost);
        if(flag){
            throw new Exception("has exception!!!");
        }
        return true;
    }

    @Override
    public List<Cost> selectList(Cost cost) {
        EntityWrapper ew=new EntityWrapper();
        ew.where("money={0}",cost.getMoney());
        return costMapper.selectList(ew);
    }
}
