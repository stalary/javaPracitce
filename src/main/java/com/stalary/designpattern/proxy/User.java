/**
 * @(#)User.java, 2018-08-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User
 *
 * @author lirongqian
 * @since 2018/08/26
 */
@Data
@AllArgsConstructor
public class User {

    private Integer id;

    private String username;
}