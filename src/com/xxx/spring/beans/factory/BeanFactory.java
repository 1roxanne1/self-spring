package com.xxx.spring.beans.factory;

import com.xxx.spring.beans.BeansException;

/**
 * 功能描述
 *  bean容器
 * @author: jx
 * @date: 2024年07月01日 16:38
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name)throws BeansException;

    /**
     * 根据名称和类型获取bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name,Class<T> requiredType)throws BeansException;

    <T> T getBean(Class<T> requiredType)throws BeansException;

    boolean containsBean(String name);
}
