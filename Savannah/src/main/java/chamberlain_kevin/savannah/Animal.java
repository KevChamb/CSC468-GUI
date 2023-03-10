package chamberlain_kevin.savannah;

/***********************************************************************************************
 * @author Kevin Chamberlain
 * The base class for all animal instances
 **********************************************************************************************/
public class Animal implements Cloneable {

    protected int health;
    protected int longevity;
    protected String name;
    protected String abrv;
    protected String color;
    //protected Boolean checked;

    /***********************************************************************************************
     * Funciton passes on to individual animals
     **********************************************************************************************/
    public void newDay(){}

    /***********************************************************************************************
     * A getter for health
     **********************************************************************************************/
    public int getHealth(){ return health; }

    /***********************************************************************************************
     * A getter for name
     **********************************************************************************************/
    public String getName() { return name; }

    /***********************************************************************************************
     * A getter for abbreviations
     **********************************************************************************************/
    public String getAbrv(){return abrv;}

    /***********************************************************************************************
     * A getter for color
     **********************************************************************************************/
    public String getColor(){
        return color;
    }

}
