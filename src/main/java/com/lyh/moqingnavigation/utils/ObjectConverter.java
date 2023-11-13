package com.lyh.moqingnavigation.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :liangyuhang1
 * @className :ObjectConverter
 * @date :2023/11/11/16:30
 */

public class ObjectConverter {
    /**
     * 将一个对象转换为另一个类的对象
     *
     * @param sourceObject 要转换的对象
     * @param targetClass  目标类
     * @param <T>          源对象的类型
     * @param <U>          目标对象的类型
     * @return 转换后的对象
     */
    public static <T, U> U convertObject(T sourceObject, Class<U> targetClass) {
        try {
            U targetObject = targetClass.getDeclaredConstructor().newInstance();

            Field[] sourceFields = sourceObject.getClass().getDeclaredFields();
            Field[] targetFields = targetClass.getDeclaredFields();

            for (Field targetField : targetFields) {
                Field sourceField = getSourceField(targetField, sourceFields);
                if (sourceField != null) {
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    targetField.set(targetObject, sourceField.get(sourceObject));
                }
            }
            return targetObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据目标字段的名称和类型，在源字段数组中查找对应的字段。
     *
     * @param targetField  目标字段
     * @param sourceFields 源字段数组
     * @return 匹配的字段，如果没有匹配则返回null
     */
    private static Field getSourceField(Field targetField, Field[] sourceFields) {
        for (Field field : sourceFields) {
            if (field.getName().equals(targetField.getName()) && field.getType().equals(targetField.getType())) {
                return field;
            }
        }
        return null;
    }

    /**
     * 将一个List中的元素转换为目标类型并返回新的List
     *
     * @param <T>         源列表元素的类型
     * @param <U>         目标列表元素的类型
     * @param sourceList  源列表
     * @param targetClass 目标类的类型
     * @return 转换后的目标列表
     */
    public static <T, U> List<U> convertList(List<T> sourceList, Class<U> targetClass) {
        List<U> targetList = new ArrayList<>();
        for (T sourceObject : sourceList) {
            // 将源对象转换为目标对象
            U targetObject = convertObject(sourceObject, targetClass);
            // 将目标对象添加到目标列表中
            targetList.add(targetObject);
        }
        // 返回转换后的目标列表
        return targetList;
    }

}
