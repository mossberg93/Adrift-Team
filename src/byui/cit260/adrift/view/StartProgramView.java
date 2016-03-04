/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author mossb
 */
public class StartProgramView extends View {
    
    private String promptMessage;
    
    public StartProgramView() {
        
        super(
            "\n*****************************************"
            +"\n*                                      *"
            +"\n* Welcome to the game of Adrift!       *"
            +"\n*                                      *"
            +"\n* In this game, you will assume the    *"
            +"\n* role of an astronaut hired by NASA   *"
            +"\n* in the year 2050 to lead mining      *"
            +"\n* operations that take place in the    *"
            +"\n* asteroid belt within our own solar   *"
            +"\n* system.                              *"
            +"\n*                                      *"
            +"\n* Disaster strikes the crew of your    *"
            +"\n* ship, and you must fight to preserve *"
            +"\n* your life and the lives of your      *"
            +"\n* team.  In this brave adventure, what *"
            +"\n* will you do to save your team and    *"
            +"\n* and survive against the odds? Will   *"
            +"\n* you be able to make it back home in  *"
            +"\n* one piece?                           *"
            +"\n*                                      *"
            +"\n* That is for you to decide!           *"
            +"\n*                                      *"
            +"\n****************************************"	
            +"\n"
            + "\nPlease enter your name: ");
    }

    @Override
    public boolean doAction(String playersName) {
        
        if (playersName.length() < 2) {
            System.out.println("\nInvalid players name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) {
            System.out.println("\nError creating the player.");
            return false;
        }
        
        this.displayNextView(player);
        
        return true;
    }

    private void displayNextView(Player player) {
        
        System.out.println(
               "\n*************************************"
               +"\n Welcome to the game " + player.getName()
               +"\n We hope you have a lot of fun!"
               +"\n*************************************"
        );
        
        PreMissionMenuView preMissionMenu = new PreMissionMenuView();
        preMissionMenu.display();

    }
}
    

