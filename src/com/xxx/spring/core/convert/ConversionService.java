package com.xxx.spring.core.convert;

/**
 * 功能描述
 *  类型转换抽象接口
 * @author: jx
 * @date: 2024年07月04日 11:18
 */
public interface ConversionService {

    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);
}
