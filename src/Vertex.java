import java.util.HashSet;
import java.util.Set;

public class Vertex {

    Set<Integer> adjacents = new HashSet<>();

    void add(int v) {
        adjacents.add(v);
    }

    Set<Integer> getAdjacents() {
        return adjacents;
    }

}
