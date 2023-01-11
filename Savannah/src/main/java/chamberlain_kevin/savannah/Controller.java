package chamberlain_kevin.savannah;


import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.*;

/***************************************************************************************************
 * @author Kevin Chamberlain
 * Controller class
 * This class contains the event handlers connecting the layout and Savannah
 **************************************************************************************************/
public class Controller {

    Savannah savannah;// = new Savannah();
    ActionFilter af = new ActionFilter();
    Layout lOut;
    private ChoiceBox choicebox = new ChoiceBox();
    Button x3Btn;
    Button x5Btn;
    Button x8Btn;

    /***************************************************************************************************
     * Default constructor for the Controller
     **************************************************************************************************/
    Controller(Layout layout){
        lOut = layout;
    }

    /**********************************************************************************************
     * Handles click events in the savannah view to add/remove/view animals.
     * @param MouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
    private class AddAnimalEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            TileView button = (TileView) mouseEvent.getSource();

            if(lOut.getAdd().isSelected()) {


                //savannah.doAction(button.getRow(), button.getCol(), mouseEvent);
                if (lOut.getComboBox().getSelectionModel().getSelectedItem() == "Zebra") {
                    savannah.setWhich(button.getRow(), button.getCol(), "Zebra");

                } else if (lOut.getComboBox().getSelectionModel().getSelectedItem() == "Cheetah") {
                    savannah.setWhich(button.getRow(), button.getCol(), "Cheetah");
                }else if (lOut.getComboBox().getSelectionModel().getSelectedItem() == "Gazelle"){
                    savannah.setWhich(button.getRow(), button.getCol(), "Gazelle");
                }else if (lOut.getComboBox().getSelectionModel().getSelectedItem() == "Tortoise"){
                    savannah.setWhich(button.getRow(), button.getCol(), "Tortoise");
                }

                lOut.update(savannah.getDayCount(), savannah.getFilled(), savannah.getDied());
            }
            else if(lOut.getView().isSelected()){
                //PICK up HERE
                int i = button.getRow();
                int j = button.getCol();
                int health = savannah.getHealth(i,j);
                String name = savannah.getName(i,j);
                if(health != -1){
                    lOut.getAnimalInfo().setText(name + "\nHealth: " + health);
                }
            }
        }
    }


    /**********************************************************************************************
     * Handles click events on the New Day Button
     * @param mouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
    private class NewDayEvent implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent mouseEvent){
            savannah.newDay();
            lOut.update(savannah.getDayCount(), savannah.getFilled(), savannah.getDied());
        }
    }

    /**********************************************************************************************
     * Handles click events on the Radio Buttons
     * @param a : ActionEvent triggered on MouseClick
     *********************************************************************************************/
    private class UpdateRadio implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent a){savannah.setRadio((RadioButton) a.getSource());}
    }

    /**********************************************************************************************
     * Handles click events on the Resize Menu Buttons
     * @param event : ActionEvent triggered on MouseClick
     *********************************************************************************************/
    private class MenuResize implements EventHandler<ActionEvent>{
        int size;
        MenuResize(int i){
            size = i;
        }

        public void handle(ActionEvent event){
            lOut.resize(size, size);
        }
    }

    /**********************************************************************************************
     * Handles click events on the any of the standard size buttons (not including the menu)
     * @param event : ActionEvent triggered on MouseClick
     *********************************************************************************************/
    private class ActionFilter implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){

            if(((Node) event.getSource()).getId().compareTo("x3")==0 ){
                lOut.resize(3,3);
            }
            else if(((Node) event.getSource()).getId().compareTo("x5")==0){
                lOut.resize(5,5);
            }
            else if(((Node) event.getSource()).getId().compareTo("x8")==0){
                lOut.resize(8,8);
            }
        }
    }

    public void setModel(Savannah sav){
        savannah = sav;
        lOut.savannahView.setModel(savannah);
        savannah.setDisplay(lOut.savannahView);
        savannah.setSize(3);
        savannah.createSavannah();

    }

    /**********************************************************************************************
     * Handles click events on the add Radio Button
     * @param mouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
    private class addEvent implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            lOut.getView().selectedProperty().set(false);
        }
    }

    /**********************************************************************************************
     * Handles click events on the view Radio Button
     * @param mouseEvent : MouseEvent triggered on MouseClick
     *********************************************************************************************/
    private class viewEvent implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            lOut.getAdd().selectedProperty().set(false);
        }
    }

    public MenuResize menuMenu(int i){return new MenuResize(i);}
    public NewDayEvent newDay() {return new NewDayEvent();}
    ActionFilter getAf() {return af;}
    public addEvent getAdd(){return new addEvent(); }
    public viewEvent getView(){return new viewEvent();}
    int getDay(){return savannah.getDayCount();}
    int getFilled(){return savannah.getFilled();}
    int getDied(){return savannah.getDied();}
    public UpdateRadio getRadioEvent() {return new UpdateRadio();}
    public AddAnimalEvent GridButtons() {return new AddAnimalEvent();}


}
