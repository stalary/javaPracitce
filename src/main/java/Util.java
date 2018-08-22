/**
 * @(#)Util.java, 2018-08-15.
 * <p>
 * Copyright 2018 Stalary.
 */

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Util
 *
 * @author lirongqian
 * @since 2018/08/15
 */
@Slf4j
public class Util {

    private static Map<String, Long> timeStat = Maps.newConcurrentMap();

    public static void start(String name) {
        timeStat.put(name, System.currentTimeMillis());
    }

    public static void end(String name) {
        System.out.println(name + " cost time." + (System.currentTimeMillis() - timeStat.get(name)));
    }
}
