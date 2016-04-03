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
public class CraftMenuView extends View {

    public CraftMenuView() {

        super();

        String menu;
        InventoryItem[] inventory = AdriftTeam.getGame().getPlayer().getInventory();

        menu = "\n---------------------------------------------";
        menu += String.format("\n%-15s %-10s %-8s %-8s|", "Craft Menu", "Resources", "Required", "Current");
        menu += "\n---------------------------------------------";
        menu += String.format("\n%-15s %-10s %-8s %-8s", "F - Fuel (10L)", "Uranium", "1", inventory[InventoryControl.Types.uranium.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "", "Water", "2", inventory[InventoryControl.Types.water.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "O - O2 Tank", "Aluminum", "2", inventory[InventoryControl.Types.aluminum.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "", "Iron", "1", inventory[InventoryControl.Types.iron.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "R - Repair", "Aluminum", "5", inventory[InventoryControl.Types.aluminum.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "    Module", "Copper", "5", inventory[InventoryControl.Types.copper.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "", "Diamond", "5", inventory[InventoryControl.Types.diamond.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "", "Iron", "5", inventory[InventoryControl.Types.iron.ordinal()].getAmount());
        //menu += String.format("\n%-15s %-10s %-8s %-8s", "", "Aluminum", "5", inventory[InventoryControl.Types.aluminum.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "W - Water (10L)", "Frozen Ice", "1", inventory[InventoryControl.Types.ice.ordinal()].getAmount());
        menu += String.format("\n%-15s %-10s %-8s %-8s", "E - Exit", "", "", "");
        menu += "\n---------------------------------------------";
        menu += "\nEnter an option: ";


        super.setDisplayMessage(menu);
    }

    @Override
    public boolean doAction(String input) {

        boolean done = false;
        char choice;
        choice = input.toLowerCase().charAt(0);

        try {
            switch(choice) {
                case 'f':
                    InventoryControl.createFuel();
                    break;
                case 'o':
                    InventoryControl.createO2Tank();
                    break;
                case 'r':
                    InventoryControl.createRepairModule();
                    break;
                case 'w':
                    InventoryControl.createWater();
                    break;
                case 'e':
                    this.console.println("Exit chosen");
                    done = true;
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "\nInvalid selection: Try again");
                    break;
            }
        } catch (InventoryControlException ie) {
            ErrorView.display(this.getClass().getName(), ie.getMessage());
        }

        return done;
    }
}
