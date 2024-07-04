package com.xxx.spring.beans;

/**
 * 功能描述
 *
 * @author: jx
 * @date: 2024年07月01日 16:44
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg){
        super(msg);
    }
    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }
}
