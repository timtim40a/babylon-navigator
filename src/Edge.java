import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Edge implements Comparable<Edge>{

    private final Node startNode;
    private final Node endNode;
    private final double weight;

    public Edge(Node givenNd1, Node givenNd2) {
        startNode = givenNd1;
        endNode = givenNd2;
        weight = sqrt(pow(endNode.getX() - startNode.getX(), 2) + pow(endNode.getY() - startNode.getY(), 2));
    }

    @Override
    public int compareTo(Edge p) {
        return Double.compare(this.weight, p.weight);
    }

    public double getWeight() {
        return weight;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }


}
