package reivosar.common.util.lang;

import org.apache.commons.lang3.ObjectUtils;

public class ObjectUtil {

    private ObjectUtil() {
    }

    public static <T>T defaultIfNull(T value, T defaultValue) {
        return ObjectUtils.defaultIfNull(value, defaultValue);
    }
}
