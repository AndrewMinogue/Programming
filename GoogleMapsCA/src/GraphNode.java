import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphNode
{

    public String data;
    public int nodeValue =Integer.MAX_VALUE;

    public  List<GraphLink> adjList=new ArrayList<>(); //Adjacency list now contains link objects = key!
    //Could use any concrete List implementation


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAdjList(List<GraphLink> adjList) {
        this.adjList = adjList;
    }

    public List<GraphLink> getAdjList() {
        return adjList;
    }

    public GraphNode(String data) {
        this.data=data;
    }

    public void connectToNodeUndirected(GraphNode sourceNode, GraphNode destNode,int cost, int speed) {
        adjList.add( new GraphLink(sourceNode, destNode , cost , speed) ); //Add new link object to source adjacency list
        destNode.adjList.add( new GraphLink(destNode, sourceNode, cost , speed) ); //Add new link object to destination adjacency list
    }
}