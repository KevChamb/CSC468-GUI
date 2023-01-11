package chamberlain_kevin.apartment;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Penthouse extends Apartment {
    private int rent;
    private int maintenance;
    private int remodel;
    private int timeSinceRemodel;
    private ArrayList<Floor> floors = new ArrayList<Floor>();

    public Penthouse(){
        rent = 2000;
        maintenance = 1000;
        remodel = 10000;
        timeSinceRemodel = 0;
    }

    @Override
    void increaseRent(int amt){
        rent = rent + amt;
    }
    @Override
    void newMonth(){
        timeSinceRemodel += 1;
    }
    @Override
    int getMaintenance(){
        return this.maintenance;
    }
    @Override
    int getRemodel(){
        return this.remodel;
    }
    @Override
    int getTimeSinceRemodel(){
        return this.timeSinceRemodel;
    }
    @Override
    int getRent(){
        return this.rent;
    }
    @Override
    int getFill(){
        return 1;
    }
}
