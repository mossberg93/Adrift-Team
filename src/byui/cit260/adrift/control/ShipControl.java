/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Ship;

/**
 *
 * @author Philip
 */
public class ShipControl {

    public static int repairShip() {

        InventoryItem repairModule = AdriftTeam.getGame().getPlayer().getInventory()[InventoryControl.Types.repairModule.ordinal()];
        Ship ship = AdriftTeam.getGame().getShip();
        int repaired = 0;

        if (repairModule.getAmount() >= ship.getDamage()) {
            repaired = ship.getDamage();
            repairModule.setAmount(repairModule.getAmount() - ship.getDamage());
            ship.setDamage(0);
        } else if (ship.getDamage() > repairModule.getAmount()) {
            repaired = repairModule.getAmount();
            ship.setDamage(ship.getDamage() - repairModule.getAmount());
            repairModule.setAmount(0);
        }

        return repaired;
    }

}
