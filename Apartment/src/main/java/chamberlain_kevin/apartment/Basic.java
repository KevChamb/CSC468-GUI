package chamberlain_kevin.apartment;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Basic extends Apartment {
    private int rent;
    private int maintenance;
    private int remodel;
    private int timeSinceRemodel;
    private ArrayList<Floor> floors = new ArrayList<Floor>();

    public Basic(){
        rent = 800;
        maintenance = 450;
        remodel = 4000;
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
