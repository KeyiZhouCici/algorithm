import java.util.*;
import java.util.prefs.NodeChangeEvent;

class Node {
    String name;

    Node(String n) {
        name = n;
    }
}

class NodeInfo
{
    List<String> path = new ArrayList<>();

    String name;

    NodeInfo(String s) {
        name = s;
    }

    int depth;
}


public class Main {

    static Map<String, Set<Node>> edgeMap = new HashMap<>();

    static Set<Node> findChildrenOfCurrentNodeInfoName(String key) {
        return edgeMap.get(key);
    }

    public static void main(String[] args) {

        Node cab = new Node("CAB");
        Node car = new Node("CAR");
        Node cat = new Node("CAT");
        Node mat = new Node("MAT");
        Node bar = new Node("BAR");
        Node bat = new Node("BAT");

        edgeMap.put("CAB", new HashSet<>());
        edgeMap.put("CAR", new HashSet<>());
        edgeMap.put("CAT", new HashSet<>());
        edgeMap.put("MAT", new HashSet<>());
        edgeMap.put("BAR", new HashSet<>());
        edgeMap.put("BAT", new HashSet<>());

        edgeMap.get("CAB").add(cat);
        edgeMap.get("CAB").add(car);
        edgeMap.get("CAR").add(cat);
        edgeMap.get("CAR").add(bar);
        edgeMap.get("BAR").add(bat);
        edgeMap.get("CAT").add(mat);
        edgeMap.get("CAT").add(bat);
        edgeMap.get("MAT").add(bat);

        /////////////////////////////
        Queue<NodeInfo> q = new ArrayDeque<>();

        NodeInfo ni = new NodeInfo("CAR");
        ni.path.add("CAR");
        q.add(ni);

        while(!q.isEmpty())
        {
            NodeInfo current = q.poll();

            //
            if (current.name.equals("BAT")) {
                System.out.print("Find a path: ");

                int index = 0;
                for (; index < current.path.size() - 1; ++index) {
                    System.out.print(current.path.get(index));
                    System.out.print(",");
                }
                System.out.print(current.path.get(index));
                System.out.println();
            }
            //

            Set<Node> children = findChildrenOfCurrentNodeInfoName(current.name);
            for (Node n : children) {
                List<String> tempPath = new ArrayList<>(current.path);
                tempPath.add(n.name);

                NodeInfo newNi = new NodeInfo(n.name);
                newNi.path = tempPath;

                q.add(newNi);
            }
        }
    }
}