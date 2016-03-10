/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.InventoryControl;
import byui.cit260.adrift.model.InventoryItem;

/**
 *
 * @author Philip
 */
public class PreMissionMenuView extends View{

    private String inputError;
    private String message;
    private InventoryItem[] inventory;

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
                inputError = InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.food.ordinal(), inventory);
                break;
            case 'w': // water
                inputError = InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.water.ordinal(), inventory);
                break;
            case 't': // o2Tank
                inputError = InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.o2Tank.ordinal(), inventory);
                break;
            case 'd': // drill
                inputError = InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.drill.ordinal(), inventory);
                break;
            case 'f': // fuel
                inputError = InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.fuel.ordinal(), inventory);
                break;
            case 'm': // repairModule
                inputError = InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.repairModule.ordinal(), inventory);
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

    private String buildMenu(InventoryItem[] inventory) {

        String menu = "\n"
            + "\n---------------------------------------"
            + "\n Pre-Mission Supplies                  |"
            + "\n---------------------------------------"
            + "\nR - " + inventory[InventoryControl.Types.food.ordinal()].getQuantityInStock() + " x  Emergency Food Rations"
            + "\nW - " + inventory[InventoryControl.Types.water.ordinal()].getQuantityInStock() + " x  Water"
            + "\nT - " + inventory[InventoryControl.Types.o2Tank.ordinal()].getQuantityInStock() + " x  O2 Tank"
            + "\nD - " + inventory[InventoryControl.Types.drill.ordinal()].getQuantityInStock() + " x  Mining Drill"
            + "\nF - " + inventory[InventoryControl.Types.fuel.ordinal()].getQuantityInStock() + " x  Fuel"
            + "\nM - " + inventory[InventoryControl.Types.repairModule.ordinal()].getQuantityInStock() + " x  Repair Module"
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
