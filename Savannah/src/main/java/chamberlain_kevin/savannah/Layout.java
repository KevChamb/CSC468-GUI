package chamberlain_kevin.savannah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.*;

/***********************************************************************************************
 * @author Kevin Chamberlain
 *
 * Creates what the Savannah will look like
 **********************************************************************************************/
public class Layout {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;
    Controller ctrl;
    ObservableList<String> cOz = FXCollections.observableArrayList("Zebra", "Cheetah", "Gazelle", "Tortoise");
    SavannahView savannahView;
    RadioButton add;
    RadioButton view;
    ComboBox comboBox = new ComboBox();
    private Label day;
    private Label died;
    private Label filled;
    private Label animalInfo;
    Savannah savannah;


    Label resize = new Label("Resize:");

    /***********************************************************************************************
     * Basic constructor
     **********************************************************************************************/
    public Layout(){
        savannah = new Savannah();
    }

    /***********************************************************************************************
     * Updates the Day, Filled, and Died fields
     **********************************************************************************************/
    public void update(int days, int filld, int dead){
        day.setText("Day: " + String.valueOf(days));
        filled.setText("Filled: " + String.valueOf(filld));
        died.setText("Died: " + String.valueOf(dead));
    }

    /***********************************************************************************************
     * Facilitates resizing savannah grid
     **********************************************************************************************/
    public void resize(int i, int j) {
        savannah = new Savannah(i);
        ctrl.setModel(savannah);
        savannah.getSize();
        savannahView.resize(i, j, savannah);
    }

    /***********************************************************************************************
     * A getter for Animal Info
     **********************************************************************************************/
    public Label getAnimalInfo(){
        return animalInfo;
    }

    /***********************************************************************************************
     * A getter for the Animal Options Combo Box
     **********************************************************************************************/
    public ComboBox getComboBox() {
        return comboBox;
    }

    /***********************************************************************************************
     * A getter for the Add Radio Button
     **********************************************************************************************/
    public RadioButton getAdd(){
        return add;
    }

    /***********************************************************************************************
     * A getter for the View Radio Button
     **********************************************************************************************/
    public RadioButton getView(){
        return view;
    }

    /***********************************************************************************************
     * Sets the appearance of the Layout
     **********************************************************************************************/
    public void makeContents(Stage primaryStage) { //Group root

        GridPane root = new GridPane();
        root.setGridLinesVisible(false);
        ctrl = new Controller(this);
        savannahView = new SavannahView(ctrl, savannah);
        this.resize(3,3);


        //Overall Rows & Cols
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(16);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(28);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(28);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(28);
        root.getRowConstraints().addAll(row1, row2, row3, row4);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(15);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(15);
        root.getColumnConstraints().addAll(col1, col2, col3);
        //End Col Row---------------------------------------

        //--------------------------TOP-----------------------------------------------
        //top left
        BorderPane top = new BorderPane();
        int days = ctrl.getDay();
        int fills = ctrl.getFilled();
        int dead = ctrl.getDied();
        day = new Label("Day: 0");
        died = new Label("Died: 0");
        filled = new Label("Filled: 0");//HERE
        VBox tL = new VBox(day, filled, died); //top Left

        MenuBar menu = new MenuBar();
        Menu main = new Menu("Resize Savannah");
        MenuItem x33 = new MenuItem("3x3");
        MenuItem x55 = new MenuItem("5x5");
        MenuItem x88 = new MenuItem("8x8");
        main.getItems().addAll(x33,x55,x88);
        menu.getMenus().add(main);
        x33.setId("x33");
        x55.setId("x55");
        x88.setId("x88");
        x33.setOnAction(ctrl.menuMenu(3));
        x55.setOnAction(ctrl.menuMenu(5));
        x88.setOnAction(ctrl.menuMenu(8));


        //top right
        Button x3 = new Button("3X3");
        Button x5 = new Button("5X5");
        Button x8 = new Button("8X8");
        VBox right = new VBox(x3, x5, x8);
        right.setAlignment(Pos.CENTER);
        x3.setId("x3");
        x5.setId("x5");
        x8.setId("x8");
        x3.addEventFilter(ActionEvent.ACTION, ctrl.getAf());
        x5.addEventFilter(ActionEvent.ACTION, ctrl.getAf());
        x8.addEventFilter(ActionEvent.ACTION, ctrl.getAf());
        ctrl.x3Btn = x3;
        ctrl.x5Btn = x5;
        ctrl.x8Btn = x8;
        HBox tR = new HBox(resize, right); //top right
        tR.setAlignment(Pos.CENTER);

        Button newDay = new Button("New Day");
        top.setCenter(newDay);
        newDay.setId("day");
        newDay.addEventFilter(ActionEvent.ACTION, ctrl.newDay());

        top.setTop(menu);
        top.setRight(tR);
        top.setLeft(tL);
        root.add(top, 0, 0, 3, 1);
        //-------------------------------------End TOP-----------------------------------------

        //LEFT
        BorderPane left = new BorderPane();
        comboBox.getItems().addAll(cOz);
        comboBox.getSelectionModel().selectFirst();
        animalInfo = new Label("Animal Info"); //TODO link text to ctrl
        ToggleGroup group = new ToggleGroup();
        add = new RadioButton("Add");
        view = new RadioButton("Veiw");
        add.setToggleGroup(group);
        add.setSelected(true);
        add.addEventHandler(MouseEvent.MOUSE_CLICKED,ctrl.getAdd());
        view.addEventHandler(MouseEvent.MOUSE_CLICKED,ctrl.getView());
        view.setToggleGroup(group);
        add.setOnAction(ctrl.getRadioEvent());
        VBox lVbox = new VBox(comboBox, add, view);
        left.setTop(lVbox);
        left.setCenter(animalInfo);

        root.add(left, 0, 1, 1, 2);
        root.add(savannahView, 1, 1, 2, 3); //col row

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Savannah Simulator");
        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.show();

    }
}
