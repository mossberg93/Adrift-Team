/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Scene;

/**
 *
 * @author Philip
 */
public class MapControl {

    private static Scene[] createScenes() {

        Game game = AdriftTeam.getCurrentGame();

        Scene[] scenes = new Scene[SceneType.values().length];

        Scene aluminumMine = new Scene();
        aluminumMine.setDescription("A rich mine filled with aluminum.");
        aluminumMine.setMapSymbol("AM");
        scenes[SceneType.aluminumMine.ordinal()] = aluminumMine;

        Scene asteroidPlain = new Scene();
        asteroidPlain.setDescription("A barren asteroid plain with no resources.");
        asteroidPlain.setMapSymbol("AP");
        scenes[SceneType.asteroidPlain.ordinal()] = asteroidPlain;

        Scene copperMine = new Scene();
        copperMine.setDescription("A rich mine filled with copper.");
        copperMine.setMapSymbol("CM");
        scenes[SceneType.copperMine.ordinal()] = copperMine;

        Scene diamondMine = new Scene();
        diamondMine.setDescription("A rich mine filled with diamonds.");
        diamondMine.setMapSymbol("DM");
        scenes[SceneType.diamondMine.ordinal()] = diamondMine;

        Scene iceField = new Scene();
        iceField.setDescription("A field of ice.");
        iceField.setMapSymbol("IF");
        scenes[SceneType.iceField.ordinal()] = iceField;

        Scene ironMine = new Scene();
        ironMine.setDescription("A rich mine filled with iron.");
        ironMine.setMapSymbol("IM");
        scenes[SceneType.ironMine.ordinal()] = ironMine;

        Scene nasaBase = new Scene();
        nasaBase.setDescription("The NASA Base is your base of operations and"
            + " where you must repair your ship to return home.");
        nasaBase.setMapSymbol("NB");
        scenes[SceneType.nasaBase.ordinal()] = nasaBase;

        Scene outpost = new Scene();
        outpost.setDescription("This is an abandoned outpost.");
        outpost.setMapSymbol("NB");
        scenes[SceneType.outpost.ordinal()] = outpost;

        Scene uraniumMine = new Scene();
        uraniumMine.setDescription("A rich mine filled with uranium.");
        uraniumMine.setMapSymbol("NB");
        scenes[SceneType.uraniumMine.ordinal()] = uraniumMine;

        return scenes;
    }

    public enum SceneType {
        aluminumMine,
        asteroidPlain,
        copperMine,
        diamondMine,
        iceField,
        ironMine,
        nasaBase,
        outpost,
        uraniumMine
    }

     public enum RowLetter {
        A,
        B,
        C,
        D,
        E
    }

    public static String getLocation() {
        System.out.println("Stub getLocation function called");
        return "C5";
    }

    public static boolean validateLocation(String location) {
        System.out.println("Stub validateLocation function called");
        return true;
    }

    public static int calculateDistance(String mapLoc, String mapDest) {
        System.out.println("Stub calculateDistance function called");
        return 5;
    }

     public static Map createMap() {
        Map map = new Map(5, 5);
        Scene[] scenes = createScenes();
        assignScenesToLocations(map, scenes);

        return map;
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
        locations[2][2].setVisited(true);
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
