/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

/**
 *
 * @author Philip
 */
public class HelpMenuView extends View{

    public HelpMenuView() {
        super("\n"
            + "\n---------------------------------------"
            + "\n Help Menu                            |"
            + "\n---------------------------------------"
            + "\nG - Game Goal"
            + "\nM - How to move"
            + "\nF - Calculate Fuel"
            + "\nO - Calculate O2"
            + "\nY - Calculate Energy"
            + "\nH - Harvest Resources"
            + "\nR - Repair the Ship"
            + "\nE - Exit"
            + "\n---------------------------------------"
            + "\n"
            + "\nEnter an option: ");
    }

    private final String GAME_GOAL = "\n"
        + "You’ve crash landed on an Asteroid and need to harvest resources, fix"
        + " your ship, and return home.";

    private final String HOW_TO_MOVE = "\n"
        + "To move to a new map location, select “Move to Coordinate” on the "
        + "Game Menu.";

    private final String CALCULATE_FUEL = "\n"
        + "Fuel is a resource needed to power the buggy.  Your ship's robot can "
        + "calculate the fuel needed for the buggy to make a trip.  Without "
        + "enough fuel the buggy can become stranded until more fuel is acquired."
        + "\n"
        + "Select “Calculate Fuel” from the Game Menu while at your ship to "
        + "calculate fuel needed for a trip.";

    private final String CALCULATE_ENERGY = "\n"
        + "Energy is a resource required by you, the astronaut.  Your ship's "
        + "robot can calculate the energy needed to make a trip.  The game is "
        + "over if you run out of energy while on a trip."
        + "\n"
        + "Select “Calculate Energy” from the Game Menu while at your ship to "
        + "calculate the energy needed  for a trip.";

    private final String CALCULATE_O2 = "\n"
        + "Oxygen is a resource required by you, the astronaut.  Your ship's "
        + "robot can calculate the oxygen needed to make a trip.  The game is "
        + "over if you run out of oxygen while on a trip."
        + "\n"
        + "Select “Calculate Oxygen” from the Game Menu while at your ship to "
        + "calculate the oxygen needed  for a trip.";

    private final String HARVEST_RESOURCES = "\n"
        + "Certain map locations contain resources (Iron Ore, Aluminum Ore, "
        + "Frozen Ice, Copper Ore, Uranium, Crystal, Diamonds, Water, Food "
        + "Rations, and Fuel) that can be used to create and power tools and "
        + "help repair the ship.  Collect enough resources to repair the ship "
        + "and return home."
        + "\n"
        + "Select “Harvest Resource” from the Game Menu to harvest resources "
        + "while at a map location with resources.";

    private final String REPAIR_SHIP = "\n"
        + "To return home your ship must first be repaired."
        + "\n"
        + "Select “Repair Ship” from the Game Menu while at your ship to repair "
        + "your ship.";


    @Override
    public boolean doAction(String input) {

        boolean done = false;
        char choice;
        choice = input.toLowerCase().charAt(0);

        switch(choice) {
            case 'g': // display GAME_GOAL
                this.console.println(this.GAME_GOAL);
                break;
            case 'm': // display HOW_TO_MOVE
                this.console.println(this.HOW_TO_MOVE);
                break;
            case 'f': // display CALCULATE_FUEL
                this.console.println(this.CALCULATE_FUEL);
                break;
            case 'o': // display CALCULATE_O2
                this.console.println(this.CALCULATE_O2);
                break;
            case 'y': // display CALCULATE_ENERGY
                this.console.println(this.CALCULATE_ENERGY);
                break;
            case 'h': // display HARVEST_RESOURCES
                this.console.println(this.HARVEST_RESOURCES);
                break;
            case 'r': // display REPAIR_SHIP
                this.console.println(this.REPAIR_SHIP);
                break;
            case 'e': // exit game
                done = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }

        return done;
    }
}
