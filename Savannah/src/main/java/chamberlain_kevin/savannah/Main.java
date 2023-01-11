package chamberlain_kevin.savannah;

import javafx.application.Application;
import javafx.stage.Stage;
/*
____ Followed the class OOP diagram 	14
____ Observer pattern (ignores tiers)	20


1.	Tier: Views and animal
_X_ a. All objects (ignoring the sim area)
_X_ b. Have a 9 tile sim area	5
_X_ c. Able to add/remove an animal properly
_X_ d. Info bar listed correctly with all three items with default values
_X_ e. Tile Text correct for each for one rectangle
_X_ f. Tile Text correct for each for all rectangles
_X_ g. Radio buttons update properly
_X_ h. Selecting a rectangle with “view” affects the animal info somehow
_X_ i. Selecting a rectangle with “view” affects the animal info correctly


2a Tier: Advanced functionality	32
_X_ a. New day button has some noticeable effect
_X_ b. Animals updated properly on “new day”
_X_ c. Day count in info bar is correct
_X_ d. Animal removed when dead on “new day”
_X_ e. Num died in info bar is correct (updates on the day the animal dies)
_X_ f. Num tiles filled in info bar is correct at all times
_X_ e. The animal info at least holds
____ f. Reselecting the tile updates the animal information correctly


2b: Layout	48
____ a. Location of all items in correct spot
_X_ b. Layout still correct on window resize
_X_ c. Resize grid at minimum resets the grid and info
_X_ d. Everything still working that is listed above with resize


Final Tier: Extensions 30
Extension 1: <2d> <10pts> <see below>: test by adding animal see description below code lies in TileView in propertyChange
Extension 2: <3b> <15pts> <see below>: test by clicking Resize Savannah in upper left corner of window, code lies in Layout
and controller "CTRL+F" "x33"
Extension 3: <4c> <5pts> <see below>: test by selecting dropdown and selecting Gazelle of Tortoise, each have thies own
classes

 */
/***********************************************************************************************
 * @author  Kevin Chamberlain
 * Descripton:
 * The entry point of the Savannah program. For more information see the assignment on D2L for
 * a full description of the program.
 *
 * All Tiers Completed
 * Extensions Completed:
 *
 * 10pt: Add Colors instead of using text only to indicate an animal. Your selection must be
 * noted somewhere. The health text must remain.
 * Noted Below
 * Cheetah:Oragnge      Zebra:Grey      Tortoise:Green      Gazelle:Tan
 *
 * 15pt: Add a menu bar to do the same thing as 3+ buttons
 *
 * 5pt: Add 2+ more animal types, each with their own needs. Add this new animal under
 * the current animal. You must list what their needs are in the extension comments.
 * Gazelle: health = 10 longevity = 2
 * Tortoise: helath = 50 longevity = 1
 *
 * Bugs: Dropdown and Animal Information slightly skewed upwards
 * TODO: NA
 **********************************************************************************************/
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Layout layout = new Layout();
        layout.makeContents(primaryStage);
    }

    public static void main(String[] args) {launch(args);}
}
