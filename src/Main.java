import java.util.*;


public class Main {



    public static void main(String[] args) {
        PriorityQueue<Node> path = new PriorityQueue<>(20, Comparator.comparingDouble(Node::getDistanceFromStart));
        Node BAB = new Node("Babylon", 14, 7);
        Node REZ = new Node("Rezeph", 9, 9);
        Node DAM = new Node("Damascus", 8, 7);
        Node JER = new Node("Jerusalem", 7, 6);
        Node MEM = new Node("Memphis", 4, 4);
        Node PAP = new Node("Paphos", 5, 8);
        Node MLD = new Node("Melidu", 9, 11);
        Node TUS = new Node("Tushpa", 12, 12);
        Node ARR = new Node("Arrapha", 13, 10);
        Node ECH = new Node("Echatana", 16, 9);
        Node SUS = new Node("Susa", 16, 7);
        Node TRS = new Node("Tarsus", 6, 10);
        Node AD = new Node("Arabian Desert", 11, 5);

        MEM.makeNeighbours(PAP);
        MEM.makeNeighbours(JER);

        PAP.makeNeighbours(TRS);

        JER.makeNeighbours(PAP);
        JER.makeNeighbours(DAM);
        JER.makeNeighbours(AD);

        DAM.makeNeighbours(AD);
        DAM.makeNeighbours(REZ);

        REZ.makeNeighbours(MLD);
        REZ.makeNeighbours(ARR);
        REZ.makeNeighbours(BAB);

        MLD.makeNeighbours(TUS);
        MLD.makeNeighbours(ARR);
        MLD.makeNeighbours(TRS);

        ARR.makeNeighbours(TUS);
        ARR.makeNeighbours(BAB);
        ARR.makeNeighbours(ECH);

        BAB.makeNeighbours(AD);
        BAB.makeNeighbours(SUS);

        ECH.makeNeighbours(SUS);

        Node[] nodeArray = new Node[13];
        nodeArray[0] = BAB;
        nodeArray[1] = REZ;
        nodeArray[2] = DAM;
        nodeArray[3] = JER;
        nodeArray[4] = MEM;
        nodeArray[5] = PAP;
        nodeArray[6] = MLD;
        nodeArray[7] = TUS;
        nodeArray[8] = ARR;
        nodeArray[9] = ECH;
        nodeArray[10] = SUS;
        nodeArray[11] = TRS;
        nodeArray[12] = AD;

        Scanner in = new Scanner(System.in);
        System.out.println("From: ");
        String startName = in.nextLine();
        System.out.println("To: ");
        String destinationName = in.nextLine();
        Node start = null;
        Node destination = null;

        for (int i = 0; i < 12; i++) {
            nodeArray[i].setDistanceFromStart(2147483647);
            if (Objects.equals(nodeArray[i].getName(), startName)) {
                start = nodeArray[i];
                start.setDistanceFromStart(0);
            } else if (Objects.equals(nodeArray[i].getName(), destinationName)) {
                destination = nodeArray[i];
            }
            path.add(nodeArray[i]);
        }
        if(start == null || destination == null) {
            throw new NoSuchElementException();
        }

        Node currentNode;
        while (!destination.isVisited()) {
            currentNode = path.remove();
            currentNode.makeVisited();
            for (int i = 0; i < currentNode.getNeighAmount(); i++) {
                Edge currentCheck = new Edge(currentNode, currentNode.getNeighbours()[i]);
                if (currentCheck.getWeight() + currentNode.getDistanceFromStart() < currentCheck.getEndNode().getDistanceFromStart()) {
                    currentCheck.getEndNode().setDistanceFromStart(currentCheck.getWeight() + currentNode.getDistanceFromStart());
                    currentCheck.getEndNode().setPrevNode(currentNode);
                    path.remove(currentCheck.getEndNode());
                    path.add(currentCheck.getEndNode());
                }
            }
        }

        destination.printNodes();




    }
}