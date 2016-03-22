/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.*;
import byui.cit260.adrift.exceptions.MapControlException;

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
                ErrorView.display(this.getClass().getName(), "\nInvalid selection: Try again");
                break;
        }

        return done;
    }

    private void startNewGame() {
         try {
             // create a new game
             GameControl.createNewGame(AdriftTeam.getPlayer());
         } catch (MapControlException ex) {
             ErrorView.display(this.getClass().getName(), ex.getMessage());
         }

        // display the game menu
        PreMissionMenuView preMissionMenu = new PreMissionMenuView();
        preMissionMenu.display();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {

        this.console.println("\nEnter the filepath to save the game.");
        String filePath = this.getInput();

        try {
            GameControl.saveGame(AdriftTeam.getGame(), filePath);
            this.console.println("\nThe Game was successfully saved.");
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    private void loadGame() {

        this.console.println("\nEnter a save file location.");
        String filePath = this.getInput();

        try {
            GameControl.loadGame(filePath);

            this.console.println("\n*** The Game loaded successfully ***");

        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}
