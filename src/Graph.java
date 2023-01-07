import java.util.Set;
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
        vertices().forEach(i -> vertices[i] = new Vertex());
    }


    Graph add_edge(int a, int b) {
        vertices[a].add(b);
        vertices[b].add(a);
        return this;
    }


    Set<Integer> adjacent(int vertexIndex) {
        return vertices[vertexIndex].getAdjacents();
    }

    IntStream vertices() {
        return IntStream.range(0, size());
    }

    int size() {
        return vertices.length;
    }




}
