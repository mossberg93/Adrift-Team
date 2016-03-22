/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.exceptions.GameControlException;
import byui.cit260.adrift.exceptions.MapControlException;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Ship;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

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

    public static void createNewGame(Player player) throws MapControlException {
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

        moveToLocation("c3");
    }

    public static void saveGame(Game game, String filePath)
        throws GameControlException {

        try(FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);

            output.writeObject(game);
        }
        catch(IOException e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void loadGame(String filePath) throws GameControlException {
        Game game = null;

        try(FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);

            game = (Game) input.readObject();
        }
        catch(FileNotFoundException fnfe) {
            throw new GameControlException(fnfe.getMessage());
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }

        AdriftTeam.setGame(game);
    }

    public static void moveToLocation (String location) throws MapControlException {

        MapControl.validateLocation(location);

        AdriftTeam.getGame().getPlayer().setLocation(location);
        MapControl.setLocationVisited(location);

    }

    public static void saveReport(String report, String filePath)
                throws GameControlException {

        try(PrintWriter reportFile = new PrintWriter(filePath)) {
            reportFile.println(report);
        } catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
}
