package com.web.generator.service;

import com.web.generator.dao.entity.Cost;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hsm
 * @since 2019-01-08
 */
public interface CostService extends IService<Cost> {

    /**
     * 分页查询列表
     * @param pageSize
     * @param current
     * @param cost
     * @return
     */
    List<Cost> findCostPage(int pageSize,int current,Cost cost);

    /**
     * 保存cost
     * @param cost
     * @return
     */
    boolean saveCost(Cost cost);

    /**
     * 事物处理
     * @param flag
     * @return
     */
    void transactionInsert(boolean flag,Cost cost);

    /**
     * 根据条件查询列表
     * @param cost
     * @return
     */
    List<Cost> selectList(Cost cost);

}
