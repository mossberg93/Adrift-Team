/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author mossb
 */
public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView() {
        
        this.promptMessage = "\nPlease enter your name: ";
        //display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
            "\n***********************************"
            +"\n*                                 *"
            +"\n* Welcome to the game of Adrift!  *"
            +"\n* In this game, you will assume   *"
            +"\n* the role of an astronaut hired  *"
            +"\n* by NASA in the year 2050 to     *"
            +"\n* lead mining operations that     *"
            +"\n* take place in the asteroid belt *"
            +"\n* within our own solar system.    *"
            +"\n*                                 *"
            +"\n* Disaster strikes the crew of    *"
            +"\n* your ship, and you must fight   *"
            +"\n* to preserve your life and the   *"
            +"\n* lives of your team. In this     *"
            +"\n* brave adventure, what will you  *"
            +"\n* do to save your team and        *"
            +"\n* survive against the odds? Will  *"
            +"\n* you be able to make it back     *"
            +"\n* home in one piece? That is for  *"
            +"\n* you to decide!                  *"
            +"\n*                                 *"
            +"\n***********************************"
            );
            }

    public void displayStartProgramView() {
        
        boolean done = false; // set flag to not done
        do {
            //prompt for and get the players name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(playersName);
        } while (!done);
    }

    public String getPlayersName() {
        
        Scanner keyboard = new Scanner(System.in); // keyboard input stream
        String value = "";
        
        boolean valid = false; // set flag to invalid value entered
        while(!valid) { // while a valid name has not been retrieved
            
            //prompt for the player's name
            System.out.println(this.promptMessage);
            
            value = keyboard.nextLine(); //get the name from the keyboard
            value = value.trim(); // trim off the excess blanks
            
            // if the name is invalid (less than one character in length)
            if (value.length() < 1) {
                System.out.println("Invalid value - the value cannot be blank");
                continue; // and repeat again
            }
            valid = true; // set flag to end repetition
        }
        
        return value; // return the value
    }

    private boolean doAction(String playersName) {
        
        if (playersName.length() < 2) {
            System.out.println("\nInvalid players name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) {
            System.out.println("\nError creating the player.");
            return false;
        }
        
        this.displayNextView(player);
        
        return true;
    }

    private void displayNextView(Player player) {
        
        System.out.println(
               "\n*************************************"
               +"\n Welcome to the game " + player.getName()
               +"\n We hope you have a lot of fun!"
               +"\n*************************************"
        );
        
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMainMenu();
    }
}
    

