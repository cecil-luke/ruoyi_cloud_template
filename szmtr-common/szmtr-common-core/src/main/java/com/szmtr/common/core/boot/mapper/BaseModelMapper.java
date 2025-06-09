//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.szmtr.common.core.boot.mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.szmtr.common.core.utils.bean.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.GenericTypeResolver;
import org.springframework.util.ClassUtils;

public interface BaseModelMapper<D, M> {
    D fromModel(M var1);

    List<D> fromModelList(List<M> var1);

    M toModel(D var1);

    List<M> toModelList(List<D> var1);

    default <T> Map<String, Object> beanToMap(T bean, boolean ignoreNullValue) {
        return BeanUtils.beanToMap(bean, false, ignoreNullValue);
    }

    default <T> List<Map<String, Object>> beanToMap(List<T> dataList, boolean ignoreNullValue) {
        return (List) (CollectionUtils.isEmpty(dataList) ? new LinkedList() : (List) dataList.stream().map((o) -> {
            return BeanUtils.beanToMap(o, false, ignoreNullValue);
        }).collect(Collectors.toList()));
    }

    default <T> T mapToBean(Map<String, Object> map, Class<T> beanClazz) {
        return BeanUtils.toBeanIgnoreError(map, beanClazz);
    }

    default <T> List<T> mapToBean(List<Map<String, Object>> mapList, Class<T> beanClazz) {
        return (List) (CollectionUtils.isEmpty(mapList) ? new LinkedList() : (List) mapList.stream().map((m) -> {
            return BeanUtils.toBeanIgnoreError(m, beanClazz);
        }).collect(Collectors.toList()));
    }

    default Map<String, Object> mapToMap(Map<String, Object> map) {
        return map;
    }

    default <T> boolean isModelClass(Object model) {
        Class<?>[] classes = GenericTypeResolver.resolveTypeArguments(this.getClass(), BaseModelMapper.class);
        return ClassUtils.isAssignable(classes[1], model.getClass());
    }

    default <T> boolean isDomainClass(Object domain) {
        Class<?>[] classes = GenericTypeResolver.resolveTypeArguments(this.getClass(), BaseModelMapper.class);
        return ClassUtils.isAssignable(classes[0], domain.getClass());
    }
}
