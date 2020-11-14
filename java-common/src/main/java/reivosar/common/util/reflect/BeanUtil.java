package reivosar.common.util.reflect;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtil {

	private BeanUtil() {
	}

	public static Map<String, String> describe(Object object) {
		try {
			return BeanUtils.describe(object);
		} catch (Throwable e) {
			throw new Exception("BeanUtil describe error.", e);
		}
	}

	public static <T, V> T mapToBean(Map<String, V> map, Class<T> clazz) {
		 try {
			 if(ConstructorUtil.hasPublicDefaultConstructor(clazz)) {
				 T bean = ConstructorUtil.newInstanceWithPublicDefaultConstructor(clazz);
				 populate (bean, map);
				 return bean;
			 } else {
				 return null;
			 }
		} catch (Throwable e) {
			throw new Exception("BeanUtil mapToBean error.", e);
		}
	}

	public static <V> void populate(Object bean, String paramName, Object value) {
		try {
			FieldUtil.setField(bean, paramName, value);
		} catch (Throwable ignored) {
		}
	}

	public static <V> void populate(Object bean, Map<String, V> map) {
		map.forEach((paramName, value) -> {
			try {
				FieldUtil.setField(bean, paramName, value);
			} catch (Throwable ignored) {
			}
		});
	}

	public static class Exception extends RuntimeException {
	    public Exception(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
}
