package com.xxx.spring.beans.factory.config;

import com.xxx.spring.beans.BeansException;

/**
 * 功能描述
 *  用于修改实例化后的bean的修改扩展点
 * @author: jx
 * @date: 2024年07月04日 10:55
 */
public interface BeanPostProcessor {
    /**
     *  在bean执行初始化方法之前执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object PostProcessBeforeInitialization(Object bean,String beanName)throws BeansException;

    /**
     * 在bean执行初始化方法之后执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object PostProcessAfterInitialization(Object bean,String beanName)throws BeansException;

}
