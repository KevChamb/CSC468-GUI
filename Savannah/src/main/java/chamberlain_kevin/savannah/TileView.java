package chamberlain_kevin.savannah;

import javafx.scene.control.Button;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/***************************************************************************************************
 * @author Kevin Chamberlain
 * TileView class
 **************************************************************************************************/
public class TileView extends Button implements PropertyChangeListener{
    private int iNum;
    private int jNum;
    private Tile tile;

    /***************************************************************************************************
     * A Basic Constructor for TileView
     **************************************************************************************************/
    public TileView(int i, int j){
        iNum = i;
        jNum = j;
        setText("N:0");
        tile = new Tile();
        tile.setSubject(this);
    }


    /***************************************************************************************************
     * Observer
     **************************************************************************************************/
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) { //GRADING: OBSERVE
        Animal animal = (Animal) propertyChangeEvent.getNewValue();

        setText(animal.getAbrv() + ": " + String.valueOf(animal.getHealth()));
        setStyle(animal.getColor());

    }

    /***************************************************************************************************
     * A getter for tile
     **************************************************************************************************/
    public Tile getTile() {return tile;}

    /***************************************************************************************************
     * A getter for columns
     **************************************************************************************************/
    public int getCol(){return jNum;}

    /***************************************************************************************************
     * A getter for rows
     **************************************************************************************************/
    public int getRow(){return iNum;}

}
