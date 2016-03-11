/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.MapControl.SceneType;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Scene;
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
    
    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        locations[0][0].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.outpost.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.ironMine.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.aluminumMine.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.uraniumMine.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.copperMine.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.outpost.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.ironMine.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.nasaBase.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.uraniumMine.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.outpost.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.aluminumMine.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.iceField.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.copperMine.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.asteroidPlain.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.outpost.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.diamondMine.ordinal()]);
    }

}
