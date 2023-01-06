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
    static int[] marks;
    /**
     * Список, в позициях которого, начиная со второй,
     * хранятся размеры групп с соответствующим номером.
     */
    static List<Integer> mark_sizes;

    static {
        archipelago = new Graph(6)
                .add_edge(0, 1)
                .add_edge(1, 2)
                .add_edge(3, 4);

        marks = new int[archipelago.size()];

        mark_sizes = new ArrayList<>((int) Math.ceil(Math.sqrt(archipelago.size())) + 1);

        mark_sizes.add(0);
    }

    public static void main(String[] args) {


        calc_paths(archipelago);



        for (int i = 0; i < archipelago.size(); i++)
            System.out.printf("С острова №%d достижимо %d островов.%n", i, mark_sizes.get(marks[i]) - 1);
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
        for (Integer adjacent : graph.adjacent(vertex))
            if (marks[adjacent] == 0)
                size += defineSize(graph, adjacent, mark, marks);
        return size;
    }

    static void calc_paths(Graph graph) {
//        marks = [V нулей]
//        mark_sizes = [0]
        for (int v = 0; v < archipelago.size(); v++)
            if (marks[v] == 0) {
                int next_mark = mark_sizes.size();
                int size = defineSize(graph, v, next_mark, marks);
                mark_sizes.add(size);
            }
    }
}