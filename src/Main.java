import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Граф, состоящий из вершин, некоторые из которых могут быть связаны.
     */
    static Graph archipelago;
    /**
     * Массив, где число в ячейке сообщает номер группы,
     * к которой принадлежит вершина с тем номером, что у ячейки.
     */
    static int[] groupIndices;
    /**
     * Список, в позициях которого, начиная со второй,
     * хранятся размеры групп с соответствующим номером.
     */
    static List<Integer> groupSizes;

    public static void main(String[] args) {
        archipelago = new Graph(6)
                .add_edge(0, 1)
                .add_edge(1, 2)
                .add_edge(3, 4);

        calcPaths(archipelago);

        archipelago.vertices().forEach(i ->
                System.out.printf("С острова №%d по мостам достижимо островов: %d%n",
                            i, groupSizes.get(groupIndices[i]) - 1));
    }

    /**
     * Определяет размер данной компоненты связанности.
     * @param graph граф, в котором анализируются компоненты.
     * @param vertex номер вершины, с которой начинается обход.
     * @param mark  номер группы связанности, которая измеряется.
     * @param marks  маска, отражающая, к группе с каким номером принадлежит вершина.
     * @return  размер компоненты связанности.
     */
    static int defineSize(Graph graph, int vertex, int mark, int[] marks) {
        int size = 1;
        marks[vertex] = mark;
        size += graph.adjacent(vertex).stream()
                .filter(adjacent -> marks[adjacent] == 0)
                .mapToInt(adjacent -> defineSize(graph, adjacent, mark, marks))
                .sum();
        return size;
    }

    static void calcPaths(Graph graph) {

        groupIndices = new int[graph.size()];
        groupSizes = new ArrayList<>((int) Math.ceil(Math.sqrt(graph.size())) + 1);
        groupSizes.add(0);

        archipelago.vertices()
                .filter(v -> groupIndices[v] == 0)
                .forEach(v -> groupSizes.add(
                        defineSize(graph, v, groupSizes.size(), groupIndices)
                        )
                );
    }
}