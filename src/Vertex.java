import java.util.ArrayList;
import java.util.List;

public class Vertex {

    List<Integer> adjacents = new ArrayList<>();

    void add(int v) {
        adjacents.add(v);
    }

    List<Integer> getAdjacents() {
        return adjacents;
    }

}
