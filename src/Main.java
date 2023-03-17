import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Vertex> path = new PriorityQueue<>(20, Comparator.comparingDouble(Vertex::getDistanceFromStart));

        Gson gson = new Gson();

        Vertex[] vertices = new Vertex[0];

        try (FileReader vertexReader = new FileReader("jsons/babylonVertices.json")) {
            vertices = gson.fromJson(vertexReader, Vertex[].class);
            for (Vertex vertex : vertices) {
                vertex.setAdjacentEdges(new ArrayList<>());
                System.out.println(vertex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graph graph = new Graph(new ArrayList<>(), new ArrayList<>(), "test");

        for (Vertex vertex: vertices) {
            graph.vertices().add(vertex);
        }

        String[][] edges = new String[0][0];

        try (FileReader edgeReader = new FileReader("jsons/babylonEdges.json")) {
            edges = gson.fromJson(edgeReader, String[][].class);
            for (String[] edgeSet : edges) {
                System.out.println(Arrays.toString(edgeSet));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Vertex vertex: vertices) {
            graph.getVertexNames().put(vertex.getName(), vertex);
        }

        for (int i = 0; i < edges.length; i++) {
            Vertex v1 = graph.vertices().get(i);
            for (int j = 0; j < edges[i].length; j++) {
                Vertex v2 = graph.getVertexNames().get(edges[i][j]);
                Edge e = new Edge(v1, v2, v1.getName() + "-" + edges[i][j]);
                graph.edges().add(e);
            }
            System.out.println(v1);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("From: ");
        String startName = in.nextLine();
        System.out.println("To: ");
        String destinationName = in.nextLine();
        Vertex start = null;
        Vertex destination = null;

        for (Vertex vertex : graph.vertices()) {
            vertex.setDistanceFromStart(2_147_483_647);
            if (Objects.equals(vertex.getName(), startName)) {
                start = vertex;
                start.setDistanceFromStart(0);
            } else if (Objects.equals(vertex.getName(), destinationName)) {
                destination = vertex;
            }
            path.add(vertex);
        }
        if (start == null || destination == null) {
            throw new NoSuchElementException();
        }

        Vertex currentVertex;
        while (!destination.isVisited()) {
            currentVertex = path.remove();
            currentVertex.setVisited();
            for (int i = 0; i < currentVertex.getAdjacentEdges().size(); i++) {
                Edge currentCheck = currentVertex.getAdjacentEdges().get(i);
                if (currentCheck.getWeight() + currentVertex.getDistanceFromStart() < currentCheck.getEndVertex().getDistanceFromStart()) {
                    currentCheck.getEndVertex().setDistanceFromStart(currentCheck.getWeight() + currentVertex.getDistanceFromStart());
                    currentCheck.getEndVertex().setPreviousVertex(currentVertex);
                    path.remove(currentCheck.getEndVertex());
                    path.add(currentCheck.getEndVertex());
                }
            }
        }

        destination.printNodes();
        System.out.println("\nTotal distance: " + destination.getDistanceFromStart());
        pressEnterToContinue();
    }

    private static void pressEnterToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            int temp = System.in.read();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}