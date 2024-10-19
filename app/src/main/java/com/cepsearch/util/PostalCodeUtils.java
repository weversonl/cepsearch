package com.cepsearch.util;

import org.apache.commons.lang3.StringUtils;

public class PostalCodeUtils {

    private PostalCodeUtils() {

    }

    public static String cleanPostalCode(String postalCode) {
        if (StringUtils.isBlank(postalCode)) {
            return null;
        }
        return postalCode.trim().replace("-", "");
    }

}
