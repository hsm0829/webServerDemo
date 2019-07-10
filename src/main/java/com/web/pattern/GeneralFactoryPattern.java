package com.web.pattern;

import com.web.pattern.ObjectClass.InterfaceA;
import com.web.pattern.ObjectClass.InterfaceAImplA;
import com.web.pattern.ObjectClass.InterfaceAImplB;

/**
 * 普通工厂模式，多个类实现同一个接口，在普通工厂模式里，创建实例，通过字符串获取对应实例
 */
public class GeneralFactoryPattern {

    public static InterfaceA product(String str){
        if(("InterfaceAImplA").equals(str)){
            return new InterfaceAImplA();
        }else if(("InterfaceAImplB").equals(str)){
            return new InterfaceAImplB();
        }
        return null;
    }

    public static void main(String[] args) {
        InterfaceA interfaceA=GeneralFactoryPattern.product("InterfaceAImplA");
        interfaceA.interfaceAMethod();
        System.out.println(interfaceA.toString());
    }
}
