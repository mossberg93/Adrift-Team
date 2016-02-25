/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import java.util.Scanner;

/**
 *
 * @author mossb
 */
public class CalculateFuelView {
    
    public void displayCalculateFuelView() {
        
        boolean done = false;
        do {
            String calculateFuelOption = this.getFuelCaclulation();
            if (calculateFuelOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(calculateFuelOption);
        } while (!done);
    }

    private String getFuelCaclulation() {
        System.out.println("\n*** getFuelCalculation() function called ***");
        return "N";
    }

    private boolean doAction(String calculateFuelOption) {
        System.out.println("\n*** doAction() function called ***");
        return true;
    }
    
    public String getInput() {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;
        
        while (!valid) {
            
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() < 1) {
                System.out.println("\n*** Invalid selection. Please try again ***");
                continue;
            }
            break;
        }
        return selection;
    }
    }
    

