package chamberlain_kevin;

/***********************************************************************************************
 * @author Riley Kopp
 * Class of goldfish
 **********************************************************************************************/
public class GoldFish extends Fish{
    GoldFish(){
        visited         = false;
        type            = "GoldFish";
        health          = 6;
        hunger          = 0;
        healthLossRate  = 1;
        hungerRate      = 40;
        hungerThreshold = 90;
    }
}
