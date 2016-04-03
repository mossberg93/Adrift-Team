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
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.food.ordinal(), 10);
                    break;
                case 'w': // water
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.water.ordinal(), 10);
                    break;
                case 't': // o2Tank
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.o2Tank.ordinal(), 1);
                    break;
                case 'd': // drill
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.drill.ordinal(), 1);
                    break;
                case 'f': // fuel
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.fuel.ordinal(), 10);
                    break;
                case 'm': // repairModule
                    InventoryControl.adjustPreMissionSupplies(InventoryControl.Types.repairModule.ordinal(), 1);
                    break;
                case 'e': // done
                    done = true;
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "Invalid selection: Try again");
                    break;
            }
        } catch (InventoryControlException ie) {
            ErrorView.display(this.getClass().getName(), ie.getMessage());
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

        InventoryItem[] inventory = AdriftTeam.getGame().getPlayer().getInventory();

        String menu = "\n"
            + "\n---------------------------------------"
            + "\n Pre-Mission Supplies                  |"
            + "\n---------------------------------------"
            + "\nR - " + inventory[InventoryControl.Types.food.ordinal()].getAmount() + " x  Emergency Food Rations"
            + "\nW - " + inventory[InventoryControl.Types.water.ordinal()].getAmount() + " x  Water"
            + "\nT - " + inventory[InventoryControl.Types.o2Tank.ordinal()].getAmount() + " x  O2 Tank"
            + "\nD - " + inventory[InventoryControl.Types.drill.ordinal()].getAmount() + " x  Mining Drill"
            + "\nF - " + inventory[InventoryControl.Types.fuel.ordinal()].getAmount() + " x  Fuel"
            + "\nM - " + inventory[InventoryControl.Types.repairModule.ordinal()].getAmount() + " x  Repair Module"
            + "\nE - Exit"
            + "\n---------------------------------------"
            + "\nYou may select 3 mission supplies to bring with you."
            + "\nSelecting an item again will remove it from the list."
            + "\nSelect a pre-mission supply:";

        return menu;
    }

    private void displayNextView() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}
