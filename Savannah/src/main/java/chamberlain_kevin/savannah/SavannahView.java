package chamberlain_kevin.savannah;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

/***************************************************************************************************
 * @author Kevin Chamberlain
 * The Savannah view, responsilbe for creating the savannah's... view, or the grid of buttons that
 * represents the savannah.
 **************************************************************************************************/public class SavannahView extends GridPane {

    int size = 3;
    int died;
    Controller ctrl;
    Savannah savannah;
    ArrayList<TileView> animalList;

    /***************************************************************************************************
     * The Basic constructor for SavannahView
     **************************************************************************************************/
    SavannahView(Controller controller, Savannah sav){
        savannah =sav;
        ctrl = controller;
   }

    /***************************************************************************************************
     * Resizes the savannah grid pane
     **************************************************************************************************/
    public void resize(int i, int j, Savannah sav){
        savannah = sav;
        this.getChildren().clear();
        this.getRowConstraints().clear();
        this.getColumnConstraints().clear();
        size = i;
        this.setModel(savannah);
    }

    /***************************************************************************************************
     * Creates the grid of buttons for the savannah
     **************************************************************************************************/
    public void setModel(Savannah sav)
    {
        animalList = new ArrayList<TileView>();
        died = 0;

        RowConstraints rC = new RowConstraints();
        rC.setPercentHeight(100);
        ColumnConstraints cC = new ColumnConstraints();
        cC.setPercentWidth(100);

        for(int i =0; i < size; i++){
            this.getRowConstraints().add(rC);
            this.getColumnConstraints().add(cC);
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                TileView animal = new TileView(i, j);
                animal.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
                animal.addEventFilter(MouseEvent.MOUSE_CLICKED, ctrl.GridButtons());
                animalList.add(animal);
                add(animal, i, j);
            }
        }
    }

    /***************************************************************************************************
     * A getter for the TileView
     **************************************************************************************************/
    public TileView getTileView(int row, int col) {return animalList.get(row*size + col);}
}
