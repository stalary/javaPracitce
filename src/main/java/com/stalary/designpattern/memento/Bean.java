/**
 * @(#)Bean.java, 2018-09-14.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.memento;

import java.time.LocalDateTime;

/**
 * Bean
 *
 * @author lirongqian
 * @since 2018/09/14
 */
public class Bean {

    /**
     * 提交标签
     */
    private String tag;

    /**
     * 提交时间
     */
    private LocalDateTime time;

    /**
     * 提交代码内容
     */
    private String code;

    public String getTag() {
        return tag;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getCode() {
        return code;
    }

    public Bean(String tag, LocalDateTime time, String code) {
        this.tag = tag;
        this.time = time;
        this.code = code;
    }
}