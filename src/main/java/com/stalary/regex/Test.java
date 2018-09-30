/**
 * @(#)Test.java, 2018-08-29.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Test
 *
 * @author lirongqian
 * @since 2018/08/29
 */
public class Test {

    public static void main(String[] args) {
        String str = "11111\n22222\n33333-\n44444-4444\n44444-444452";
        Pattern pattern = Pattern.compile("\\d{5}(\\?(\\?=-)-\\d{4})");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}