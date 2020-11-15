package reivosar.common.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConstructorUtil
{
	private ConstructorUtil() {
	}

	public static <T> Collection<Constructor<T>> getAllConstructors(Class<T> clazz) {
		return toConstructorsCollection(clazz.getDeclaredConstructors());
	}

	public static <T> Collection<Constructor<T>> getAllPublicConstructors(Class<T> clazz) {
		return toConstructorsCollection(clazz.getConstructors());
	}

	@SuppressWarnings("unchecked")
	private static <T>Collection<Constructor<T>> toConstructorsCollection(Constructor<?>[] constructors) {
		return Arrays.asList(constructors)
				.stream().map(constructor -> (Constructor<T>)constructor)
				.collect(Collectors.toUnmodifiableList());
	}

	public static <T> Optional<Constructor<T>> getPublicDefaultConstructor(Class<T> clazz) {
		return getAllPublicConstructors(clazz).stream()
			.filter (constructor -> constructor.getParameterCount() == 0)
			.findFirst();
	}

	public static <T> boolean existsPublicDefaultConstructor(Class<T> clazz) {
		return getPublicDefaultConstructor(clazz).isPresent();
	}

	public static <T>Optional<Constructor<T>> getParameterMatchedConstructor(Class<T> clazz, Object... parameters) {
		return getAllConstructors(clazz).stream()
			.filter(constructor -> match(constructor, parameters))
			.findFirst();
	}

	public static <T>Map<String, Collection<Object>> getConstructorMatchedParameters(Class<T> clazz, Object... parameters)
	{
		if (parameters == null || parameters.length == 0)
			return Collections.emptyMap();

		final Map<String, Collection<Object>> result = new HashMap<>();
		getAllConstructors(clazz).stream().forEach(constructor -> {
			final String constructorName = constructor.getName();
			putConstructorMap(result, constructorName, constructor, parameters);
			if (constructor.getParameterCount() != result.get(constructorName).size())
				result.remove(constructorName);
		});
		return result;
	}

	private static <T> void putConstructorMap(
		Map<String, Collection<Object>> result,
		String mapKey,
		Constructor<T> constructor,
		Object... parameters)
	{
		Arrays.asList(parameters).stream().forEach(parameter -> {
			if (match(constructor, parameter)) {
				final Collection<Object> collection = result.getOrDefault(mapKey, new ArrayList<>());
				collection.add(parameter);
				result.put(mapKey, collection);
			}
		});
	}

	public static <T>boolean match(Constructor<T> constructor, Object... parameters) {
		for (final Class<?> clazz : getParameterTypes(constructor)) {
			if (!Arrays.asList(parameters).stream()
				.anyMatch(
					parameter -> clazz.getCanonicalName().equals(parameter.getClass().getCanonicalName())
				)
			) return false;
		}
		return true;
	}

	public static <T>Collection<Class<?>> getParameterTypes(Constructor<T> constructor) {
		return Arrays.asList(constructor.getParameterTypes());
	}

	public static <T>Collection<Parameter> getParameters(Constructor<T> constructor) {
		return Arrays.asList(constructor.getParameters());
	}

	public static <T> T newInstance(Constructor<T> constructor, Object... parameters) {
		try {
			return (T) constructor.newInstance(parameters);
		} catch (Throwable e) {
			throw new Exception("ConstructorUtil getInstance error.", e);
		}
	}

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
