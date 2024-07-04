package com.xxx.spring.beans.factory;

import com.xxx.spring.beans.BeansException;

public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
