/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import java.util.Scanner;

/**
 *
 * @author Philip
 */
public class HelpMenuView {

    private String promptMessage = "Enter an option";
    
    private final String MENU = "\n"
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
            + "\n---------------------------------------";    
    
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
    
    void displayHelpMenu() {
        //System.out.println("\n*** diplayMenu() function called***");
        
        char selection = ' ';
        do {
            System.out.println(MENU);
            
            String input = this.getInput();
            selection = input.toLowerCase().charAt(0);
            
            this.doAction(selection);
        } while (selection != 'e');
    }
    
    private String getInput() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid

        while (!valid) { 
            System.out.println("\n" + this.promptMessage);

            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim of leading and trailing blanks

            if (value.length() != 1) { // value is blank
                System.out.println("\nInvalid value: value must be 1 charachter");
                continue;
            }

            break; // end the loop
        }

        return value;               
    }

    private void doAction(char choice) {

        switch(choice) {
            case 'g': // display GAME_GOAL
                System.out.println(this.GAME_GOAL);
                break;
            case 'm': // display HOW_TO_MOVE
                System.out.println(this.HOW_TO_MOVE);
                break;
            case 'f': // display CALCULATE_FUEL
                System.out.println(this.CALCULATE_FUEL);
                break;
            case 'o': // display CALCULATE_O2
                System.out.println(this.CALCULATE_O2);
                break;
            case 'y': // display CALCULATE_ENERGY
                System.out.println(this.CALCULATE_ENERGY);
                break;
            case 'h': // display HARVEST_RESOURCES
                System.out.println(this.HARVEST_RESOURCES);
                break;
            case 'r': // display REPAIR_SHIP
                System.out.println(this.REPAIR_SHIP);
                break;  
            case 'e': // exit game
                break;                
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
    }    
    
}
