package chamberlain_kevin.savannah;

/***************************************************************************************************
 * @author Kevin Chamberlain
 * None class
 **************************************************************************************************/
public class None extends Animal{

    /**********************************************************************************************
     * Basic Constructor for the None
     *********************************************************************************************/
    public None(){
        health = 0;
        longevity = 0;
        name = "None";
        abrv = "N";
    }

    public int getHealth(){
        return health;
    }
}
