
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * EmployeeImportance690
 *
 * 首先选出一个领导者，然后统计他以及所有下属的importance，下属的下属仍然属于领导者的下属
 * 递归求和，要设置全局变量
 * @author lirongqian
 * @since 2017/11/23
 */
public class EmployeeImportance690 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,5, Arrays.asList(2,3)));
        employees.add(new Employee(2,3, Arrays.asList(4)));
        employees.add(new Employee(3,4, new ArrayList<>()));
        employees.add(new Employee(4,1, new ArrayList<>()));
        System.out.println(getImportance1(employees, 1));
    }

    static int total = 0;
    public static int getImportance(List<Employee> employees, int id) {
        // 找出领导者
        Employee manager = employees.stream().filter(e -> e.id == id).collect(Collectors.toList()).get(0);
        total += manager.importance;
        // 递归算出所有下级的importance
        manager.subordinates.forEach(subId -> getImportance(employees, subId));
        return total;
    }

    public static int getImportance1(List<Employee> employees, int id) {
        int len = employees.size();
        Employee manager = new Employee();
        for (int i = 0; i < len; i++) {
            if (employees.get(i).id == id) {
                manager = employees.get(i);
                total += manager.importance;
            }
        }
        for (int i = 0; i < manager.subordinates.size(); i++) {
            getImportance1(employees, manager.subordinates.get(i));
        }
        return total;
    }

    static class Employee {
        /**
         * It's the unique id of each node;
         *  unique id of this employee
          */
        public int id;
        /**
         * the importance value of this employee
          */
        public int importance;
        /**
         * the id of direct subordinates
          */
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        public Employee() {
        }
    }
}