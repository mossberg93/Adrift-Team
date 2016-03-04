/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.control.MapControl;
import byui.cit260.adrift.control.RobotControl;
import byui.cit260.adrift.control.SpaceSuitControl;

/**
 *
 * @author Philip
 */
public class CalculateO2View extends View {

    private int distance = 0;
    private int amount = 0;
    private int harvest = 0;
    private int buggy = 0;
    private String mapLoc = null;
    private int question = 1;
    String message;
    String[] dialogue = {
        "Enter your destination coordinates.",
        "Will you be harvesting resources?"
            + "\nY - Yes"
            + "\nN - No",
        "How much resources will you be harvesting?",
        "Will you be taking the buggy?"
            + "\nY - Yes"
            + "\nN - No"
    };
    
    public CalculateO2View() {
        super();
        mapLoc = MapControl.getLocation();
        int O2Amount = SpaceSuitControl.getO2Amount();
        message = "You're at map coordinates " + mapLoc + " and have "
                + O2Amount + " units of O2. " + dialogue[0];
        super.setDisplayMessage(message);
    }
    
    @Override
    public boolean doAction (String input) {
        
        boolean valid = false;
        boolean done = false;
        char selection = input.toLowerCase().charAt(0);
        
        switch(question) {
            case 1: // 1st response
                valid = MapControl.validateLocation(input.toLowerCase());
                if (!valid) {
                    System.out.println("Input invalid: Enter a valid location.");
                } else {
                    String mapDest = input;
                    distance = MapControl.calculateDistance(mapLoc, mapDest);
                }
                break;
            case 2: // 2nd response

                if (selection == 'y' || selection == 'n') {
                    // ternary expression if selection is y harvest is 1 otherwise it's 0
                    if (selection == 'y') {
                        harvest = 1;
                     } 
                    else {
                        harvest = 0;
                        question++; // need to skip to the next question
                    }
                    
                    valid = true;

                } else {
                    System.out.println("Input invalid: Please enter Y or N");
                }
                break;
            case 3: // 3rd response
                try {
                    amount =  Integer.parseInt(input);
                    if (amount > 0) {
                       valid = true;
                    }
                    else {
                        System.out.println("Input invalid: Enter a value > 0");
                    }
                } catch (NumberFormatException e){
                    System.out.println("Input invalid: Enter a number.");
                }
                break;
            case 4: // 4th response
                

                if (selection == 'y' || selection == 'n') {
                    // ternary expression if selection is y buggy is 1 otherwise it's 0
                    buggy = (selection == 'y') ? 1 : 0; 
                    done = true;
                } else {
                    System.out.println("Input invalid: Please enter Y or N");
                }
                break;
          }
        
        if (valid) {
            message = dialogue[question]; // get the next part of the dialogue
            super.setDisplayMessage(message); // update the display message
            question++; // advance to the next question
        }
        
        if (done) {
            double requiredO2 = RobotControl.calculateO2(distance, amount, harvest, buggy);
            System.out.println("You will require " + requiredO2 + " units of O2 "
                    + "for you journey.");
        }

        return done;
    }
}
