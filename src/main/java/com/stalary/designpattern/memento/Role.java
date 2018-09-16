/**
 * @(#)Role.java, 2018-09-14.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.memento;

import java.time.LocalDateTime;

/**
 * Role
 *
 * @author lirongqian
 * @since 2018/09/14
 */
public class Role {

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

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Role(String tag, LocalDateTime time, String code) {
        this.tag = tag;
        this.time = time;
        this.code = code;
    }

    public Bean setBean() {
        return new Bean(this.tag, this.time, this.code);
    }

    public void recover(Bean bean) {
        this.tag = bean.getTag();
        this.time = bean.getTime();
        this.code = bean.getCode();
    }

    @Override
    public String toString() {
        return "Role{" +
                "tag='" + tag + '\'' +
                ", time=" + time +
                ", code='" + code + '\'' +
                '}';
    }
}