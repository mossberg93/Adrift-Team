/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.control.InventoryControl;
import java.util.Scanner;
import byui.cit260.adrift.model.Inventory;
import java.util.HashMap;

/**
 *
 * @author Philip
 */
public class PreMissionMenuView {
    
    private String inputError;
    
    public void displayPreMissionMenu() {
        
        // Eventually the inventory will be initilized in a better location
        HashMap<String, Inventory> inventory = new HashMap();
        InventoryControl.initilizeInventory(inventory);  
        
        String menu;
        
        char selection = ' ';
        do {
            
            menu = this.buildMenu(inventory);
            
            System.out.println(menu);
            
            String input = this.getInput();
            selection = input.toLowerCase().charAt(0);
            
            this.doAction(selection, inventory);
            
        } while (selection != 'e');
    }
        
    private String getInput() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        String promptMessage = "You may select 3 mission supplies to bring with you."
                + "\nSelecting an item again will remove it from the list. "
                + "\nSelect a pre-mission supply> ";
        boolean valid = false; // initialize to not valid

        while (!valid) { 
            
            if (inputError != null) {
                System.out.println(inputError);
                inputError = null;
            }  
            
            System.out.println("\n" + promptMessage);

            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim of leading and trailing blanks

            if (value.length() != 1) { // value is blank
                inputError = "\nInvalid value: value must be 1 charachter";
                continue;
            }

            break; // end the loop
        }

        return value;               
    }

    private void doAction(char choice, HashMap<String, Inventory> inventory) {
        
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
                break;
            default:
                inputError = "Invalid selection: Try again";
                break;
        }
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
            + "\n---------------------------------------";
        
        return menu;
    }
}
