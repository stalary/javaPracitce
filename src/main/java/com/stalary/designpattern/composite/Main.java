/**
 * @(#)Main.java, 2018-09-12.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.composite;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/12
 */
public class Main {

    public static void main(String[] args) {
        Company hangZhouCompany = new BranchCompany("网易杭州");
        hangZhouCompany.addCompany(new ProductDepartment("网易杭州-产品部"));
        hangZhouCompany.addCompany(new TechnologyDepartment("网易杭州-技术部"));
        Company beiJingCompany = new BranchCompany("网易北京");
        beiJingCompany.addCompany(new ProductDepartment("网易北京-产品部"));
        beiJingCompany.addCompany(new TechnologyDepartment("网易北京-技术部"));
        hangZhouCompany.show();
        beiJingCompany.show();
    }
}