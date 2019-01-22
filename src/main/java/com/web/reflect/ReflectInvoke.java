package com.web.reflect;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ReflectInvoke {

    private Map<String, String> manufacturerMap;

    @Resource
    private MyBeanFactory myBeanFactory;
    /**
     * 根据厂商名找到对应的服务，执行方法
     * @param manufacturerName	厂商名字
     * @param methodName	方法名字
     * @param types	参数类型
     * @param args	参数值
     * @return
     * @throws Throwable
     */
    public boolean invoke(String manufacturerName , String methodName, String[] types, Object[] args) throws Throwable{
        String className = manufacturerMap.get(manufacturerName);
        Class<?> clazz = Class.forName(className);
        Object bean = myBeanFactory.getBeanByClass(clazz);
        Class<?> [] typeClazzs = null;
        if(types!=null) {
            typeClazzs = new Class[types.length];
            for (int i = 0; i < typeClazzs.length; i++) {
                typeClazzs[i] = Class.forName(types[i]);
            }
        }
        Method method = clazz.getMethod(methodName, typeClazzs);
        try {
            //反射机制调用是没法catch到Checked异常的(自定义异常...),所以捕获异常,手动抛出
            Object result = method.invoke(bean, args);
            if(result instanceof Boolean){
                return Boolean.getBoolean(result.toString());
            }
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            throw cause;
        }
        return false;
    }
    public Map<String, String> getManufacturerMap() {
        return manufacturerMap;
    }

    public void setManufacturerMap(Map<String, String> manufacturerMap) {
        this.manufacturerMap = manufacturerMap;
    }
}
