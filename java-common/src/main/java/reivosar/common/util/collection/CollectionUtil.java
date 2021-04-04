package reivosar.common.util.collection;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

public class CollectionUtil {

    private CollectionUtil() {
    }

    public static <T>boolean isNotEmpty(Collection<T> values) {
        return CollectionUtils.isNotEmpty(values);
    }

    public static <T>boolean isEmpty(Collection<T> values) {
        return CollectionUtils.isEmpty(values);
    }
}
