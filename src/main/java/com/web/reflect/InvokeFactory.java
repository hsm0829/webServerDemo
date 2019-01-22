package com.web.reflect;


import com.alibaba.fastjson.JSON;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射
 */
public class InvokeFactory {
    /**
     * 获取类的包名
     * @param cls
     * @return
     */
    public String getPackageName(Class cls){
        return cls.getName();
    }

    /**
     * 获取public修饰的类属性
     * @param className
     */
    public void attributeMethod(String className){
        System.out.println("--获取public修饰的类属性");
        try{
            Class cls=Class.forName(className);
            Object object = cls.newInstance();//实例化clas，相当于new 一个Object
            Map<String,Object> attributeMap=new HashMap<>();
            Field[] fields = cls.getFields();
            for (int i=0;i<fields.length;i++){
                Field field = fields[i];
                String key = field.getName();//获取属性名
                Object val = field.get(object);//获取属性值
                attributeMap.put(key,val);
            }
            System.out.println("----类："+cls.getName()+"，public属性："+ JSON.toJSONString(attributeMap));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取类的所有属性
     * @param className
     */
    public void allAttributeMehtod(String className){
        System.out.println("--获取类的所有属性");
        try{
            Class cls=Class.forName(className);
            Object object = cls.newInstance();//实例化clas，相当于new 一个Object
            Map<String,Object> allAttributeMap=new HashMap<>();
            Field[] declaredFields = cls.getDeclaredFields();
            for (int i=0;i<declaredFields.length;i++){
                Field declaredField = declaredFields[i];
                declaredField.setAccessible(true);//设置操作权限；决定是启用还是禁用java的权限控制的安全检查，private类型的属性不允许操作范文
                String name = declaredField.getName();//获取属性名
                Object value = declaredField.get(object);//获取属性值
                allAttributeMap.put(name,value);
            }
            System.out.println("----类："+cls.getName()+"，所有属性："+ JSON.toJSONString(allAttributeMap));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据name分别获取共有和私有的属性值
     * @param className
     * @param privateName
     * @param publicName
     */
    public void getFieldByName(String className,String privateName,String publicName){
        try{
            Class cls=Class.forName(className);
            Object object = cls.newInstance();//实例化clas，相当于new 一个Object

            System.out.println("--获取public修饰的属性");
            Field publicField = cls.getField(publicName);
            Object publicValue = publicField.get(object);
            System.out.println("----publicValue="+publicValue);

            System.out.println("--获取private修饰的属性");
            Field privateField = cls.getDeclaredField(privateName);
            privateField.setAccessible(true);
            Object privateValue = privateField.get(object);
            System.out.println("----privateValue="+privateValue);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取public修饰的方法
     * @param className
     */
    public void publicMethod(String className){
        System.out.println("--获取类的public修饰的方法");
        try{
            Class cls=Class.forName(className);
            Object object = cls.newInstance();//实例化clas，相当于new 一个Object
            Method[] methods = cls.getMethods();
            for (int i=0;i<methods.length;i++){
                Method method = methods[i];
                Class<?>[] parameterTypes = method.getParameterTypes();
                System.out.println("--method="+method);
                System.out.println("--params="+JSON.toJSONString(parameterTypes));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取类指定的方法
     * @param className
     * @param methodName
     * @param paramsType
     * @param values
     */
    public void methodByName(String className,String methodName,String[] paramsType,Object[] values){
        System.out.println("--获取类指定的方法");
        try{
            Class cls=Class.forName(className);
            Object object = cls.newInstance();//实例化clas，相当于new 一个Object
            Class<?>[] parameterTypes=new Class[paramsType.length];
            for (int i=0;i<paramsType.length;i++){
                parameterTypes[i]=Class.forName(paramsType[i]);
            }
            Method method = cls.getMethod(methodName, parameterTypes);
            Object resultObj = method.invoke(object, values);
            System.out.println("----获取方法"+methodName+"的返回值 : "+resultObj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取类的构造函数
     * @param className
     * @param paramsType
     * @param values
     */
    public void constructorMethodByName(String className,String[] paramsType,Object[] values){
        System.out.println("--获取类的构造函数");
        try{
            Class cls=Class.forName(className);
            Object object = cls.newInstance();//实例化clas，相当于new 一个Object
            Class<?>[] parameterTypes=new Class[paramsType.length];
            for (int i=0;i<paramsType.length;i++){
                parameterTypes[i]=Class.forName(paramsType[i]);
            }
            Constructor constructor = cls.getConstructor(parameterTypes);
            Student student=(Student) constructor.newInstance(values);
            System.out.println("----类的构造函数 : "+JSON.toJSONString(student));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InvokeFactory factory=new InvokeFactory();
        String packageName = factory.getPackageName(Student.class);
        //构造函数
//        String[] paramType1={"java.lang.String","java.lang.Integer","java.lang.Integer"};
//        Object[] values1={"tom",10,100};
//        factory.constructorMethodByName(packageName,paramType1,values1);
        //执行指定的方法
        String[] paramType={"java.lang.String","java.lang.Integer","java.lang.Integer","java.lang.String"};
        Object[] values={"hsm",10,100,"ok"};
        factory.methodByName(packageName,"methodTest",paramType,values);
    }



}
