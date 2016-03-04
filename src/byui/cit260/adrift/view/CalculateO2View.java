/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.control.MapControl;
import byui.cit260.adrift.control.RobotControl;
import byui.cit260.adrift.control.SpaceSuitControl;
import java.util.Scanner;

/**
 *
 * @author Philip
 */
public class CalculateO2View {

    String inputError = null;
    String prompt = null;
    
    public void displayCalculateO2() {
        
        int O2Amount = SpaceSuitControl.getO2Amount();
        int distance = 0;
        int amount = 0;
        int harvest = 0;
        int buggy = 0;
        String mapLoc = MapControl.getLocation();
        String mapDest = null;
        boolean valid = false;
        
        String displayInfo = "You're at map coordinates " + mapLoc + " and your O2 "
                + "\nlevel is 3.";
        
        String destPrompt = "\nPlease enter the coordinates of your travel "
                + "\ndestination?";
        
        prompt = displayInfo + destPrompt;
        
        while (!valid) {
            String input = this.getInput();
            valid = MapControl.validateLocation(input.toLowerCase());
            mapDest = input;
        }

        distance = MapControl.calculateDistance(mapLoc, mapDest);
        
        valid = false;
        prompt = "Will you be harvesting resources?"
                + "\nY - Yes"
                + "\nN - No";
        
        while (!valid) {
            
            String input = this.getInput();
            char selection = input.toLowerCase().charAt(0);
            
            if (selection == 'y') {
                harvest = 1;
                valid = true;
            } else if (selection == 'n') {
                harvest = 0;
                valid = true;
            } else {
                inputError = "Invalid value.  Please enter Y or N";
            }
                
        }
        
        valid = false;
        prompt = "How much resources will you be harvesting?";

        while (!valid) {
            
            String input = this.getInput();
            
            try {
                amount =  Integer.parseInt(input);
                if (amount > 0) {
                    valid = true;
                }
            } catch (NumberFormatException e){
                inputError = "Invalid value. Please enter a number.";
            }
        }

        valid = false;
        prompt = "Will you be taking the buggy?"
                + "\nY - Yes"
                + "\nN - No";
        
        while (!valid) {
            
            String input = this.getInput();
            char selection = input.toLowerCase().charAt(0);
            
            if (selection == 'y') {
                buggy = 1;
                valid = true;
            } else if (selection == 'n') {
                buggy = 0;
                valid = true;
            } else {
                inputError = "Invalid value.  Please enter Y or N";
            }
                
        }        
            
        double requiredO2 = RobotControl.calculateO2(distance, amount, harvest, buggy);
        
        System.out.println("You will require " + requiredO2 + " O2 for you journey.");
          
    }
        
    private String getInput() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid

        while (!valid) { 
            
            if (inputError != null) {
                System.out.println(inputError);
                inputError = null;
            }  
            
            System.out.println("\n" + prompt);

            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim of leading and trailing blanks

            if (value.length() == 0) { // value is blank
                inputError = "\nInvalid value, try again.";
                continue;
            }

            break; // end the loop
        }

        return value;               
    }
}
