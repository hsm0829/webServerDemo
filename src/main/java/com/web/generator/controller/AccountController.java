package com.web.generator.controller;


import com.web.downloadFile.docx.XMlToDocx;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "/downloadWord",method = RequestMethod.GET)
    @ResponseBody
    public void downloadWord(){
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("companyName","傅里叶");
            params.put("creditCode","2121221212122121");
            params.put("companyType","企业类型");
            params.put("registeAmt","壹仟元");
            params.put("legalPersonName","张三");
            params.put("legalPersonPhone","15868457889");
            params.put("businessScope","计算机");
            XMlToDocx.makeWord(params,"F:/makeWord/financing","F:/makeWord/financing/融资业务申请书111",null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

