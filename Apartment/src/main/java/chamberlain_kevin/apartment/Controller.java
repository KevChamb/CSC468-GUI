package chamberlain_kevin.apartment;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;

public class Controller {
    ApartmentComplex apComplex = new ApartmentComplex();
    ActionFilter af = new ActionFilter();
    Text rentText;
    Text maintText;
    Text filledText;
    Text monthText;
    Text fundsText;
    Button monthButton;
    TextField rentField;
    Button rentButton;
    Button pentButton;
    Button basicButton;
    Button emptyButton;
    int basicRent = 800;
    int pentRent = 2000;

    private class ActionFilter implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            // New Month Button was hit
            if (((Node) event.getSource()).getId().compareTo("newMonth") == 0) {
                apComplex.newMonth();
                monthText.setText("Month: " + apComplex.getCurrMonth());
                rentText.setText("Rent to Collect: " +  apComplex.getRentToCollect());
                fundsText.setText("Funds: " + apComplex.getFunds());
                pentButton.setText("Penthouse\nDuration: " + apComplex.getCurrMonth() + "\nRent: " + pentRent);
                basicButton.setText("Basic\nDuration: " + apComplex.getCurrMonth() + "\nRent: " + basicRent);
            }
            else if (((Node) event.getSource()).getId().compareTo("incRent") == 0) {

                int rentUp = Integer.parseInt(rentField.getText());
                apComplex.increaseRent(rentUp);
                pentRent += rentUp;
                basicRent += rentUp;
                pentButton.setText("Penthouse\nDuration: " + apComplex.getCurrMonth() + "\nRent: " + pentRent);
                basicButton.setText("Basic\nDuration: " + apComplex.getCurrMonth() + "\nRent: " + basicRent);
                rentText.setText("Rent to Collect: " + apComplex.getRentToCollect());
            }
        }
    }
    ActionFilter getAf(){
        return af;
    }
    int getRentToCollect(){
        return apComplex.getRentToCollect();
    }
    int getMaintTotal(){
        return apComplex.getMaintTotal();
    }
    int getFillCount(){
        return apComplex.getFillCount();
    }
    int getMonth(){
        return apComplex.getCurrMonth();
    }
    int getFunds(){
        return apComplex.getFunds();
    }
    void buildFloor(int floorIndex){
        apComplex.buildFloor(floorIndex);
    }
    void buildBasic(int floorIndex, int aptIndex){
        apComplex.buildBasic(floorIndex, aptIndex);
    }
    void buildPent(int floorIndex, int aptIndex){
        apComplex.buildPent(floorIndex, aptIndex);
    }
}
