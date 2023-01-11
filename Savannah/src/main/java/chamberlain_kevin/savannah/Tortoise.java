package chamberlain_kevin.savannah;

/***************************************************************************************************
 * @author Kevin Chamberlain
 * Tortoise class
 **************************************************************************************************/
public class Tortoise extends Animal{

    /**********************************************************************************************
     * Basic Constructor for the Tortoise
     *********************************************************************************************/
    public Tortoise(){
        health = 50;
        longevity = 1;
        name = "Tortoise";
        abrv = "T";
        color = "-fx-background-color:Green;";
    }

    /**********************************************************************************************
     * Updates health after clicking "New Day"
     *********************************************************************************************/
    public void newDay() {
        health = health - longevity;
    }
}
