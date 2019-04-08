package map;

import java.util.Stack;

import line.MyStack;

//图
public class Graph {
    private Vertex[] vertex;
    private int currentSize;
    // 邻接矩阵
    public int[][] adjMat;

    public MyStack stack = new MyStack();
    private int cur = 0;

    public Graph(int size) {

        vertex = new Vertex[size];
        adjMat = new int[size][size];
    }

    // 添加顶点
    public void addVertex(Vertex v) {
        vertex[currentSize++] = v;

    }

    // 添加两个顶点的边
    public void addEdge(String v1, String v2) {
        // 找出两个结点的下标index1,index2
        int index1 = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(v1)) {
                index1 = i;
                break;
            }
        }
        int index2 = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(v2)) {
                index2 = i;
                break;
            }
        }
        // 将二者邻接矩阵设都为1
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }

    // 深度优先遍历
    public void dfs() {
        // 把第0个设为已访问
        vertex[0].visited = true;
        // 把第0个下标
        stack.push(0);
        System.out.println(vertex[0].getValue());
        out: while (!stack.isEmpty()) {
            for (int i = cur + 1; i < vertex.length; i++) {
                // 二者联通，并且之前没有被访问过
                if (adjMat[cur][i] == 1 && vertex[i].visited == false) {
                    // 把下一个元素压入栈中
                    stack.push(i);
                    vertex[i].visited = true;
                    System.out.println(vertex[i].getValue());
                    continue out;
                }
            }
            // 没有找到，则弹出栈顶元素
            stack.pop();
            // 修改当前位置为栈顶元素位置
            if (!stack.isEmpty()) {
                cur = stack.peek();
            }

        }
    }
}