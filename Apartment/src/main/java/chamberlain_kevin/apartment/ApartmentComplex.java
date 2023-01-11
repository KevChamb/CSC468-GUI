package chamberlain_kevin.apartment;

import java.util.ArrayList;

public class ApartmentComplex {
    private int currMonth;
    private int funds;
    private ArrayList<Floor> floors;

    public ApartmentComplex(){
        currMonth = 0;
        funds = 100000;
        floors = new ArrayList<Floor>();
        Floor e1 = new Floor();
        Floor e2 = new Floor();
        Floor e3 = new Floor();
        floors.add(e1);
        floors.add(e2);
        floors.add(e3);
    }
    void increaseRent(int amt){
        for(Floor floor : floors){
            floor.increaseRent(amt);
        }
    }
    void newMonth(){
        this.currMonth += 1;
        for(Floor floor : this.floors){
            floor.newMonth();
        }
        this.funds = this.funds + this.getRentToCollect() - this.getMaintTotal();
    }
    int getRentToCollect(){
        int totalRent = 0;
        for(Floor floor : this.floors){
            totalRent += floor.getRentToCollect();
        }
        return totalRent;
    }
    int getMaintTotal(){
        int totalCost = 0;
        for(Floor floor : this.floors){
            totalCost += floor.getMaintCost();
        }
        return totalCost;
    }
    int getFillCount(){
        int fillCount = 0;
        for(Floor floor : this.floors){
            fillCount += floor.getFillCount();
        }
        return fillCount;
    }
    int getCurrMonth(){
        return this.currMonth;
    }
    int getFunds(){
        return this.funds;
    }
    void buildFloor(int floorIndex){
        this.funds -= 20000;
        floors.get(floorIndex).buildFloor();
    }
    void buildBasic(int floorIndex, int aptIndex){
        this.floors.get(floorIndex).buildBasic(aptIndex);
        this.funds = this.funds - this.floors.get(floorIndex).getApartments().get(aptIndex).getRemodel();
    }
    void buildPent(int floorIndex, int aptIndex){
        this.floors.get(floorIndex).buildPent(aptIndex);
        this.funds = this.funds - this.floors.get(floorIndex).getApartments().get(aptIndex).getRemodel();
    }
}

