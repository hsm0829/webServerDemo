package com.web.downloadFile.docx;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class XMlToDocx {

    public static void main(String[] args) {
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("companyName","傅里叶");
            params.put("creditCode","2121221212122121");
            params.put("companyType","企业类型");
            params.put("registeAmt","壹仟元");
            params.put("legalPersonName","张三");
            params.put("legalPersonPhone","15868457889");
            params.put("businessScope","计算机");
            makeWord(params,"F:/makeWord/financing","F:/makeWord/financing/融资业务申请书111",null);
            makePdfByXcode("F:/makeWord/financing","F:/makeWord/financing/融资业务申请书111");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 根据数据生成文本
     * @param dataMap 数据
     * @param outFilePath 生成的document.xml和document.xml.rels对应的目录名称
     * @param template 模板对象
     * @throws Exception
     */
    private static void toText(Map<String,Object> dataMap, String outFilePath, Template template)throws Exception  {
        File docFile = new File(outFilePath);
        FileOutputStream fos = new FileOutputStream(docFile);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"),10240);
        template.process(dataMap,out);
        if(out != null){
            out.close();
        }
    }

    /**
     * 生成word docx
     * @param dataMap 数据
     * @param ftlPath  ftl存放的目录（模板）
     * @param docFilePath 生成的document.xml和document.xml.rels对应的目录名称
     * @param fileList fileList 图片文件
     * @throws Exception
     */
    public static  void makeWord(Map<String,Object> dataMap,String ftlPath,String docFilePath,  List<File> fileList) throws Exception {
        /** 初始化配置文件 **/
        Configuration configuration = new Configuration();
        String fileDirectory = ftlPath;
        /** 加载文件 **/
        configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
        configuration.setDefaultEncoding("UTF-8");

        /** 加载模板 **/
        Template template = configuration.getTemplate("document.xml");
        /** 指定输出word文件的路径 **/
        String outFilePath = docFilePath+".xml";
        toText(dataMap,outFilePath,template);

        template = configuration.getTemplate("document.xml.rels");
        outFilePath = docFilePath+".xml.rels";
        toText(dataMap,outFilePath,template);

        try {
            ZipInputStream zipInputStream = ZipUtils.wrapZipInputStream(new FileInputStream(new File(fileDirectory+File.separator+"融资业务申请书.zip")));//该zip文件是docx重命名后的压缩文件
            ZipOutputStream zipOutputStream = ZipUtils.wrapZipOutputStream(new FileOutputStream(new File(docFilePath+".docx")));
            File fileText = new File(docFilePath+".xml");
            File fileImg = new File(docFilePath+".xml.rels");
            ZipUtils.replaceItem(zipInputStream, zipOutputStream, new FileInputStream(fileText), new FileInputStream(fileImg),fileList);
            if(fileText.exists()){
                fileText.delete();
            }
            if(fileImg.exists()){
                fileImg.delete();
            }
            //docx转pdf
//            XWPFDocument doc = new XWPFDocument(new FileInputStream(docFilePath+".docx"));// docx
//            PdfOptions options = PdfOptions.create();
//            PdfConverter.getInstance().convert(doc, new FileOutputStream(docFilePath+".pdf"), options);// pdf
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 生成pdf
     */
    public static  void makePdfByXcode(String ftlPath,String docFilePath){
        try {
            XWPFDocument document=new XWPFDocument(new FileInputStream(new File(docFilePath+".docx")));
            File outFile=new File(docFilePath+".pdf");
            if(!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdirs();
            }
            OutputStream out=new FileOutputStream(outFile);
            PdfOptions options= PdfOptions.getDefault();
            IFontProvider iFontProvider=new IFontProvider() {
                @Override
                public Font getFont(String familyName, String encoding, float size, int style, Color color) {
                    try{
                        BaseFont bfChinese=null;
                        String osName=System.getProperty("os.name");//运行环境
                        if(osName.indexOf("Linux")!=-1){
                            bfChinese =  BaseFont.createFont(ftlPath+"/font/msyh.ttf", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
                        }else{
                            bfChinese =  BaseFont.createFont("C:/WINDOWS/Fonts/华文宋体.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
                        }
                        Font fontChinese = new Font(bfChinese, size, style, color);
                        if(StringUtils.isNotEmpty(familyName)){
                            fontChinese.setFamily(familyName);
                        }
                        return fontChinese;
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    return null;
                }
            };
            options.fontProvider( iFontProvider );
            PdfConverter.getInstance().convert(document,out,options);
        }
        catch (  Exception e) {
            e.printStackTrace();
        }
    }
}
