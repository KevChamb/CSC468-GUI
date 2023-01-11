package chamberlain_kevin.savannah;

import java.beans.PropertyChangeSupport;

/***************************************************************************************************
 * @author Kevin Chamberlain
 * The tile class
 **************************************************************************************************/
public class Tile {
    private Animal animal;
    private PropertyChangeSupport subject;

    /***************************************************************************************************
     * A Basic constructor for Tile
     **************************************************************************************************/
    public Tile(){
        subject = new PropertyChangeSupport(this);
    }

    /***************************************************************************************************
     * A setter for the subject
     **************************************************************************************************/
    public void setSubject(TileView tileView){
        subject.addPropertyChangeListener(tileView);
    } //GRADING: SUBJECT

    /***************************************************************************************************
     * Differentiates which animal and creates it
     **************************************************************************************************/
    void newAnimal(String which){
        if(which == "Cheetah"){
            animal = new Cheetah();
        }
        else if(which == "Zebra"){
            animal = new Zebra();
        }
        else if(which == "Gazelle"){
            animal = new Gazelle();
        }
        else if(which == "Tortoise"){
            animal = new Tortoise();
        }
        else if(which == "Remove"){
            animal = new None();

        }
        subject.firePropertyChange("animal", null, animal); //GRADING: TRIGGER

    }

    /***************************************************************************************************
     * A getter for an Animal
     **************************************************************************************************/
    public Animal getAnimal() { return animal; }

    /***************************************************************************************************
     * A setter for the Animal
     **************************************************************************************************/
    public void setAnimal(String newAnimal){
        this.newAnimal(newAnimal);
    }

    /***************************************************************************************************
     * Facilitates New Day Button at this level and passes it on to the Animal
     **************************************************************************************************/
    public void newDay() {
        if(animal != null){
            animal.newDay();
            subject.firePropertyChange("animal", null, animal); //GRADING: TRIGGER
        }
        else{
            return;
        }
    }
}
