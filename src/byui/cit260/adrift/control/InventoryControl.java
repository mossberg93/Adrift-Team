/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import byui.cit260.adrift.model.Inventory;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Philip
 */
public class InventoryControl {
    
    public static void initilizeInventory(HashMap<String, Inventory> inventory) {
        
        Inventory inventoryItem = null;       
        ArrayList<String> invTypes = new ArrayList<String>();
        invTypes.add("iron");
        invTypes.add("aluminum");
        invTypes.add("ice");        
        invTypes.add("copper");        
        invTypes.add("uranium");        
        invTypes.add("diamond");        
        invTypes.add("water"); 
        invTypes.add("food"); 
        invTypes.add("fuel");        
        invTypes.add("o2Tank");  
        invTypes.add("drill");  
        invTypes.add("repairModule");  
        
        for (String invType : invTypes) {
            
            inventoryItem = new Inventory();
            inventoryItem.setInventoryType(invType);
            inventoryItem.setQuantityInStock(0);
            inventory.put(invType, inventoryItem);
        }        
    }
    
    public static String adjustPreMissionSupplies(String type, HashMap<String, Inventory> inventory) {
        
        int amount = inventory.get(type).getQuantityInStock();
        int inventoryTotal = inventory.get("food").getQuantityInStock() + 
            inventory.get("water").getQuantityInStock() + 
            inventory.get("o2Tank").getQuantityInStock() + 
            inventory.get("drill").getQuantityInStock() + 
            inventory.get("fuel").getQuantityInStock() +  
            inventory.get("repairModule").getQuantityInStock();
        
        if (amount == 0) {
            
            if (inventoryTotal == 3) {
                return "Invalid selection: 3 items have already been chosen.";
            }

            inventory.get(type).setQuantityInStock(1);
        }
        else {
            inventory.get(type).setQuantityInStock(0);
        }
        
        return null;
    }
}
