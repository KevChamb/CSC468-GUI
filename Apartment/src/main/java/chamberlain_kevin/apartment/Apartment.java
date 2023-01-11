package chamberlain_kevin.apartment;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int rent;
    private int maintenance;
    private int remodel;
    private int timeSinceRemodel;
    private ArrayList<Floor> floors = new ArrayList<Floor>();

    void increaseRent(int amt){
        rent = rent + amt;
    }
    void newMonth(){
        timeSinceRemodel += 1;
    }
    int getMaintenance(){
        return this.maintenance;
    }
    int getRemodel(){
        return this.remodel;
    }
    int getTimeSinceRemodel(){
        return this.timeSinceRemodel;
    }
    int getRent(){
        return rent;
    }
    int getFill(){
        if( this instanceof Empty )
            return 0;
        else
            return 1;
    }
}
