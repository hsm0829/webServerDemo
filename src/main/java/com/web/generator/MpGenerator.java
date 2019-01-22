package com.web.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ResourceBundle;

/**
 * 代码生成器
 */
public class MpGenerator {

    public static void main(String[] args) {
        final ResourceBundle rb=ResourceBundle.getBundle("jdbc");
        AutoGenerator autoGenerator=new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
//        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        //全局配置
        GlobalConfig gc=new GlobalConfig();
        gc.setAuthor(rb.getString("authorName"));
        gc.setOutputDir(rb.getString("outputDir"));
        gc.setFileOverride(false);//是否覆盖同名文件
        gc.setActiveRecord(true);//ActiveRecord特性
        gc.setEnableCache(false);//xml二级缓存
        gc.setBaseResultMap(true);//xml ResultMap
        gc.setBaseColumnList(false);//xml columnList
        //自定义文件命名
        gc.setMapperName(rb.getString("mapperName"));
        gc.setXmlName(rb.getString("xmlName"));
        gc.setServiceName(rb.getString("serviceName"));
        gc.setServiceImplName(rb.getString("serviceImplName"));
        gc.setControllerName(rb.getString("controllerName"));
        autoGenerator.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc=new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());//类型转换
        dsc.setDriverName(rb.getString("jdbc.one.driverClassName"));
        dsc.setUsername(rb.getString("jdbc.one.username"));
        dsc.setPassword(rb.getString("jdbc.one.password"));
        dsc.setUrl(rb.getString("jdbc.one.url"));
        autoGenerator.setDataSource(dsc);

        //策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//表名生成策略
        strategyConfig.setInclude(new String[]{"cost","other_datasource","user"});
        //字段名生成策略
        strategyConfig.setSuperServiceImplClass(rb.getString("superServiceImpl"));
        autoGenerator.setStrategy(strategyConfig);

        //包配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent(rb.getString("parentPackage"));
        packageConfig.setController(rb.getString("controllerPackage"));
        packageConfig.setEntity(rb.getString("entityPackage"));
        packageConfig.setMapper(rb.getString("mapperPackage"));
        packageConfig.setService(rb.getString("servicePackage"));
        packageConfig.setServiceImpl(rb.getString("serviceImplPackage"));
        packageConfig.setXml(rb.getString("xmlPackage"));
        autoGenerator.setPackageInfo(packageConfig);

        //执行生成
        autoGenerator.execute();


    }
}
