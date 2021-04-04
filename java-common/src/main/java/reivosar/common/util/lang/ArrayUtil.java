package reivosar.common.util.lang;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ArrayUtil {

    private ArrayUtil() {
    }

    public static <T>List<T> asList(@SuppressWarnings("unchecked") T... arrays) {
        if (arrays == null) return List.of();
        return Arrays.asList(arrays);
    }

    public static <T>Set<T> asSet(@SuppressWarnings("unchecked") T... arrays) {
        if (arrays == null) return Set.of();
        return Set.copyOf(asList(arrays));
    }
}
