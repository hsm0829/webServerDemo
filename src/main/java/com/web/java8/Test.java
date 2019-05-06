package com.web.java8;

import org.apache.commons.collections.Factory;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(9);
        //filter——接收 Lambda ， 从流中排除某些元素
//        filterStream(list);
        //limit——截断流，使其元素不超过给定数量
//        limitStream(list);
        //skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
//        skipStream(list);
        //distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
//        distinctStream(list);
        //整合filter、limit、skip、distinct
//        list.stream().filter((e)->{
//            System.out.println("lambda表达....");
//            return e>2;
//        }).limit(5).skip(2).distinct().forEach(System.out::println);
        //map 集合
//        mapStream();
        //map java对象
//        mapEmpStream();
        //消费型接口
//        consumerMethod(100,m-> System.out.println("金额 : "+m));
        //供给型接口
//        List<Integer> getnumList = getnumList(5, () -> (int) (Math.random() * 100));
//        for (Integer num:getnumList){
//            System.out.println(num);
//        }
        //函数型接口，传进去T ，返回R
//        String strHandler = strHandler("老娘天下最美", str -> str + "，鉴定完毕");
//        System.out.println(strHandler);
        //断言型接口
//        List<Integer> filterStr = filterStr(list, n -> n > 4);
//        for (Integer num:filterStr){
//            System.out.println(num);
//        }
        //方法引用
//        methodTest();
//        sort2Stream(list);
    }

    /**
     * filter——接收 Lambda ， 从流中排除某些元素
     * @param list
     */
    public static void filterStream(List<Integer> list){
        Stream<Integer> stream = list.stream().filter((e) -> {
            System.out.println("filter——接收 Lambda ， 从流中排除某些元素。");
            return e < 4;
        });
        stream.forEach(System.out::println);
    }

    /**
     * limit——截断流，使其元素不超过给定数量。
     * @param list
     */
    public static void limitStream(List<Integer> list){
        Stream<Integer> stream = list.stream().limit(5);
        stream.forEach(System.out::println);
    }

    /**
     * skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
     * @param list
     */
    public static void skipStream(List<Integer> list){
        Stream<Integer> stream = list.stream().skip(5);
        stream.forEach(System.out::println);
    }

    /**
     * distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * @param list
     */
    public static void distinctStream(List<Integer> list){
        Stream<Integer> stream = list.stream().distinct();
        stream.forEach(System.out::println);
    }

    /**
     * map Stream
     */
    public static void mapStream(){
        List<String> list= Arrays.asList("aaa","baf","abn","dsf","www");
        list.stream().map((e)->e.toUpperCase()).forEach(System.out::println);
    }

    /**
     * mapEmpStream
     */
    public static void mapEmpStream(){
        List<Employee> list=new ArrayList<>();
        Employee employee=new Employee();
        employee.setName("张三");
        employee.setAge(18);
        list.add(employee);
        Employee employee1=new Employee();
        employee1.setName("李四");
        employee1.setAge(14);
        list.add(employee1);
        list.stream().map(Employee::getName).forEach(System.out::println);
    }

    /**
     * sort List
     * @param list
     */
    public static void sortStream(List<Integer> list){
        list.stream().sorted().forEach(System.out::println);
    }

    /**
     * sort2 List
     * @param list
     */
    public static void sort2Stream(List<Integer> list){
        list.stream().sorted((x,y)->{
            if(x>y){
                return -1;
            }
            return 0;
        }).forEach(System.out::println);
    }

    /**
     * 消费型接口（无返回值，需要传参数，只进不出）
     * @param money
     * @param consumer
     */
    public static void consumerMethod(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    /**
     * Supplier<T>供给型接口
     * @param num
     * @param supplier
     * @return
     */
    public static List<Integer> getnumList(int num, Supplier<Integer> supplier){
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<num;i++){
            Integer n=supplier.get();
            list.add(n);
        }
        return list;
    }

    /**
     * 用于处理字符串
     * @param str
     * @param function
     * @return
     */
    public static String strHandler(String str,Function<String,String> function){
        return function.apply(str);
    }

    /**
     * 断言型接口
     * @param list
     * @param predicate
     * @return
     */
    public static List<Integer> filterStr(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> resList=new ArrayList<>();
        for (Integer num:list){
            if(predicate.test(num)){
                resList.add(num);
            }
        }
        return resList;
    }

    /**
     * 方法引用
     */
    public static void methodTest(){
//        PrintStream out = System.out;
//        Consumer<String> consumer=str->out.println(str);
//        consumer.accept("老娘天下最美");
//        Supplier<Employee> sup=Employee::new;
//        System.out.println("Supplier : "+sup.get());
    }
}
