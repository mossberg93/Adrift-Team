/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.model.Game;
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
        
        Scene startingScene = new Scene();
        startingScene.setDescription("This is the NASA base.");
        startingScene.setMapSymbol(" ST ");
        startingScene.setTravelTime(0);
        scenes[SceneType.nasaBase.ordinal()] = startingScene;
        return scenes;
    }
    
    public enum SceneType {
        ironMine,
        aluminumMine,
        copperMine,
        diamondMine,
        uraniumMine,
        outpost,
        iceField,
        nasaBase,
        asteroidPlain
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
    
     private static Map createMap() {
        Map map = new Map(5, 5);
        Scene[] scenes = createScenes();
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
     }
}
