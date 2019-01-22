package com.web.MultiDataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源切换
 */
public class MultiDataSourceConfig extends AbstractRoutingDataSource{

    /**
     * ThreadLocal 叫线程本地变量或叫线程本地存储
     * ThreadLocal为变量在每个线程中创建了一个副本，那么每个变量可以访问自己内部的副本变量
     * 这里使用它的子类InheritableThreadLocal用来保证父子线程都能拿到值。
     */
    private static final ThreadLocal<String> dataSourceKey=new InheritableThreadLocal();

    /**
     * 返回当前的DataSourceKey的值
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    /**
     * 设置dataSourceKey的值
     * @param dataSource
     */
    public static void setDataSourceKey(String dataSource){
        dataSourceKey.set(dataSource);
    }

    /**
     * 清除dataSourceKey的值
     */
    public static void toDefault(){
        dataSourceKey.remove();
    }
}
