package com.xxx.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: jx
 * @date: 2024年07月01日 17:03
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加属性
     * @param pv
     */
    public void addPropertyValue(PropertyValue pv){
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue currentPv = propertyValueList.get(i);
            if (currentPv.getName().equals(pv.getName())){
                this.propertyValueList.set(i,pv);
                return;
            }
        }
        this.propertyValueList.add(pv);
    }

    /**
     * list转数组
     * @return
     */
    public PropertyValue[] getPropertyValues(){
        //参数传希望转换的数组类型和大小，0代表自动判断
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 获取属性对象
     * @param propertyName
     * @return
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue pv = this.propertyValueList.get(i);
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
