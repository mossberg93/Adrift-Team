/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.control.RobotControl;

/**
 *
 * @author mossb
 */
public class CalculateFuelView extends View {

    public CalculateFuelView() {
        super("This is the function to calculate the amount of fuel needed");
    }

    private String getFuelCaclulation() {
        this.console.println("\n*** getFuelCalculation() function called ***");
        return "N";
    }

    @Override
    public boolean doAction(String calculateFuelOption) {
        int destination = 0;
        int amount = 0;
        this.console.println("\n*** doAction() function called ***");
        double totalfuel = RobotControl.calculateFuel(destination, amount);
        return true;
    }
}


