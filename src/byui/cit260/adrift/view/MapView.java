/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.MapControl;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;

/**
 *
 * @author Philip
 */
public class MapView {

    public MapView() {

    }

    public void displayMap() {
        Map map = AdriftTeam.getCurrentGame().getMap();
        String keySeperator = "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
        String rowSeperator = "--------------------------";
        String colSeperator = "|";
        String keyDisplay;
        String mapDisplay = rowSeperator;
        String playerLoc = AdriftTeam.getPlayer().getLocation();

        keyDisplay = keySeperator
            + "\nAM = Aluminum Mine \t IM = Iron Mine"
            + "\nAP = Asteroid Plain \t NB = NASA Base"
            + "\nCP = Copper Mine \t OP = Outpost"
            + "\nDM = Diamond Mine \t UM = Uranium Mine"
            + "\nIF = Ice Field \t\t UE = Unexplored"
            + "\n* indicates current location"
            + "\n" + keySeperator;

        Location[][] locations = map.getLocations();

        for (int row = 0; row < locations.length; row++) {

            mapDisplay += "\n" + colSeperator;

            for(int col = 0; col < locations[row].length; col++) {
                String mapLoc =  MapControl.RowLetter.values()[row].name() + (col + 1);

                if (mapLoc.equals(playerLoc)) {
                    mapDisplay += "*" + mapLoc + "*" + colSeperator;
                }
                else {
                    mapDisplay += " " + mapLoc + " " + colSeperator;
                }
            }

            mapDisplay += "\n" + colSeperator;

            for(int col = 0; col < locations[row].length; col++) {

                String mapSymbol = "UE";

                if (locations[row][col].isVisited()) {
                    mapSymbol = locations[row][col].getScene().getMapSymbol();
                }

                mapDisplay += " " + mapSymbol + " " + colSeperator;
            }

            mapDisplay += "\n" + rowSeperator;
        }

        System.out.println(keyDisplay);
        System.out.println(mapDisplay);
    }
}
