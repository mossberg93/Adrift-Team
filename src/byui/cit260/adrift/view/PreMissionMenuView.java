/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.InventoryControl;
import byui.cit260.adrift.model.Inventory;
import java.util.HashMap;

/**
 *
 * @author Philip
 */
public class PreMissionMenuView extends View{
    
    private String inputError;
    private String message;
    private HashMap<String, Inventory> inventory;
        
    public PreMissionMenuView() {
        super();
        inventory = AdriftTeam.getInventory();
        message = this.buildMenu(inventory);
        
        super.setDisplayMessage(message);
    }

    public boolean doAction (String input) {
        
        boolean done = false;
        char choice;
        choice = input.toLowerCase().charAt(0);	
        
        switch(choice) {
            case 'r': // rations
                inputError = InventoryControl.adjustPreMissionSupplies("food", inventory);
                break;
            case 'w': // water
                inputError = InventoryControl.adjustPreMissionSupplies("water", inventory);
                break;
            case 't': // o2Tank
                inputError = InventoryControl.adjustPreMissionSupplies("o2Tank", inventory);
                break;
            case 'd': // drill
                inputError = InventoryControl.adjustPreMissionSupplies("drill", inventory);
                break;
            case 'f': // fuel
                inputError = InventoryControl.adjustPreMissionSupplies("fuel", inventory);
                break; 
            case 'm': // repairModule
                inputError = InventoryControl.adjustPreMissionSupplies("repairModule", inventory);
                break;                
            case 'e': // done
                done = true;                
                break;
            default:
                inputError = "Invalid selection: Try again";
                break;
        }
        
        if (inputError != null) {
            System.out.println(inputError);
            inputError = null;
        }  
        
        
        if (done) {
            this.displayNextView();
        } else {
            message = this.buildMenu(inventory);
            super.setDisplayMessage(message);
        }
        

        return done;
    }    

    private String buildMenu(HashMap<String, Inventory> inventory) {
        
        String menu = "\n"
            + "\n---------------------------------------"
            + "\n Pre-Mission Supplies                  |"
            + "\n---------------------------------------"
            + "\nR - " + inventory.get("food").getQuantityInStock() + " x  Emergency Food Rations"
            + "\nW - " + inventory.get("water").getQuantityInStock() + " x  Water"
            + "\nT - " + inventory.get("o2Tank").getQuantityInStock() + " x  O2 Tank"
            + "\nD - " + inventory.get("drill").getQuantityInStock() + " x  Mining Drill"
            + "\nF - " + inventory.get("fuel").getQuantityInStock() + " x  Fuel"
            + "\nM - " + inventory.get("repairModule").getQuantityInStock() + " x  Repair Module"
            + "\nE - Exit"
            + "\n---------------------------------------"
            + "\nYou may select 3 mission supplies to bring with you."
            + "\nSelecting an item again will remove it from the list."
            + "\nSelect a pre-mission supply>";
        
        return menu;
    }

    private void displayNextView() {    
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }
}
