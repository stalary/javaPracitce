/**
 * @(#)TechnologyDepartment.java, 2018-09-12.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.composite;

/**
 * TechnologyDepartment
 *
 * @author lirongqian
 * @since 2018/09/12
 */
public class TechnologyDepartment extends Company {
    public TechnologyDepartment(String name) {
        super(name);
    }

    @Override
    public void addCompany(Company company) {

    }

    @Override
    public void deleteCompany(Company company) {

    }

    @Override
    public void show() {
        System.out.println(this.getName());
    }
}