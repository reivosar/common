package reivosar.common.util.reflect;

import java.lang.reflect.Field;

public class FieldUtil {

	private FieldUtil() {
	}

	public static void setField(Object object, String fieldName, Object fieldValue) {
		try {
			if (fieldName.contains(".")) {
				int firstDotLocation = fieldName.indexOf('.');
				String childFieldName = fieldName.substring(0, firstDotLocation);
				Field field = object.getClass().getDeclaredField(childFieldName);
				field.setAccessible(true);
				Object childFieldInstance = field.get(object);
				if (childFieldInstance == null) {
					Class<?> type = field.getType();
					childFieldInstance = type.getConstructor().newInstance();
					field.set(object, childFieldInstance);
				}
				field.setAccessible(false);
				setField(childFieldInstance, fieldName.substring(firstDotLocation + 1), fieldValue);
			} else {
				Field field = object.getClass().getDeclaredField(fieldName);
				field.setAccessible(true);
				field.set(object, fieldValue);
				field.setAccessible(false);
			}
		} catch (Throwable e) {
			throw new Exception("FieldUtil setField error.", e);
		}
	}

	public static class Exception extends RuntimeException {
	    public Exception(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
}
