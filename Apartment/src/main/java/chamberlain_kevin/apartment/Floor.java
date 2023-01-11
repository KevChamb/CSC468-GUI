package chamberlain_kevin.apartment;

import java.util.ArrayList;

public class Floor {
    private ArrayList<Apartment> apartments = new ArrayList<Apartment>();

    void increaseRent(int amt){
        for(Apartment apartment : apartments){
            apartment.increaseRent(amt);
        }
    }
    void newMonth(){
        for(Apartment apartment : apartments){
            apartment.newMonth();
        }
    }
    int getRentToCollect(){
        int totalRent = 0;
        for(Apartment apartment : apartments){
            totalRent += apartment.getRent();
        }
        return totalRent;
    }
    int getMaintCost(){
        int totalCost = 0;
        for(Apartment apartment : apartments){
            totalCost += apartment.getMaintenance();
        }
        return totalCost;
    }
    int getFillCount(){
        int fillCount = 0;
        for(Apartment apartment : apartments){
            fillCount += apartment.getFill();
        }
        return fillCount;
    }
    void buildFloor(){
        Empty e = new Empty();
        apartments.add(e);
    }
    void buildBasic(int aptIndex){
        Basic b = new Basic();
        apartments.set(aptIndex, b);
    }
    void buildPent(int aptIndex){
        Penthouse p = new Penthouse();
        apartments.set(aptIndex, p);
    }
    ArrayList<Apartment> getApartments(){
        return this.apartments;
    }
}

