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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
//        log.info("findCostPage params : pageSize:{},current,cost:{}",pageSize,current, JSON.toJSONString(cost));
        EntityWrapper ew=null;
        if(cost!=null){
            ew=new EntityWrapper();//mybatis-plus 条件构造器
            ew.where("money={0}",cost.getMoney());
        }
        Page<Cost> page=new Page<>(current,pageSize);
        List<Cost> list = costMapper.selectPage(page, ew);
        return list;
    }

    @Transactional
    @Override
    public boolean saveCost(Cost cost) {
        return costMapper.insert(cost)>0;
    }

    /**
     * 事物传播行为：
     *  Propagation.REQUIRED ： 支持当前事物，如果不存在，就新建一个
     *  Propagation.SUPPORTS ： 支持当前事物，如果不存在，就不使用事物
     *  Propagation.MANDATORY ： 支持当前事物，如果不存在，就抛出异常
     *  Propagation.REQUIRES_NEW ：如果有事物存在，则挂起当前事物，创建一个新的事物
     *  Propagation.NOT_SUPPORTED ：以非事物方式运行，如果有事物存在，挂起当前事物
     *  Propagation.NEVER ：以非事物方式运行，如果有事物，则抛出异常
     *  Propagation.NESTED ：如果当前事物存在，则嵌套事物运行
     * @param flag
     * @param cost
     */
    @Override
    @Transactional
    public void transactionInsert (boolean flag,Cost cost) {
        this.saveCost(cost);
        if(flag){
            throw new RuntimeException("has exception!!!");
        }
    }

    @Override
    public List<Cost> selectList(Cost cost) {
        EntityWrapper ew=new EntityWrapper();
        ew.where("money={0}",cost.getMoney());
        return costMapper.selectList(ew);
    }
}
