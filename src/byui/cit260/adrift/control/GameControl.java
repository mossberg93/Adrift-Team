/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import byui.cit260.adrift.model.Player;

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
        System.out.println("\n*** createNewGame stub function called ***");
    }

    public static void saveGame() {
        System.out.println("\n*** saveGame stub function called ***");
    }

    public static void loadGame() {
        System.out.println("\n*** loadGame stub function called ***");
    }
    
}
