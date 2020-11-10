package reivosar.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils
{
	private JsonUtils() {}

	public static String toJson(Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Throwable e) {
			throw new JsonUtils.SerializeException("JsonUtils serialize error.", e);
		}
	}

	public static <T>T fromJson(String json, Class<T> clazz) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.convertValue(json, clazz);
		} catch (Throwable e) {
			throw new JsonUtils.DeserializeException("JsonUtils deserialize error.", e);
		}
	}

	public static class SerializeException extends RuntimeException {
	    public SerializeException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}

	public static class DeserializeException extends RuntimeException {
	    public DeserializeException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
}
