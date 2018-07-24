////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//package com.sun.parent.common.utils;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import net.sf.cglib.beans.BeanCopier;
//import net.sf.cglib.core.Converter;
//
//public final class BeanCopierUtils {
//    private static final Map<String, BeanCopier> BEANCOPIER_MAP;
//
//    static {
//        LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_COMMON.getLogName());
//        BEANCOPIER_MAP = new HashMap();
//    }
//
//    private BeanCopierUtils() {
//    }
//
//    public static void copyProperties(Object source, Object target) {
//        if (source != null && target != null) {
//            String beanKey = generateKey(source.getClass(), target.getClass());
//            BeanCopier copier = (BeanCopier)BEANCOPIER_MAP.get(beanKey);
//            if (copier == null) {
//                copier = BeanCopier.create(source.getClass(), target.getClass(), false);
//                BEANCOPIER_MAP.put(beanKey, copier);
//            }
//
//            copier.copy(source, target, (Converter)null);
//        }
//    }
//
//    private static String generateKey(Class<?> class1, Class<?> class2) {
//        return class1.toString() + class2.toString();
//    }
//
//    public static <T> T copyOne2One(Object source, Class<T> target) throws BusinessRuntimeException {
//        Object instance = null;
//
//        try {
//            instance = target.newInstance();
//            copyProperties(source, instance);
//            return instance;
//        } catch (Exception var4) {
//            LOGGER.error("对象拷贝异常:source=[{}] target=[{}]", new Object[]{source, target});
//            throw new BusinessRuntimeException(CommonErrorCode.COMMON_400, var4);
//        }
//    }
//
//    public static <T> List<T> copyList2List(List<?> source, Class<T> target) throws BusinessRuntimeException {
//        if (source.isEmpty()) {
//            return new ArrayList();
//        } else {
//            List<T> result = new ArrayList();
//            Iterator var4 = source.iterator();
//
//            while(var4.hasNext()) {
//                Object obj = var4.next();
//                result.add(copyOne2One(obj, target));
//            }
//
//            return result;
//        }
//    }
//
//    public static void copyAttribute(Object source, Object target) {
//        if (source != null && target != null) {
//            String key = source.getClass().toString() + target.getClass().toString();
//            BeanCopier beanCopier = (BeanCopier)BEANCOPIER_MAP.get(key);
//            if (beanCopier == null) {
//                beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
//                BEANCOPIER_MAP.put(key, beanCopier);
//            }
//
//            beanCopier.copy(source, target, (Converter)null);
//        }
//    }
//}
