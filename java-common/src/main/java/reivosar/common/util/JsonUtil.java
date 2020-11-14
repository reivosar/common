package reivosar.common.util;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil
{
	private JsonUtil() {}

	public static String toJson(Object obj) {
		try {
			return ObjectMapperHolder.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Throwable e) {
			throw new JsonUtil.Exception("JsonUtil serialize error.", e);
		}
	}

	public static Map<String, Object> toMap(String json) {
		try {
			return ObjectMapperHolder.mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
		} catch (Throwable e) {
			throw new JsonUtil.Exception("JsonUtil deserialize error.", e);
		}
	}

	public static Map<String, Object> toPropertyMap(String json) {
		try {
			return toMap(json);
		} catch (Throwable e) {
			throw new JsonUtil.Exception("JsonUtil deserialize error.", e);
		}
	}

	public static class Exception extends RuntimeException {
	    public Exception(String message, Throwable cause) {
	        super(message, cause);
	    }
	}

	private static final class ObjectMapperHolder {
		private static final ObjectMapper mapper = new ObjectMapper();
	}
}
