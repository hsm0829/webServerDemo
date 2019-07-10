package com.web.junit;


import java.util.*;

public class Test {

//    public static void main(String[] args) {
//        ArithmeticCalculatorI target=new ArithmeticCalculatorImpl();
//        ArithmeticCalculatorI proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
//        int result=proxy.add(1,2);
//        System.out.println("-->"+result);
//        result=proxy.sub(4,2);
//        System.out.println("-->"+result);
//    }

//    public static void main(String[] args) {
//        List list=new ArrayList();
//        list.add(1);
//        List list1=new LinkedList();
//        list1.add(1);
//    }

    public static void main(String[] args) {
        synchronized ("213"){

        }
    }
    /**
     * list set map 区别
     */
    public void ListSetMap(){
        //元素区别
        //--List  元素可重复
        //--Set   元素不可重复
        //--Map   元素key不可重复，value可重复

        //顺序区别
        //--List   有序
        //--Set    无序（由hashcode决定） , 内部是HashMap操作
        //--Map    无序

//        Collections.synchronizedMap();  //HashMap同步
        //常用方法

    }
}
