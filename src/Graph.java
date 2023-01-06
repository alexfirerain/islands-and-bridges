import java.util.Arrays;
import java.util.List;

/**
 * Граф, состоящий из островов, некоторые из которых связаны мотами.
 */
public class Graph {

    /**
     * Массив вертиц, представляющих острова́.
     * Изменение их количества не предполагается в жизни графа.
     */
    Vertex[] vertices_info;

    public Graph(int V) {
        vertices_info = new Vertex[V];
        Arrays.fill(vertices_info, new Vertex());
    }


    void add_edge(int a, int b) {
        vertices_info[a].add(b);
        vertices_info[b].add(a);
    }


    List<Integer> adjacent(int vertexIndex) {
        return vertices_info[vertexIndex].getAdjacents();
    }

    vertices() {
        return номера от 0 до V
    }

    int size() {
        return vertices_info.length;
    }




}
