package com.sun.parent.common.utils;


import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.exception.base.BusinessRuntimeException;
import java.util.*;

public final class BeanCopierUtils {

    private static final Map<String, net.sf.cglib.beans.BeanCopier> BEANCOPIER_MAP = new HashMap<String, net.sf.cglib.beans.BeanCopier>();
    private BeanCopierUtils() {}

    /**
     * copy properties
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        String beanKey = generateKey(source.getClass(), target.getClass());
        net.sf.cglib.beans.BeanCopier copier = BEANCOPIER_MAP.get(beanKey);
        if (copier == null) {
            copier = net.sf.cglib.beans.BeanCopier.create(source.getClass(), target.getClass(), false);
            BEANCOPIER_MAP.put(beanKey, copier);
        }
        copier.copy(source, target, null);
    }

    /**
     * 根据两个class名组装成key
     *
     * @param class1
     * @param class2
     * @return
     */
    private static String generateKey(Class<?> class1, Class<?> class2) {
        return new StringBuilder().append(class1.toString()).append(class2.toString()).toString();
    }

    /**
     * 拷贝对象
     *
     * @param source
     * @param target
     * @return
     * @throws BusinessRuntimeException
     */
    public static <T> T copyOne2One(Object source, Class<T> target) throws BusinessRuntimeException {
        T instance = null;
        try {
            instance = target.newInstance();
            copyProperties(source, instance);
        } catch (Exception e) {
            throw new BusinessRuntimeException(CommonErrorCode.COMMON_400, e);
        }
        return instance;
    }

    /**
     * 拷贝集合
     *
     * @param source
     * @param target
     * @return
     * @throws BusinessRuntimeException
     */
    public static <T> List<T> copyList2List(List<?> source, Class<T> target)
            throws BusinessRuntimeException {
        if (source.isEmpty()) {
            return new ArrayList<T>();
        }
        List<T> result = new ArrayList<T>();
        for (Object obj : source) {
            result.add(copyOne2One(obj, target));
        }
        return result;
    }

    /**
     *
     * @param source
     * @param target
     */
    public static void copyAttribute(Object source, Object target) {
        if (source == null || target == null) return;
        String key =
                new StringBuilder().append(source.getClass().toString())
                        .append(target.getClass().toString()).toString();
        net.sf.cglib.beans.BeanCopier beanCopier = BEANCOPIER_MAP.get(key);
        if (beanCopier == null) {
            beanCopier = net.sf.cglib.beans.BeanCopier.create(source.getClass(), target.getClass(), false);
            BEANCOPIER_MAP.put(key, beanCopier);
        }
        beanCopier.copy(source, target, null);
    }
}
