package com.web.downloadFile;


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordFile {
    public static void main(String[] args) {
        try{
            String path="F:\\借款合同1111.doc";
            OutputStream out=new FileOutputStream(path);
            Map<String,Object> params=new HashMap<>();
            params.put("companyName","傅里叶");
            params.put("creditCode","2121221212122121");
            params.put("companyType","企业类型");
            params.put("registeAmt","壹仟元");
            params.put("legalPersonName","张三");
            params.put("legalPersonPhone","15868457889");
            params.put("businessScope","计算机");
            createWord("financingContract.ftl",out,params);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 创建word文档
     * @param tempPaht
     * @param outputStream
     * @param params
     */
    public static void createWord(String tempPaht, OutputStream outputStream,Map<String,Object> params){
        Writer writer=null;
        try{
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File("F:/"));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");
            Template t = configuration.getTemplate(tempPaht);
            writer=new OutputStreamWriter(outputStream,"UTF-8");
            t.process(params,writer);
            writer.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
