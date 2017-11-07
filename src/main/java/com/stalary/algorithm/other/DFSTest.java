package com.stalary.algorithm.other;

import java.util.Stack;

/**
 * @Author:Stalary
 * @Description:图的深度优先搜索-递归与非递归的demo
 * @Date Created in 2017/10/8
 */
public class DFSTest {

    // 存储节点信息
    private char[] vertices;

    // 存储边信息（邻接矩阵）
    private int[][] edge;

    // 图的节点数
    private int vexnum;

    // 记录节点是否已被遍历
    private boolean[] visited;

    // 初始化
    public DFSTest(int n) {
        vexnum = n;// 初始化结点数为n
        vertices = new char[n];// 存储n个结点
        edge = new int[n][n];// 存储边的信息
        visited = new boolean[n];// 记录结点是否已被访问
        for (int i = 0; i < vexnum; i++) {
            for (int j = 0; j < vexnum; j++) {
                edge[i][j] = 0;// 初始化所有边的连接，0时为未连通，1时为已连通
            }
        }
    }

    // 添加边(无向图) 连通则标记为1
    public void addEdge(int i, int j) {
        // 边的头尾不能为同一节点
        if (i == j) return;// 两个相同结点无法连通

        edge[i][j] = 1;// 关联是双向的，将两个结点进行连通
        edge[j][i] = 1;
    }

    // 设置节点集
    public void setVertices(char[] vertices) {
        this.vertices = vertices;
    }

    // 设置节点访问标记
    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    // 打印遍历节点
    public void visit(int i) {
        System.out.print(vertices[i] + " ");
    }

    // 从第i个节点开始深度优先遍历
    private void traverse(int i) {
        // 标记第i个节点已遍历
        visited[i] = true;
        // 打印当前遍历的节点
        visit(i);

        // 遍历邻接矩阵中第i个节点的直接联通关系
        for (int j = 0; j < vexnum; j++) {
            // 目标节点与当前节点直接联通，并且该节点还没有被访问，递归
            if (edge[i][j] == 1 && !visited[j]) {
                traverse(j);
            }
        }
    }

    // 图的深度优先遍历（递归）
    public void DFSTraverse() {
        // 初始化节点遍历标记
        for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }

        // 从没有被遍历的节点开始深度遍历
        for (int i = 0; i < vexnum; i++) {
            if (!visited[i]) {
                // 若是连通图，只会执行一次
                traverse(i);
            }
        }
    }

    // 图的深度优先遍历（非递归）
    public void DFSTraverse2() {
        // 初始化节点遍历标记
        for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < vexnum; i++) {
            if (!visited[i]) {
                //连通子图起始节点
                s.add(i);
                do {
                    // 出栈
                    int curr = s.pop();

                    // 如果该节点还没有被遍历，则遍历该节点并将子节点入栈
                    if (!visited[curr]) {
                        // 遍历并打印
                        visit(curr);
                        visited[curr] = true;

                        // 没遍历的子节点入栈
                        for (int j = vexnum - 1; j >= 0; j--) {
                            if (edge[curr][j] == 1 && !visited[j]) {
                                s.add(j);
                            }
                        }
                    }
                } while (!s.isEmpty());
            }
        }
    }

    public static void main(String[] args) {
        DFSTest g = new DFSTest(9);
        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        g.setVertices(vertices);

        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(1, 8);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(3, 8);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 0);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(6, 3);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 3);
        g.addEdge(7, 4);
        g.addEdge(7, 6);
        g.addEdge(8, 1);
        g.addEdge(8, 2);
        g.addEdge(8, 3);

        long start1 = System.nanoTime();
        System.out.print("深度优先遍历（递归）：");
        g.DFSTraverse();
        long end1 = System.nanoTime();
        System.out.println("time: " + (end1 - start1));
        System.out.println();

        long start2 = System.nanoTime();
        System.out.print("深度优先遍历（非递归）：");
        g.DFSTraverse2();
        long end2 = System.nanoTime();
        System.out.println("time: " + (end2 - start2));
    }

}
