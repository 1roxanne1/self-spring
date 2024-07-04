package com.xxx.spring.beans.factory.support;

import com.xxx.spring.beans.BeansException;
import com.xxx.spring.beans.factory.config.BeanDefinition;

/**
 * 功能描述
 *  BeanDefinition注册表接口
 * @author: jx
 * @date: 2024年07月04日 9:54
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表注册beanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     *根据名称查询BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException   找不到对应beanDefinition
     */
    BeanDefinition getBeanDefinition(String beanName)throws BeansException;

    /**
     * 是否包含指定名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
