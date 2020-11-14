package reivosar.common.util.reflect;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("rawtypes")
public class ConstructorUtil
{
	private ConstructorUtil() {
	}

	public static <T> Collection<Constructor> getAllConstructors(Class<T> clazz) {
		return Arrays.asList(clazz.getDeclaredConstructors());
	}

	public static <T> Collection<Constructor> getAllPublicConstructors(Class<T> clazz) {
		return Arrays.asList(clazz.getConstructors());
	}

	public static <T> Optional<Constructor> getPublicDefaultConstructor(Class<T> clazz) {
		return getAllPublicConstructors(clazz).stream()
			.filter (constructor -> constructor.getParameterCount() == 0)
			.findFirst();
	}

	public static <T> boolean hasPublicDefaultConstructor(Class<T> clazz) {
		return getPublicDefaultConstructor(clazz).isPresent();
	}

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Constructor constructor, Object... parameters) {
		try {
			return (T) constructor.newInstance(parameters);
		} catch (Throwable e) {
			throw new Exception("ConstructorUtil getInstance error.", e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T newInstanceWithPublicDefaultConstructor(Class<T> clazz) {
		try {
			return (T) getPublicDefaultConstructor(clazz).get().newInstance();
		} catch (Throwable e) {
			throw new Exception("ConstructorUtil newInstanceWithPublicDefaultConstructor error.", e);
		}
	}

	public static class Exception extends RuntimeException {
	    public Exception(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
}
