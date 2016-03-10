/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import byui.cit260.adrift.model.InventoryItem;

/**
 *
 * @author Philip
 */
public class InventoryControl {

    public enum Types {
        aluminum,
        copper,
        diamond,
        food,
        fuel,
        iron,
        ice,
        uranium,
        water,
        o2Tank,
        drill,
        repairModule
    };

    public static InventoryItem[] initilizeInventory() {

        InventoryItem[] inventory =
            new InventoryItem[Types.values().length];

        for (Types type : Types.values()) {

            InventoryItem item = new InventoryItem();
            item.setType(type.name());
            item.setQuantityInStock(0);
            inventory[type.ordinal()] = item;
        }

        return inventory;
    }

    public static String adjustPreMissionSupplies(int index, InventoryItem[] inventory) {

        int amount = inventory[index].getQuantityInStock();
        int inventoryTotal = 0;

//        = inventory.get("food").getQuantityInStock() +
//            inventory.get("water").getQuantityInStock() +
//            inventory.get("o2Tank").getQuantityInStock() +
//            inventory.get("drill").getQuantityInStock() +
//            inventory.get("fuel").getQuantityInStock() +
//            inventory.get("repairModule").getQuantityInStock();

        for (Types type : Types.values()) {

            inventoryTotal += inventory[type.ordinal()].getQuantityInStock();
        }

        if (amount == 0) {

            if (inventoryTotal == 3) {
                return "Invalid selection: 3 items have already been chosen.";
            }

            inventory[index].setQuantityInStock(1);
        }
        else {
            inventory[index].setQuantityInStock(0);
        }

        return null;
    }
}
