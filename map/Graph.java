package map;

//图
public class Graph {
    private Vertex[] vertex;
    private int currentSize;
    // 邻接矩阵
    private int[][] adjMat;

    public Graph(int size) {

        vertex = new Vertex[size];
        adjMat = new int[size][size];
    }

    public void addVertex(Vertex v) {
        vertex[currentSize++] = v;

    }
}