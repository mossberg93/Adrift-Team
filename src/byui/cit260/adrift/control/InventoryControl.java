/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.exceptions.InventoryControlException;
import byui.cit260.adrift.model.InventoryItem;

/**
 *
 * @author Philip
 */
public class InventoryControl {

    public enum Types {
        aluminum(0, 100),
        copper(0, 100),
        diamond(0, 100),
        drill(1, 1),
        food(75, 100),
        fuel(75, 100),
        iron(0, 100),
        ice(0, 100),
        o2Tank(1, 4),
        repairModule(1, 4),
        uranium(0, 100),
        water(75, 100);

        private final int start;
        private final int max;

        Types(int start, int max) {
            this.start = start;
            this.max = max;
        }

        public int getStart() {
            return start;
        }

        public int getMax() {
            return max;
        }
    };

    public static InventoryItem[] initilizeInventory() {

        InventoryItem[] inventory =
            new InventoryItem[Types.values().length];

        for (Types type : Types.values()) {

            InventoryItem item = new InventoryItem();
            item.setType(type.name());
            item.setAmount(0);
            item.setMaxAmount(type.getMax());
            inventory[type.ordinal()] = item;
        }

        return inventory;
    }

    public static void adjustPreMissionSupplies(int index, int increase) throws InventoryControlException {

        InventoryItem[] inventory = AdriftTeam.getGame().getPlayer().getInventory();
        int amount = inventory[index].getAmount();
        int inventoryTotal = 0;

        inventoryTotal = (inventory[Types.food.ordinal()].getAmount()/10)
            + (inventory[Types.water.ordinal()].getAmount()/10)
            + inventory[Types.o2Tank.ordinal()].getAmount()
            + inventory[Types.drill.ordinal()].getAmount()
            + (inventory[Types.fuel.ordinal()].getAmount()/10)
            + inventory[Types.repairModule.ordinal()].getAmount();

        //for (Types type : Types.values()) {

            //inventoryTotal += inventory[type.ordinal()].getAmount();
        //}

        if (amount == 0) {

            if (inventoryTotal == 3) {
                throw new InventoryControlException("Invalid selection: 3 items"
                    + " have already been chosen.");
            }

            inventory[index].setAmount(increase);
        }
        else {
            inventory[index].setAmount(0);
        }
    }

    public static void createFuel() throws InventoryControlException {
        InventoryItem[] inventory = AdriftTeam.getGame().getPlayer().getInventory();

        int curUranium = inventory[Types.uranium.ordinal()].getAmount();
        int curWater = inventory[Types.water.ordinal()].getAmount();
        int curFuel = inventory[Types.fuel.ordinal()].getAmount();

        if ( curUranium < 1 || curWater < 2) {
            throw new InventoryControlException("Isufficient resources to create Fuel");
        }

        inventory[Types.uranium.ordinal()].setAmount(curUranium - 1);
        inventory[Types.water.ordinal()].setAmount(curWater - 2);
        inventory[Types.fuel.ordinal()].setAmount(curFuel + 10);
    }

    public static void createO2Tank() throws InventoryControlException {
        InventoryItem[] inventory = AdriftTeam.getGame().getPlayer().getInventory();

        int curAlum = inventory[Types.aluminum.ordinal()].getAmount();
        int curIron = inventory[Types.iron.ordinal()].getAmount();
        int curO2Tank = inventory[Types.o2Tank.ordinal()].getAmount();

        if (curAlum < 2 || curIron < 1) {
            throw new InventoryControlException("Isufficient resources to create O2Tank");
        }

        inventory[Types.aluminum.ordinal()].setAmount(curAlum - 2);
        inventory[Types.iron.ordinal()].setAmount(curIron - 1);
        inventory[Types.o2Tank.ordinal()].setAmount(curO2Tank + 1);
    }

    public static void createRepairModule() throws InventoryControlException {
        InventoryItem[] inventory = AdriftTeam.getGame().getPlayer().getInventory();

        int curAlum = inventory[Types.aluminum.ordinal()].getAmount();
        int curCopper = inventory[Types.copper.ordinal()].getAmount();
        int curDiamond = inventory[Types.diamond.ordinal()].getAmount();
        int curIron = inventory[Types.iron.ordinal()].getAmount();
        int curRM = inventory[Types.repairModule.ordinal()].getAmount();

        if (curAlum < 5 || curCopper < 5 || curDiamond < 5 || curIron < 5) {
            throw new InventoryControlException("Isufficient resources to create Repair Module");
        }

        inventory[Types.aluminum.ordinal()].setAmount(curAlum - 5);
        inventory[Types.copper.ordinal()].setAmount(curCopper - 5);
        inventory[Types.diamond.ordinal()].setAmount(curDiamond - 5);
        inventory[Types.iron.ordinal()].setAmount(curIron - 5);
        inventory[Types.repairModule.ordinal()].setAmount(curRM + 1);
    }

    public static void createWater() throws InventoryControlException {
        InventoryItem[] inventory = AdriftTeam.getGame().getPlayer().getInventory();

        int curIce = inventory[Types.ice.ordinal()].getAmount();
        int curWater = inventory[Types.water.ordinal()].getAmount();

        if (curIce < 1) {
            throw new InventoryControlException("Isufficient resources to create water");
        }

        inventory[Types.ice.ordinal()].setAmount(curIce - 1);
        inventory[Types.water.ordinal()].setAmount(curWater + 10);
    }
}
