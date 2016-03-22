/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Philip
 */
public abstract class View implements ViewInterface {

    protected String displayMessage;

    protected final BufferedReader keyboard = AdriftTeam.getInFile();
    protected final PrintWriter console = AdriftTeam.getOutFile();

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
            this.console.println("\n" + this.displayMessage);
            String input = this.getInput();
            done = this.doAction(input);

        } while (!done);
    }

    @Override
    public String getInput() {

        boolean valid = false; // initialize to not valid
        String value = null; // value to be returned

        while (!valid) {

            try {
                value = this.keyboard.readLine(); // get next line typed on keyboard
            } catch (IOException ex) {
                System.out.println("Failure to read input."  + ex.getMessage());
            }

            value = value.trim(); // trim of leading and trailing blanks

            if (value.length() < 1) { // value is blank
                ErrorView.display(this.getClass().getName(),
                    "\nInvalid value: try again.");
                this.console.println(this.displayMessage);
                continue;
            }

            break; // end the loop
        }

        return value;
    }
}
