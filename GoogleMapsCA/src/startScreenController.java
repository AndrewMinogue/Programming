import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class startScreenController {

    private GraphNode startPointNode;
    private CostedPath costedPath;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField destPoint;

    @FXML
    private TextField startPoint;


  @FXML
    void loadRoute(ActionEvent event) {
        for (String start : Main.graphNodeDati) {
            if (start.equals(startPoint.getText())) {
                for (GraphNode thatOne : Main.graphNodes) {
                    if (thatOne.getData().equals(start)) {
                        System.out.println("Printing all path permutation");

                        List<List<GraphNode>> allPaths = DepthFirstSearch.findAllPathsDepthFirst(thatOne, null, destPoint);
                        int pCount = 1;
                        for (List<GraphNode> p : allPaths) {
                            System.out.println("\nPath " + (pCount++) + "\n--------");
                            for (GraphNode n : p)
                                System.out.println(n.data);
                        }
                    }
                }
            }
        }
    }

    @FXML
    void multipleRoute(ActionEvent event) {
        System.out.println(startPoint.getText());
        System.out.println(destPoint.getText());

        for (String start : Main.graphNodeDati) {
            if (start.equals(startPoint.getText())) {
                for (GraphNode thatOne : Main.graphNodes) {
                    if (thatOne.getData().equals(start)) {
                        System.out.println("The quickest path from " + start + " to " + destPoint.getText());
                        System.out.println("using Dijkstra's algorithm:");
                        System.out.println("-------------------------------------");
                        CostedPath.findCheapestPathDijkstra(thatOne, destPoint.getText());
                        System.out.println(CostedPath.findCheapestPathDijkstra(thatOne, destPoint.getText()).pathCost);
                        System.out.println("Route taken is;");
                        for (GraphNode p : CostedPath.findCheapestPathDijkstra(thatOne, destPoint.getText()).pathList) {
                            System.out.println("\n" + p.getData());
                        }
                        //System.out.println("\nThe total path cost is: "+ );
                    }
                    }
                }
            }
        }

/*    @FXML
    void singleRoute(ActionEvent event) {
        DepthFirstSearch.findAll1();
    }*/

    @FXML
    void initialize() {
        assert destPoint != null : "fx:id=\"destPoint\" was not injected: check your FXML file 'startScreen.fxml'.";
        assert startPoint != null : "fx:id=\"startPoint\" was not injected: check your FXML file 'startScreen.fxml'.";


    }

}
