public class GraphLink {

    private GraphNode sourceNode;
    public GraphNode destNode; //Could also store source node if required
    public int cost,speed; //Other link attributes could be similarly stored

    public GraphNode getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(GraphNode sourceNode) {
        this.sourceNode = sourceNode;
    }

    //Setters4
    public void setDestNode(GraphNode destNode) {
        this.destNode = destNode;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSpeed(int speed) {
        this.cost = speed;
    }
    //Getters
    public GraphNode getDestNode() {
        return destNode;
    }

    public int getCost() {
        return cost;
    }

    public int getSpeed() {
        return speed;
    }

    public GraphLink(GraphNode sourceNode, GraphNode destNode,int cost, int speed) {
        this.setSourceNode(sourceNode);
        this.setDestNode(destNode);
        this.setCost(cost);
        this.setSpeed(speed);
    }
}