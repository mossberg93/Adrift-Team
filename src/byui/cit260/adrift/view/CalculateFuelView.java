/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.control.RobotControl;
import java.util.Scanner;

/**
 *
 * @author mossb
 */
public class CalculateFuelView extends View {
    
    public CalculateFuelView() {
        super("This is the function to calculate the amount of fuel needed");
    }

    private String getFuelCaclulation() {
        System.out.println("\n*** getFuelCalculation() function called ***");
        return "N";
    }

    @Override
    public boolean doAction(String calculateFuelOption) {
        int destination = 0;
        int amount = 0;
        System.out.println("\n*** doAction() function called ***");
        double totalfuel = RobotControl.calculateFuel(destination, amount);
        return true;
    }
}
    

