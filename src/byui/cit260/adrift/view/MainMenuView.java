/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.*;

/**
 *
 * @author Philip
 */
public class MainMenuView extends View {
    
     public MainMenuView() {
        super("\n"
            + "\n---------------------------------------"
            + "\n Main Menu                            |"
            + "\n---------------------------------------"
            + "\nG - Start Game"
            + "\nH - Help Menu"
            + "\nS - Save Game"
            + "\nL - Load Game"
            + "\nE - Exit"
            + "\n---------------------------------------"
            + "\n"
            + "\nEnter an action: ");
    }
    
    @Override
    public boolean doAction(String input) {
        
        boolean done = false;
        char choice;
        choice = input.toLowerCase().charAt(0);		
        
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
                done = true;
                break;
            default:
                System.out.println("\nInvalid selection: Try again");
                break;
        }
        
        return done;
    }

    private void startNewGame() { // create a new game
        GameControl.createNewGame(AdriftTeam.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
        GameControl.saveGame();
        
        System.out.println("\n*** The Game was successfully saved. ***");
    }

    private void loadGame() {
        GameControl.loadGame();
        
        System.out.println("\n*** The Game loaded successfully ***");
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}
