/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Ship;

/**
 *
 * @author Philip
 */
public class GameControl {

    public static Player createPlayer(String playersName) {

        // create and save the player object
        Player player = ProgramControl.createPlayer(playersName);
        return player;
    }

    public static void createNewGame(Player player) {
        Game game = new Game();
        AdriftTeam.setPlayer(player);

        game.setPlayer(player);

        Ship ship = new Ship();
        game.setShip(ship);

        //Map map = MapControl.createMap();
        //game.setMap(map);

        //MapControl.moveActorsToStartingLocation(map);

    }

    public static void saveGame() {
        System.out.println("\n*** saveGame stub function called ***");
    }

    public static void loadGame() {
        System.out.println("\n*** loadGame stub function called ***");
    }

}
