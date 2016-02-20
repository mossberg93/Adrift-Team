/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.control.*;
import java.util.Scanner;

/**
 *
 * @author Philip
 */
public class MainMenuView {
    
    private String promptMessage = "Enter an action";
    
    private final String MENU = "\n"
            + "\n---------------------------------------"
            + "\n Main Menu                            |"
            + "\n---------------------------------------"
            + "\nG - Start Game"
            + "\nH - Help Menu"
            + "\nS - Save Game"
            + "\nL - Load Game"
            + "\nE - Exit"
            + "\n---------------------------------------";

    public void displayMainMenu() {
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
            case 'g': // create and start a new game
                this.startNewGame();
                break;
            case 'h': // display help menu
                this.displayHelpMenu();
                break;
            case 's': // save game
                this.saveGame();
                break;
            case 'l': // load game
                this.loadGame();
                break;
            case 'e': // exit game
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
    }

    private void startNewGame() { // create a new game
        GameControl.createNewGame("player"); // Adrift.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenu();
    }

    private void saveGame() {
        GameControl.saveGame();
        
        System.out.println("\n*** The Game was successfully saved. ***");
    }

    private void loadGame() {
        GameControl.loadGame();
        
        System.out.println("\n*** The Game loaded successfully ***");
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }
}
