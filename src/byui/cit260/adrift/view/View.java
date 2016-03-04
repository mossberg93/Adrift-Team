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
public abstract class View implements ViewInterface {
    
    protected String displayMessage;

    public View() {
        
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }    
    
    @Override
    public void display() {

        boolean done = false;
        
        do {
            System.out.println("\n" + this.displayMessage);
            String input = this.getInput();
            done = this.doAction(input);
            
        } while (!done);
    }    
    
    @Override
    public String getInput() {
        
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        boolean valid = false; // initialize to not valid
        String value = null; // value to be returned

        while (!valid) { 
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim of leading and trailing blanks

            if (value.length() < 1) { // value is blank
                System.out.println("\n" + this.displayMessage);
                System.out.println("\nInvalid value: try again.");
                continue;
            }

            break; // end the loop
        }

        return value;               
    }
}
