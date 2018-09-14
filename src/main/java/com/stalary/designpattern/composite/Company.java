/**
 * @(#)Company.java, 2018-09-12.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.composite;

/**
 * Company
 *
 * @author lirongqian
 * @since 2018/09/12
 */
public abstract class Company {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void addCompany(Company company);

    public abstract void deleteCompany(Company company);

    public abstract void show();

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}