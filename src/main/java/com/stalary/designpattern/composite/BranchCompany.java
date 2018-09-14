/**
 * @(#)BranchCompany.java, 2018-09-12.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * BranchCompany
 *
 * @author lirongqian
 * @since 2018/09/12
 */
public class BranchCompany extends Company {

    private List<Company> departments;

    public BranchCompany(String name) {
        super(name);
        departments = new ArrayList<>();
    }

    @Override
    public void addCompany(Company company) {
        departments.add(company);
    }

    @Override
    public void deleteCompany(Company company) {
        departments.remove(company);
    }

    @Override
    public void show() {
        System.out.println(departments);
    }

}