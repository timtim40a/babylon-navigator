import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node[] nodes;
    @Before
    public void setup(){
        node1 = new Node("A", 0, 0);
        node2 = new Node("B", 1, 2);
        node3 = new Node("C", 2, 2);
        node4 = new Node("D", 4, 3);
        nodes = new Node[4];
        nodes[0] = node2;
        nodes[1] = node3;
        nodes[2] = node4;
    }

    @Test
    public void makePair() {
        node1.makeNeighbours(node2);
        node1.makeNeighbours(node3);
        node1.makeNeighbours(node4);
        assertArrayEquals(node1.neighbours, nodes);

        assertEquals(node2.getNeighbours()[0], node1);
    }
}