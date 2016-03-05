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
public class CalculateEnergyView extends View {
    
    public CalculateEnergyView () {
    super("This is the calculate energy view.");
}
    
    private String getEnergyCalculation () {
        System.out.println("You have successfully called the 'getEnergyCalculation' function");
        return "N";
    }
    
    @Override
    public boolean doAction (String calculateEnergyOption) {
        int distance = 0;
        int amount = 0;
        int harvest = 0;
        int buggy = 0;
        
        double totalEnergy = RobotControl.calculateEnergy(distance, amount, harvest, buggy);
        return true;
    }
    
}
