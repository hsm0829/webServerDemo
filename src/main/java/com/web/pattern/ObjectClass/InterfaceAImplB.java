package com.web.pattern.ObjectClass;

public class InterfaceAImplB implements InterfaceA{
    @Override
    public String interfaceAMethod() {
        System.out.println("InterfaceAImplB : interfaceAMethod");
        return null;
    }
}
