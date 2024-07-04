package com.xxx.spring.beans.factory;

import com.xxx.spring.beans.BeansException;

public interface DisposableBean {
    void destroy()throws BeansException;
}
