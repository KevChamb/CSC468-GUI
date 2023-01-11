package chamberlain_kevin.apartment;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;

public class Layout {
    Controller cont = new Controller();

    public void initialize(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setGridLinesVisible(false);
        // Create rows and columns
        for(int i = 0; i < 20; i++){
            RowConstraints newRow = new RowConstraints();
            newRow.setPercentHeight(5);
            newRow.setVgrow(Priority.ALWAYS);
            newRow.setFillHeight(true);
            root.getRowConstraints().add(newRow);
        }
        for(int i = 0; i < 5; i++){
            ColumnConstraints newCol = new ColumnConstraints();
            newCol.setPercentWidth(20);
            newCol.setHgrow(Priority.ALWAYS);
            newCol.setFillWidth(true);
            root.getColumnConstraints().add(newCol);
        }

        // Create Empty Floor
        Button empty = new Button("Empty");
        empty.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.add(empty, 1, 17, 1, 3);
        empty.setId("empty");
        cont.buildFloor(0);
        cont.emptyButton = empty;

        // Create Basic Floor
        Button basic = new Button("Basic\nDuration: 0\nRent: 800");
        basic.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.add(basic, 2, 17, 1, 3);
        cont.buildFloor(1);
        cont.buildBasic(1, 0);
        cont.basicButton = basic;

        // Create Penthouse Floor
        Button pent = new Button("Penthouse\nDuration: 0\nRent: 2000");
        pent.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.add(pent, 3, 17, 1, 3);
        cont.buildFloor(2);
        cont.buildPent(2, 0);
        cont.pentButton = pent;

        // Get the rent total
        int rentTotal = cont.getRentToCollect();
        Text rentCollect = new Text("Rent to Collect: " + String.valueOf(rentTotal));
        rentCollect.setId("rentCollect");
        root.add(rentCollect, 0, 0);
        cont.rentText = rentCollect;

        // Get the maintenance total
        int maintTotal = cont.getMaintTotal();
        Text maintCost = new Text("Maintenance: " + String.valueOf(maintTotal));
        maintCost.setId("maintCost");
        root.add(maintCost, 0, 1);
        cont.maintText = maintCost;

        // Get filled count
        int filledCount = cont.getFillCount();
        Text filledNum = new Text("Filled: " + String.valueOf(filledCount));
        filledNum.setId("filledNum");
        root.add(filledNum, 0, 2);
        cont.filledText = filledNum;

        // Get current Month
        int month = cont.getMonth();
        Text currMonth = new Text("Month: " + String.valueOf(month));
        currMonth.setId("currMonth");
        root.add(currMonth, 0, 18);
        cont.monthText = currMonth;

        // Create Funds Text
        int funds = cont.getFunds();
        Text currFunds = new Text("Funds: " + String.valueOf(funds));
        currFunds.setId("currFunds");
        root.add(currFunds, 0, 19);
        cont.fundsText = currFunds;

        // Create New Month button
        Button newMonth = new Button("New Month");
        newMonth.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.add(newMonth, 4, 0);
        newMonth.setId("newMonth");
        newMonth.addEventFilter(ActionEvent.ACTION, cont.getAf());
        cont.monthButton = newMonth;
        // Create Rent Text Field
        TextField incRentText = new TextField("0");
        root.add(incRentText, 4, 4);
        incRentText.setId("incRentText");
        cont.rentField = incRentText;
        // Create Increase Rent Button
        Button incRent = new Button("Increase Rent");
        incRent.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.add(incRent, 4, 5);
        incRent.setId("incRent");
        incRent.addEventFilter(ActionEvent.ACTION, cont.getAf());
        cont.rentButton = incRent;

        cont.getRentToCollect();

        primaryStage.setTitle("ApartmentComplex Simulator");
        primaryStage.setScene(new Scene(root, 800, 400));
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(400);
        primaryStage.show();
    }
}