/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.exceptions.MapControlException;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Scene;
import static java.lang.Math.abs;

/**
 *
 * @author Philip
 */
public class MapControl {

    private static Scene[] createScenes() {

        Game game = AdriftTeam.getGame();

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
        outpost.setMapSymbol("OP");
        scenes[SceneType.outpost.ordinal()] = outpost;

        Scene uraniumMine = new Scene();
        uraniumMine.setDescription("A rich mine filled with uranium.");
        uraniumMine.setMapSymbol("UM");
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

    public static void validateLocation(String location) throws MapControlException {

        Location[][] locations = AdriftTeam.getGame().getMap().getLocations();
        int row = MapControl.getRowFromLocation(location);
        int col = MapControl.getColFromLocation(location);

        // check if row is a valid index
        if (row < 0 || row >= locations.length ||
            col < 0 || col >= locations[row].length) {

            throw new MapControlException("Location " + location + " is "
                + "invalid because it's outside the bounds of the map.");
        }
    }

    public static int calculateDistance(String startLoc, String destLoc) {

        int startRow = MapControl.getRowFromLocation(startLoc);
        int startCol = MapControl.getColFromLocation(startLoc);
        int destRow = MapControl.getRowFromLocation(destLoc);
        int destCol = MapControl.getColFromLocation(destLoc);

        int totalDistance = abs(startRow - destRow) + abs(startCol - destCol);

        return totalDistance;
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

    public static int getRowFromLocation(String location) {

        char rowLetter = location.toLowerCase().charAt(0);
        int row = -1;

        switch(rowLetter) {
           case 'a' :
                row = MapControl.RowLetter.A.ordinal();
                break;
           case 'b' :
                row = MapControl.RowLetter.B.ordinal();
                break;
           case 'c' :
                row = MapControl.RowLetter.C.ordinal();
                break;
           case 'd' :
                row = MapControl.RowLetter.D.ordinal();
                break;
           case 'e' :
                row = MapControl.RowLetter.E.ordinal();
                break;
        }

        return row;
    }

    public static int getColFromLocation(String location) {

        return Character.getNumericValue(location.charAt(1)) - 1;
    }

    static void setLocationVisited(String location) {

        Location[][] locations = AdriftTeam.getGame().getMap().getLocations();
        int row = MapControl.getRowFromLocation(location);
        int col = MapControl.getColFromLocation(location);

        //System.out.println("R " + row + " C " + col);

        locations[row][col].setVisited(true);
    }

    public static String getMapStats() {

        int am = 0;
        int ap = 0;
        int cm = 0;
        int dm = 0;
        int ip = 0;
        int im = 0;
        int nb = 0;
        int op = 0;
        int um = 0;
        int i = 0;
        int[] mapItems = new int[25];

        Location[][] locations = AdriftTeam.getGame().getMap().getLocations();
        String results = null;

        for (int row = 0; row < locations.length; row++) {

            for(int col = 0; col < locations[row].length; col++) {

                mapItems[i] = locations[row][col].getAmountRemaining();
                i++;

                if(!(locations[row][col].isVisited())) {

                    String symbol = locations[row][col].getScene().getMapSymbol();

                    switch(symbol) {
                        case "AM" :
                            am++;
                            break;
                        case "AP" :
                            ap++;
                            break;
                        case "CM":
                            cm++;
                            break;
                        case "DM":
                            dm++;
                            break;
                        case "IF":
                            ip++;
                            break;
                        case "IM":
                            im++;
                            break;
                        case "NB":
                            nb++;
                            break;
                        case "OP":
                            op++;
                            break;
                        case "UM":
                            um++;
                            break;
                    }
                }
            }
        }

        results = "\nThe following areas are still unexplored."
            + "\nScene\t\tNumber Unexplored"
            + "\n-----------------------------------------";

        if (am > 0) {
            results += "\nAluminum Mine\t" + am;
        }

        if (ap > 0) {
            results += "\nAsteroid Plain\t" + ap;
        }

        if (cm > 0) {
            results += "\nCopper Mine\t" + cm;
        }

        if (dm > 0) {
            results += "\nDiamond Mine\t" + dm;
        }

        if (ip > 0) {
            results += "\nIce Fields\t" + ip;
        }

        if (im > 0) {
            results += "\nIron Mine\t" + im;
        }

        if (nb > 0) {
            results += "\nNasa Base\t" + nb;
        }

        if (op > 0) {
            results += "\nOutpost\t\t" + op;
        }

        results += "\n\nTotal items remaining: " + sum(mapItems);

        return results;
    }

    public static int sum(int[] list) {

        int total = 0;

        for(int num: list) {
            total += num;
        }

        return total;
    }
}
