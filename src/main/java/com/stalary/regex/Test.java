/**
 * @(#)Test.java, 2018-08-29.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.regex;

import java.util.Arrays;
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
        String str = "（1）∠1和∠ABC是直线AB，CE被直线?_BD_?所截得的?_同位_?角；\n" +
                "（2）∠2和∠BAC是直线CE，AB被直线?_AC_?所截得的?_内错_?角；\n" +
                "（3）∠3和∠ABC是直线?_AC_?，?_AB_?被直线?_BC_?所截得的?_同旁内_?角；\n" +
                "（4）∠ABC和∠ACD是直线?_AB_?，?_AC_?被直线?_BC_?所截得的?_同位_?角；\n" +
                "（5）∠ABC和∠BCE是直线?_AB_?，?_EF_?被直线?_BC_?所截得的?_同旁内_?角．";
        Pattern pattern = Pattern.compile("(\\?_[^\\?_]*_\\?)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
//            System.out.println(group);
            group = group.substring(2, group.length() - 2);
            if (group.contains("||")) {
                String[] split = group.split("\\|\\|");
                System.out.println(Arrays.toString(split));
            } else {
                System.out.println(group);
            }
        }
    }
}