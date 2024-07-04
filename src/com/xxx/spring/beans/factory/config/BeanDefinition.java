package com.xxx.spring.beans.factory.config;

import com.xxx.spring.beans.PropertyValues;

import java.util.Objects;

/**
 * 功能描述
 *  BeanDefinition实例保存bean的信息，包括class类型、方法构造参数、bean属性、
 *  bean的scope等，此处简化只包含class类型和bean属性
 * @author: jx
 * @date: 2024年07月01日 16:55
 */
public class BeanDefinition {
    public static String SCOPE_SINGLETON="singleton";
    public static String SCOPE_PROTOTYPE="prototype";

    /**
     * bean Class类
     */
    private Class beanClass;

    /**
     * class 属性值
     */
    private PropertyValues propertyValues;
    /**
     * 反射初始化bean 方法名称
     */
    private String initMethodName;
    /**
     * 反射销毁bean 方法名称
     */
    private String destroyMethodName;
    /**
     * 作用域，默认单例
     */
    private String scope = SCOPE_SINGLETON;

    private boolean singleton = true;
    private boolean prototype = false;

    /**
     * 懒加载
     */
    private boolean lazyInit = false;

    //构造方法
    public BeanDefinition(Class beanClass){
        this(beanClass,null);
    }

    public BeanDefinition(Class beanClass,PropertyValues propertyValues){
        this.beanClass = beanClass;
        this.propertyValues = propertyValues !=null?propertyValues:new PropertyValues();
    }

    public void setScope(String scope){
        this.scope = scope;
        this.singleton =SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public void setLazyInit(boolean b){
        lazyInit=b;
    }

    public boolean isLazyInit(){
        return lazyInit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beanClass);
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        BeanDefinition that = (BeanDefinition) o;
        return beanClass.equals(that.beanClass);
    }

}
