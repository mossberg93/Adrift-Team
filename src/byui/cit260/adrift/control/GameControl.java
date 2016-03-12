/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Ship;

/**
 *
 * @author Philip
 */
public class GameControl {

    public static Player createPlayer(String name) {

        Player player = new Player();
        player.setName(name);

        AdriftTeam.setPlayer(player);

        return player;
    }

    public static void createNewGame(Player player) {
        Game game = new Game();

        game.setPlayer(player);

        Ship ship = new Ship();
        game.setShip(ship);

        Map map = MapControl.createMap();
        game.setMap(map);

        InventoryItem[] inventory;
        inventory = InventoryControl.initilizeInventory(); //Initilize inventory
        game.setInventory(inventory);

        AdriftTeam.setGame(game);

        moveToLocation("C3");
    }

    public static void saveGame() {
        System.out.println("\n*** saveGame stub function called ***");
    }

    public static void loadGame() {
        System.out.println("\n*** loadGame stub function called ***");
    }

    private static void moveToLocation(String location) {

        boolean valid = MapControl.validateLocation(location);
        if (valid) {
            AdriftTeam.getGame().getPlayer().setLocation(location);
            MapControl.setLocationVisited(location);
        }
    }
}
