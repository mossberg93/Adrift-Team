/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.InventoryControl;
import byui.cit260.adrift.exceptions.InventoryControlException;
import byui.cit260.adrift.model.InventoryItem;

/**
 *
 * @author Philip
 */
public class PreMissionMenuView extends View{

    private String message;

    public PreMissionMenuView() {
        super();
        message = this.buildMenu();
        super.setDisplayMessage(message);
    }

    @Override
    public boolean doAction (String input) {

        boolean done = false;
        char choice;
        choice = input.toLowerCase().charAt(0);

        try {
            switch (choice) {
                case 'r': // rations
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.food.ordinal());
                    break;
                case 'w': // water
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.water.ordinal());
                    break;
                case 't': // o2Tank
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.o2Tank.ordinal());
                    break;
                case 'd': // drill
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.drill.ordinal());
                    break;
                case 'f': // fuel
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.fuel.ordinal());
                    break;
                case 'm': // repairModule
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.repairModule.ordinal());
                    break;
                case 'e': // done
                    done = true;
                    break;
                default:
                    System.out.println("Invalid selection: Try again");
                    break;
            }
        } catch (InventoryControlException ie) {
            System.out.println(ie.getMessage());
        }

        if (done) {
            this.displayNextView();
        } else {
            message = this.buildMenu();
            super.setDisplayMessage(message);
        }


        return done;
    }

    private String buildMenu() {

        InventoryItem[] inventory = AdriftTeam.getGame().getInventory();

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
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}
