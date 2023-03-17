import java.util.ArrayList;
import java.util.HashMap;

public class Graph implements GraphADT{

    private final ArrayList<Vertex> vertices;
    private final HashMap<String, Vertex> vertexNames;
    private final ArrayList<Edge> edges;

    public Graph(ArrayList<Vertex> vertices, ArrayList<Edge> edges, String name) {
        this.vertices = vertices;
        this.edges = edges;
        this.vertexNames = new HashMap<>();
    }

    @Override
    public Vertex insertVertex(String n) {
        Vertex vertex = new Vertex(n);
        vertices.add(vertex);
        return vertex;
    }

    @Override
    public String removeVertex(Vertex v) {
        vertices.remove(v);
        return v.getName();
    }

    @Override
    public Edge insertEdge(Vertex v, Vertex w, String n) {
        Edge edge = new Edge(v, w, n);
        edges.add(edge);
        return edge;
    }

    @Override
    public String removeEdge(Edge e) {
        edges.remove(e);
        return e.getName();
    }

    @Override
    public Vertex opposite(Edge e, Vertex v) {
        if(e.getStartVertex() == v) { return e.getEndVertex(); }
        else { return e.getStartVertex(); }
    }

    @Override
    public ArrayList<Vertex> vertices() {
        return vertices;
    }

    @Override
    public ArrayList<Edge> edges() {
        return edges;
    }

    @Override
    public boolean areAdjacent(Vertex v, Vertex w) {
        for (Edge edge: edges) {
            if((edge.getStartVertex() == v && edge.getEndVertex() == w) ||
                    (edge.getStartVertex() == w && edge.getEndVertex() == v)){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Edge> incidentEdges(Vertex v) {
        ArrayList<Edge> incidents = new ArrayList<>();
        for (Edge edge: edges) {
            if (edge.getStartVertex() == v || edge.getEndVertex() == v){
                incidents.add(edge);
            }
        }
        return incidents;
    }

    @Override
    public String rename(Vertex v, String n) {
        v.setName(n);
        return n;
    }

    @Override
    public String rename(Edge e, String n) {
        e.setName(n);
        return n;
    }

    public HashMap<String, Vertex> getVertexNames() {
        return vertexNames;
    }

}
