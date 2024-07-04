package com.xxx.spring.beans.factory.support;

import com.xxx.spring.beans.BeansException;
import com.xxx.spring.beans.factory.DisposableBean;
import com.xxx.spring.beans.factory.ObjectFactory;
import com.xxx.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *  bean注册表
 * @author: jx
 * @date: 2024年07月04日 10:11
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 一级缓存
     */
    private Map<String,Object> singletonObjects = new HashMap<>();
    /**
     * 二级缓存
     */
    private Map<String,Object> earlySingletonObjects = new HashMap<>();
    /**
     * 三级缓存
     */
    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();



    @Override
    public Object getSingleton(String beanName) {
        //先从一级缓存取
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject==null){
            //从二级缓存取
            singletonObject = earlySingletonObjects.get(beanName);
            if (singletonObject==null){
                //从三级缓存取得，并放入二级缓存
                ObjectFactory<?> objectFactory = singletonFactories.get(beanName);
                if (objectFactory!=null){
                    singletonObject = objectFactory.getObject();
                    earlySingletonObjects.put(beanName,singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);//1
        earlySingletonObjects.remove(beanName);//2
        singletonFactories.remove(beanName);//3
    }

    protected void addSingletonFactory(String beanName,ObjectFactory<?> singletonFactory){
        singletonFactories.put(beanName,singletonFactory);
    }

    public void registerDisposableBean(String beanName,DisposableBean bean){
        disposableBeans.put(beanName,bean);
    }

    public void destroySingletons(){
        ArrayList<String> beanNames = new ArrayList<>(disposableBeans.keySet());
        beanNames.stream().forEach(name->{
            DisposableBean disposableBean = disposableBeans.remove(name);
            try{
                disposableBean.destroy();
            }catch (Exception e){
                throw new BeansException("Destroy method on bean with name '" + name + "' threw an exception", e);
            }
        });
    }
}
