/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quickestPath
{

    public int pathCost=0;
    public int pathSpeed=0;
    public List<GraphNode<?>> pathList = new ArrayList<>();

    public static <T> quickestPath findQuickestPathDijkstra(GraphNode<?> startNode, T lookingfor){
        quickestPath qp=new quickestPath(); //Create result object for cheapest path
        List<GraphNode<?>> encountered=new ArrayList<>(), unencountered=new ArrayList<>(); //Create encountered/unencountered lists
        startNode.nodeValue=0; //Set the starting node value to zero
        unencountered.add(startNode); //Add the start node as the only value in the unencountered list to start
        GraphNode<?> currentNode;
        do{ //Loop until unencountered list is empty
            currentNode=unencountered.remove(0); //Get the first unencountered node (sorted list, so will have lowest value)
            encountered.add(currentNode); //Record current node in encountered list
            if(currentNode.data.equals(lookingfor)){ //Found goal - assemble path list back to start and return it
                qp.pathList.add(currentNode); //Add the current (goal) node to the result list (only element)
                qp.pathSpeed=currentNode.nodeValue;
                qp.pathCost=currentNode.nodeValue; //The total cheapest path cost is the node value of the current/goal node
                while(currentNode!=startNode) { //While we're not back to the start node...
                    boolean foundPrevPathNode=false; //Use a flag to identify when the previous path node is identified
                    for(GraphNode<?> n : encountered) { //For each node in the encountered list...
                        for(GraphLink e : n.adjList) //For each edge from that node...
                            if(e.destNode==currentNode && currentNode.nodeValue-e.cost==n.nodeValue && e.destNode==currentNode && currentNode.nodeValue-e.speed==n.nodeValue ){ //If that edge links to the
                                // current node and the difference in node values is the cost of the edge -> found path node!
                                qp.pathList.add(0,n); //Add the identified path node to the front of the result list
                                currentNode=n; //Move the currentNode reference back to the identified path node
                                foundPrevPathNode=true; //Set the flag to break the outer loop
                                break; //We've found the correct previous path node and moved the currentNode reference
                                //back to it so break the inner loop
                            }
                        if(foundPrevPathNode) break; //We've identified the previous path node, so break the inner loop to continue
                    }
                }
                //Reset the node values for all nodes to (effectively) infinity so we can search again (leave no footprint!)
                for(GraphNode<?> n : encountered) n.nodeValue=Integer.MAX_VALUE;
                for(GraphNode<?> n : unencountered) n.nodeValue=Integer.MAX_VALUE;
                return qp; //The costed (cheapest) path has been assembled, so return it!
            }
            //We're not at the goal node yet, so...
            for(GraphLink e : currentNode.adjList) //For each edge/link from the current node...
                if(!encountered.contains(e.destNode)) { //If the node it leads to has not yet been encountered (i.e. processed)
                    e.destNode.nodeValue=Integer.min(e.destNode.nodeValue, currentNode.nodeValue+e.cost);
                    e.destNode.nodeValue=Integer.min(e.destNode.nodeValue, currentNode.nodeValue+e.speed);//Update the node value at the end
                    //of the edge to the minimum of its current value or the total of the current node's value plus the cost of the edge
                    unencountered.add(e.destNode);
                }
            Collections.sort(unencountered,(n1, n2)->n1.nodeValue-n2.nodeValue); //Sort in ascending node value order
        }while(!unencountered.isEmpty());
        return null; //No path found, so return null
    }




    public static void findRoute()
    {
        List<GraphNode<?>> encountered=new ArrayList<>();
        GraphNode<String> a=new GraphNode<>("Waterford");
        GraphNode<String> b=new GraphNode<>("Kilkenny");
        GraphNode<String> c=new GraphNode<>("Dublin");
        GraphNode<String> d=new GraphNode<>("Cork");
        GraphNode<String> e=new GraphNode<>("Belfast");
        GraphNode<String> f=new GraphNode<>("Galway");
        GraphNode<String> g=new GraphNode<>("Mayo");
        GraphNode<String> h=new GraphNode<>("Kerry");
        a.connectToNodeUndirected(b, 5, 5);
        a.connectToNodeUndirected(c, 9,6);
        b.connectToNodeUndirected(c, 2,8);
        b.connectToNodeUndirected(d, 6,9);
        c.connectToNodeUndirected(e, 5,10);
        d.connectToNodeUndirected(h, 8,4);
        d.connectToNodeUndirected(g, 9,3);
        e.connectToNodeUndirected(g, 3,3);
        e.connectToNodeUndirected(f, 7,6);
        f.connectToNodeUndirected(g, 6,11);
        g.connectToNodeUndirected(h, 2,2);



        System.out.println("The quickest path from Waterford to Kerry");
        System.out.println("using Dijkstra's algorithm:");
        System.out.println("-------------------------------------");
        quickestPath qp= quickestPath.findQuickestPathDijkstra(a,"Kerry");
        for(GraphNode<?> n : qp.pathList)
            System.out.println(n.data);
        System.out.println("\nThe total path cost is: "+ qp.pathCost);
    }
}
*/
