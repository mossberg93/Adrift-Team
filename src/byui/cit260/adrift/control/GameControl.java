/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Map;
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
        AdriftTeam.setCurrentGame(game);

        game.setPlayer(player);

        Ship ship = new Ship();
        game.setShip(ship);

        Map map = MapControl.createMap();
        game.setMap(map);

        moveToLocation("C3");
    }

    public static void saveGame() {
        System.out.println("\n*** saveGame stub function called ***");
    }

    public static void loadGame() {
        System.out.println("\n*** loadGame stub function called ***");
    }

    private static void moveToLocation(String location) {

        char rowLetter = location.charAt(0);
        int row;
        int column = Character.getNumericValue(location.charAt(1)) + 1;

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

        AdriftTeam.getPlayer().setLocation(location);
    }
}
