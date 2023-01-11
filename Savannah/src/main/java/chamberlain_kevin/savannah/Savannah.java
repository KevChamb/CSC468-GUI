package chamberlain_kevin.savannah;

import javafx.scene.control.RadioButton;
import java.beans.PropertyChangeSupport;

/***************************************************************************************************
 * @author Kevin Chamberlain
 * Savannah class
 * This class contains a number of getters and setters for the model as well as facilitating the
 * New Day decrementation, incrementation and passage
 **************************************************************************************************/
public class Savannah {

    private SavannahView savannahView;
    private int size;
    private PropertyChangeSupport[][] subject;
    private int dayCnt;
    private int deadCnt;
    private String which;
    private TileView grid;
    private Tile tile;
    private int filled;
    private String aOv; //add or view

    /**********************************************************************************************
     * Basic Constructor for the Savannah
     *********************************************************************************************/
    public Savannah(){
        this(3);
    }

    /**********************************************************************************************
     * Basic Constructor for the Savannah
     *********************************************************************************************/
    public Savannah(int size){
        dayCnt = 0;
        which = "N";
        deadCnt = 0;
        filled = 0;
        this.size = size;
    }

    /**********************************************************************************************
     * A setter for which animal is which
     *********************************************************************************************/
    public void setWhich(int i, int j, String animal){
        grid = savannahView.getTileView(i,j);
        tile = grid.getTile();
        tile.setAnimal(animal);

        if(tile.getAnimal() != null ){
            if(tile.getAnimal() instanceof None){
                filled = filled;
            }else {
                filled++;
            }
        }
    }

    /**********************************************************************************************
     * A getter for the name
     *********************************************************************************************/
    public String getName(int i, int j){
        grid = savannahView.getTileView(i,j);
        tile = grid.getTile();
        Animal temp = tile.getAnimal();
        if(temp == null){
            return "None";
        }
        return tile.getAnimal().getName();
    }

    /**********************************************************************************************
     * A getter for the health
     *********************************************************************************************/
    public int getHealth(int i, int j){
        grid = savannahView.getTileView(i,j);
        tile = grid.getTile();
        Animal temp = tile.getAnimal();
        if(temp == null){
            return -1;
        }
        return tile.getAnimal().getHealth();
    }

    /**********************************************************************************************
     * A setter for the Radio button
     *********************************************************************************************/
    public void setRadio(RadioButton a){ aOv = a.getText();}

    /**********************************************************************************************
     * A setter for the size
     *********************************************************************************************/
    public void setSize(int num){
        size = num;
        createSavannah();
    }

    /**********************************************************************************************
     * This function is excess code so the program doesn't break
     *********************************************************************************************/
    protected void createSavannah() {

        subject = new PropertyChangeSupport[size][size];
        dayCnt = 0;
        deadCnt = 0;
        filled = 0;

        for (int i =0; i < size; i++){
            for(int j=0; j<size; j++){
//                grid[i][j] = new Tile();
                //subject[i][j] = new PropertyChangeSupport(this);
                //subject[i][j].addPropertyChangeListener(savannahView.getTileView(i,j));
            }
        }
    }

    /**********************************************************************************************
     * A Setter for Savannah View
     *********************************************************************************************/
    public void setDisplay(SavannahView sView){savannahView = sView;}

    /**********************************************************************************************
     * Handles the new day at this level and passes is on to the next
     *********************************************************************************************/
    public void newDay(){
        dayCnt += 1;

        for(int i =0; i <size; i++){
            for(int j=0; j < size; j++){

                grid = savannahView.getTileView(i,j);
                tile = grid.getTile();
                tile.newDay();
               if(tile.getAnimal() != null){
                   if(tile.getAnimal().getHealth() == 0 && tile.getAnimal().getName() != "None"){
                       setWhich(i,j,"Remove");
                       deadCnt ++;
                       filled --;
                   }
               }
            }
        }
    }

    /**********************************************************************************************
     * A getter for the size
     *********************************************************************************************/
     public int getSize(){
        return size;
     }

    /**********************************************************************************************
     * A getter for the days
     *********************************************************************************************/
    public int getDayCount() { return dayCnt; }

    /**********************************************************************************************
     * A getter for the amount of creatures that died
     *********************************************************************************************/
    public int getDied() { return deadCnt;}

    /**********************************************************************************************
     * A getter for the amount of tiles filled
     *********************************************************************************************/
    public int getFilled() {return filled;}

}
