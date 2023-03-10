package chamberlain_kevin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/***********************************************************************************************
 * @author Riley Kopp
 *
 * Defines the appearace of the Fish tank
 **********************************************************************************************/
public class Layout {

    // Link to Controller
    private Controller controller;

    // Action Bar Items
    private String    actionsList[] = { "GoldFish", "AngelFish", "Betta", "Remove"};
    private ComboBox  actionSelection;
    private TextField feedAmount;
    private Button    feed;

    // Info Bar Items
    private Button newDayButton;
    private Text   bowlInfo;
    private Button small;
    private Button medium;
    private Button large;

    // Tank View
    private TankView tank;

    /***********************************************************************************************
     * Sets the appearance and returns the stage to be set in main
     **********************************************************************************************/
    public Scene init(){
        Scene scene;

        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(700, 600);
        borderPane.setBottom(setupInfoBar());
        borderPane.setLeft(setupActionBar());
        borderPane.setCenter(setupTank());

        scene = new Scene(borderPane);
        return scene;
    }

    /***********************************************************************************************
     * Default constructor for Layout
     **********************************************************************************************/
    Layout(Controller controllerIn){
        controller = controllerIn;
        controller.setLayout(this);
    }

    /***********************************************************************************************
     * Sets the appearance of the action bar on the left
     **********************************************************************************************/
    private VBox setupActionBar(){
        VBox side = new VBox();
        side.setAlignment(Pos.CENTER);

        ObservableList list = side.getChildren();

        ObservableList<String> actions = FXCollections.observableArrayList(actionsList);

        // Init Items
        actionSelection = new ComboBox(actions);
        feedAmount      = new TextField();
        feed            = new Button("Feed");

        actionSelection.setMaxWidth(Double.MAX_VALUE);

        // Spacing between selection and the feeding options
        Region spacing  = new Region();
        VBox.setVgrow(spacing, Priority.ALWAYS);

        // Give the combo box a default value
        actionSelection.setOnAction(controller.getComboBoxEvent());
        actionSelection.getSelectionModel().selectFirst();

        feedAmount.addEventFilter(KeyEvent.KEY_RELEASED, controller.getFeedAmountEvent());
        feed.addEventFilter(MouseEvent.MOUSE_CLICKED, controller.getFeedFishEvent());

        list.add(actionSelection);
        list.add(spacing);
        list.add(new Text("Feed Amount"));
        list.add(feedAmount);
        list.add(feed);




        return side;
    }

    /***********************************************************************************************
     * Sets the appearance of the info bar on the bottom of the window
     **********************************************************************************************/
    private BorderPane setupInfoBar(){
        BorderPane info = new BorderPane();


        // Init Items
        newDayButton = new Button("New Day");
        bowlInfo     = new Text("Day: 0\nFilled: 0\nDied: 0");
        small        = new Button("3x3");
        medium       = new Button("4x5");
        large        = new Button("6x8");


        small.addEventHandler(MouseEvent.MOUSE_CLICKED, controller.getResizeBowl(3, 3));
        medium.addEventHandler(MouseEvent.MOUSE_CLICKED, controller.getResizeBowl(4, 5));
        large.addEventHandler(MouseEvent.MOUSE_CLICKED, controller.getResizeBowl(6, 8));

        newDayButton.addEventHandler(MouseEvent.MOUSE_CLICKED, controller.getNewDayEvent());

        // Prettify the Formatting
        HBox resizeOptions = new HBox();
        resizeOptions.setAlignment(Pos.CENTER_LEFT);
        resizeOptions.getChildren().addAll(small, medium, large);
        BorderPane.setAlignment(bowlInfo, Pos.CENTER);
        BorderPane.setAlignment(newDayButton, Pos.CENTER_LEFT);

        // Add items to the correct sides of the pane.
        info.setLeft(newDayButton);
        info.setCenter(bowlInfo);
        info.setRight(resizeOptions);


        return info;
    }

    /***********************************************************************************************
     * Sets the appearance of tank itself
     **********************************************************************************************/
    private TankView setupTank(){
        tank = new TankView(controller);

        return tank;
    }

    // Getter for tank
    public TankView getTank(){
        return tank;
    }

    /***********************************************************************************************
     * Updates the info bar
     **********************************************************************************************/
    public void update(Integer day, Integer filled, Integer dead){
        bowlInfo.setText("Day: " + day.toString() +
                "\nFilled: " + filled.toString() +
                "\nDied: " + dead.toString());
    }
}
