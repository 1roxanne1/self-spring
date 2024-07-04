package com.xxx.spring.beans;

/**
 * 功能描述
 * bean的信息属性
 * @author: jx
 * @date: 2024年07月01日 16:59
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
