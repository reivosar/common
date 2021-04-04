package reivosar.common.util.lang;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isNumeric(String value) {
        return StringUtils.isNumeric(value);
    }

}
