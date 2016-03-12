/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift.team;

import byui.cit260.adrift.model.*;
import byui.cit260.adrift.view.*;

/**
 *
 * @author Philip
 */
public class AdriftTeam {

    private static Player player = null;
    private static Game game = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create StartProgramViewOrig and display the start
        // program view
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        AdriftTeam.player = player;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game currentGame) {
        AdriftTeam.game = currentGame;
    }
}
