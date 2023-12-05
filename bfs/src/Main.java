/*
ID: cici.zh1
LANG: JAVA
TASK: Taskname
*/

import java.io.*;
import java.util.*;


class Node
{
    String name;

    Node (String n )
    {
      name = n;
    }
}
class informationOfNode
{
    List<String> pathList = new ArrayList<>();
    String name;

    informationOfNode (String n)
    {
        name = n;
    }

    int depth;
}


class main
{
    static Map<String,Set<Node>> edgeMap = new HashMap<>();

    static Set<Node> findChildren (String n )
    {
       return edgeMap.get(n);
    }

    public static void main(String[] args)
    {

        Node cab = new Node("CAB");
        Node car = new Node("CAR");
        Node cat = new Node("CAT");
        Node bar = new Node("BAR");
        Node bat = new Node("BAT");
        Node mat = new Node("MAT");

        edgeMap.put("CAB",new HashSet<>());
        edgeMap.put("CAR",new HashSet<>());
        edgeMap.put("CAT",new HashSet<>());
        edgeMap.put("BAR",new HashSet<>());
        edgeMap.put("BAT",new HashSet<>());
        edgeMap.put("MAT",new HashSet<>());

        edgeMap.get("CAB").add(car);
        edgeMap.get("CAB").add(cat);
        edgeMap.get("CAR").add(cat);
        edgeMap.get("CAR").add(bar);
        edgeMap.get("BAR").add(bat);
        edgeMap.get("CAT").add(bat);
        edgeMap.get("CAT").add(mat);
        edgeMap.get("MAT").add(bat);

        Queue<informationOfNode> whatQueue = new ArrayDeque<>();

        informationOfNode nodePath = new informationOfNode("CAR");
        nodePath.pathList.add("CAR");
        whatQueue.add(nodePath);


        while (!whatQueue.isEmpty())
        {
             informationOfNode current  = whatQueue.poll();


            if (current.name.equals("BAT"))
            {
                int index = 0;
                for (; index < current.pathList.size() - 1; ++index) {
                    System.out.print(current.pathList.get(index));
                    System.out.print(",");
                }
                System.out.print(current.pathList.get(index));
                System.out.println();

            }


            for (Node n : findChildren(current.name))
            {
                List<String> tempt = new ArrayList<>(current.pathList);
                tempt.add(n.name);

                informationOfNode newNode = new informationOfNode(n.name);
                newNode.pathList.addAll(tempt);

                whatQueue.add(newNode);
            }
        }

    }
}