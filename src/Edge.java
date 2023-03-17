import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Edge {
    private final Vertex startVertex;
    private final Vertex endVertex;
    private final double weight;
    private String name;

    public Edge(Vertex startVertex, Vertex endVertex, String name) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.name = name;
        this.startVertex.addAdjacency(this);
        this.weight = sqrt(pow(endVertex.getLatitude() - startVertex.getLatitude(), 2) + pow(endVertex.getLongitude() - startVertex.getLongitude(), 2));
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }



    @Override
    public String toString() {
        return "Edge{" +
                "name='" + name + '\'' +
                '}';
    }
}
