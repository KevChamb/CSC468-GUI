package chamberlain_kevin.savannah;

/***************************************************************************************************
 * @author Kevin Chamberlain
 * Cheetah class
 **************************************************************************************************/
public class Cheetah extends Animal{

    /**********************************************************************************************
     * Basic Constructor for the Cheetah
     *********************************************************************************************/
    public Cheetah(){
        health = 10;
        longevity = 1;
        name = "Cheetah";
        abrv = "C";
        color = "-fx-background-color:Orange;";
    }

    /**********************************************************************************************
     * Updates health after clicking "New Day"
     *********************************************************************************************/
    public void newDay() {
        health = health - longevity;

    }
}