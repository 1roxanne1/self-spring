package com.xxx.spring.beans.factory.config;

import com.xxx.spring.beans.factory.HierarchicalBeanFactory;
import com.xxx.spring.core.convert.ConversionService;
import com.xxx.spring.utils.StringValueResolver;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例bean
     */
    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);

    void setConversionService(ConversionService conversionService);

    ConversionService getConversionService();
}
