import java.util.List;
import java.util.stream.IntStream;

/**
 * Граф, состоящий из островов, некоторые из которых связаны мотами.
 */
public class Graph {

    /**
     * Массив вертиц, представляющих острова́.
     * Изменение их количества не предполагается в жизни графа.
     */
    Vertex[] vertices;

    public Graph(int V) {
        vertices = new Vertex[V];
        IntStream.range(0, V).forEach(i -> vertices[i] = new Vertex());
    }


    Graph add_edge(int a, int b) {
        vertices[a].add(b);
        vertices[b].add(a);
        return this;
    }


    List<Integer> adjacent(int vertexIndex) {
        return vertices[vertexIndex].getAdjacents();
    }

//    vertices() {
//        return номера от 0 до V
//    }

    int size() {
        return vertices.length;
    }




}
