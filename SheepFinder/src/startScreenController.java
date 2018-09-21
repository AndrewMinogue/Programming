import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;



import javax.imageio.ImageIO;


public class startScreenController {

    private static File f;
    private int[] imageArray;



    @FXML
    private Label sheepEstimate;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem addImage;

    @FXML
    private ImageView imageview;

    @FXML
    private BufferedImage pic;

    @FXML
    private Slider sliderSheep;

    //Iterative version of find
    public static int find(int[] a, int id) {
        return a[id]==id ? id : find(a,a[id]);
    }
    //union method
    public static void union(int[] a, int p, int q) {
        a[find(a,q)]=find(a,p); //The root of q is made reference the root of p
    }
    /*add image method
    *
    * includes a file chooser set to a picture directory
    * */
    public void addImage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\Andrew\\Pictures"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.JPEG", "*.PNG", "*.JPG"));
        f = fc.showOpenDialog(null);

        if (f != null) {
            {
                try {
                    BufferedImage pic = ImageIO.read(f);
                    imageview.setImage(SwingFXUtils.toFXImage(pic, null));
                    imageview.setPreserveRatio(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* Method to change images to black and white
     *
     * sets all images that are not white to 0 which is black
     *
     * Also prints out all of the white values setting them to themselce
      * */
    @FXML
    private void changeToBlackAndWhite () {
            try {
                 pic = ImageIO.read(f);
                for (int w = 0; w < pic.getWidth(); w++) {
                    for (int h = 0; h < pic.getHeight(); h++) {

                        int rgb = pic.getRGB(w, h);
                        int iRed = rgb >> 16 & 0xff;
                        int iGreen = rgb >> 8 & 0xff;
                        int iBlue = rgb & 0xff;
                        
                        if ((iGreen < sliderSheep.getValue()) && (iRed < sliderSheep.getValue()) && (iBlue < sliderSheep.getValue())) {
                            pic.setRGB(w, h, 0);
                        }else{
                            pic.setRGB(w,h,0xffffff);
                        }
                    }
                }
                imageview.setImage(SwingFXUtils.toFXImage(pic, null));
                imageview.setPreserveRatio(true);

            } catch (Exception e) {
                System.out.println(e);
            }
            imageArray = new int[(pic.getWidth() * pic.getHeight())];
            System.out.println(imageArray.length);

            for (int h = 0;  h < pic.getHeight(); h++){
                for (int w = 0; w < pic.getWidth(); w++)
                {
                    int argb = SwingFXUtils.toFXImage(pic, null).getPixelReader().getArgb(w,h);
                        imageArray[ w + h * pic.getWidth()] = argb != -16777216 ? w + h * pic.getWidth(): 0 ;

                }
            }
            for( int i = 0; i< imageArray.length; i++)
            {
                if (imageArray[i] > 0){
                    imageArray[i] = i;
                    System.out.println("The value of " + i + " is " + imageArray[i]);

                }

            }
        }

        /* Count sheep method which also contains
          * the union find method
           *   which links all white pixels back to the parent of the set
           *   it also contains a for loop which finds the parent node
           *   of each set and lists the length of that array out getting the total amount of sheep*/
        @FXML
        private void countSheep() {
            ArrayList<Integer> sheepCounter = new ArrayList<>();
            for (int i = 0; i < imageArray.length; i++) {
                //union find
                if (imageArray[i] > 0 && imageArray[i+1] > 0 || imageArray[i] > 0 && imageArray[i + pic.getWidth()] > 0) {
                    if (imageArray[i] > 0 && imageArray[i + 1] > 0) {
                        union(imageArray, imageArray[i], i + 1);
                    }
                    System.out.println("The root of " + i + " is " + find(imageArray, i));
                    if (imageArray[i] > 0 && imageArray[i + pic.getWidth()] > 0) {
                        union(imageArray, imageArray[i], i + pic.getWidth());
                    }
                }
                if(imageArray[i] > 0)
                System.out.println("The root of " + i + " is " + find(imageArray, i));
            }

            int rootNode;
            for (int nodes : imageArray) {
                rootNode = find(imageArray, nodes);
                if((!sheepCounter.contains(rootNode)) && (rootNode != 0)) {
                    sheepCounter.add(rootNode);
                }
            }
            System.out.println(sheepCounter.size());
            sheepEstimate.setText("Estimate of Sheep = " + Integer.toString(sheepCounter.size()));
            sheepEstimate.setVisible(true);



        }


        //standard deviation
        @FXML
         private void SheepBoundries()
        {

        }


    @FXML
    void initialize() {
        assert addImage != null : "fx:id=\"addImage\" was not injected: check your FXML file 'startScreen.fxml'.";
        assert imageview != null : "fx:id=\"image\" was not injected: check your FXML file 'startScreen.fxml'.";
        assert sheepEstimate != null : "fx:id=\"SheepEstimate\" was not injected: check your FXML file 'startScreen.fxml'.";
        assert sliderSheep != null : "fx:id=\"sliderSheep\" was not injected: check your FXML file 'startScreen.fxml'.";
    }

}






