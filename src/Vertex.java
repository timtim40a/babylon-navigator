import java.util.ArrayList;

public class Vertex {

    private String name;

    private int latitude;

    private int longitude;

    private ArrayList<Edge> adjacentEdges = new ArrayList<>();

    private double distanceFromStart;

    private boolean visited;

    private Vertex previousVertex;

    public Vertex(String name){
        this.name = name;
    }

    public Vertex(String name, int latitude, int longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.adjacentEdges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAdjacency(Edge e) {
        adjacentEdges.add(e);
    }

    public ArrayList<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setAdjacentEdges(ArrayList<Edge> adjacentEdges) {
        this.adjacentEdges = adjacentEdges;
    }

    public void setDistanceFromStart(double distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    public double getDistanceFromStart() {
        return distanceFromStart;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public void printNodes() {
        if (previousVertex != null) {
            previousVertex.printNodes();
            System.out.println("|\n|  -  distance: " + (this.distanceFromStart - previousVertex.getDistanceFromStart()) + "\n|\n" + "0 " + this.getName() + " X:" + this.latitude + " Y:" + this.longitude);
        } else {
            System.out.println("0 " + this.getName() + " X:" + this.latitude + " Y:" + this.longitude);
        }
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", adjacentEdges=" + adjacentEdges +
                '}';
    }
}
