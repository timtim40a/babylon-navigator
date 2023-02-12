
public class Node {

    private final String name;
    private final int x;
    private final int y;
    Node[] neighbours = new Node[2];
    private Node prevNode = null;
    private double distanceFromStart = 0;
    private int neighAmount = 0;
    private boolean visited = false;

    public Node(String givenName, int gx, int gy) {
        this.name = givenName;
        this.x = gx;
        this.y = gy;
    }

    private void addNeighbour(Node v) {
        if (neighbours.length <= neighAmount){
            Node[] temp = new Node[neighbours.length * 2];
            System.arraycopy(neighbours, 0, temp, 0, neighbours.length);
            neighbours = temp;
        }
        neighbours[neighAmount] = v;
        neighAmount++;
    }

    public void makeNeighbours(Node u) {
        u.addNeighbour(this);
        this.addNeighbour(u);
    }

    public Node[] getNeighbours() {
        return neighbours;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public double getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(double distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    public void makeVisited() {
        this.visited = true;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void printNodes() {
        if (prevNode != null) {
            System.out.println("o - " + this.getName() + "\n|\n|\n|");
            prevNode.printNodes();
        } else {
            System.out.println("o - " + this.getName());
        }
    }


    public int getNeighAmount() {
        return neighAmount;
    }
}
