package com.stalary.algorithm.algorithmbook;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/10/3
 */
public class StackEvaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Scanner in = new Scanner(System.in);
        while(true) {
            String s = in.next();
            if(s.equals("=")) {
                System.out.print("计算结果为: ");
                break;
            } else if(s.equals("(")) {

            } else if(s.equals("+")) {
                ops.push(s);
            } else if(s.equals("-")) {
                ops.push(s);
            } else if(s.equals("*")) {
                ops.push(s);
            } else if(s.equals("/")) {
                ops.push(s);
            } else if(s.equals("sqrt")) {
                ops.push(s);
            } else if(s.equals(")")) {//遇到)即开始计算
                String op = ops.pop();
                Double v = vals.pop();
                if(op.equals("+")) {
                    v = vals.pop() + v;
                } else if(op.equals("-")) {
                    v = vals.pop() - v;
                } else if(op.equals("*")) {
                    v = vals.pop() * v;
                } else if(op.equals("/")) {
                    v = vals.pop() / v;
                } else if(op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);//将计算结果加上栈中
            } else {
                vals.push(Double.parseDouble(s));//如果不是运算符也不是括号，作为值压入栈中
            }
        }
        System.out.println(vals.pop());
    }
}
