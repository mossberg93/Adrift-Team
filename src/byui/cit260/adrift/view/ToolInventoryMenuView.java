/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

/**
 *
 * @author mossb
 */
public class ToolInventoryMenuView extends View {

    public ToolInventoryMenuView () {
        super("\n"
            + "\n------------------------------------------------------------"
            + "\n Tool Menu"
            + "\n------------------------------------------------------------"
            + "\nD - Mining Drill"
            + "\nS - Shovel"
            + "\nH - Hammer"
            + "\nT - Oxygen Tank"
            + "\nB - Buggy"
            + "\nQ - Quit"
            + "\n------------------------------------------------------------"
            + "\nEnter an object.");
    }

    @Override
    public boolean doAction(String input) {

        boolean done = false;
        char choice;
        choice = input.toLowerCase().charAt(0);

        switch(choice) {
           case 'd' : // equip mining drill
                System.out.println("\nYou have equipped the mining drill.");
                break;
           case 's' : //equip shovel
               System.out.println("\nYou have equippped the shovel.");
               break;
           case 'h' : // equip hammer
               System.out.println("\nYou have equipped the hammer.");
               break;
           case 't' : // oxygen tank
               System.out.println("\nYou have equipped the oxygen tank.");
               break;
           case 'b' : // equip buggy
               System.out.println("\nYou have entered the buggy.");
               break;
           case 'e' : // exit menu
               System.out.println("\n Exited the menu");
               done = true;
               break;
            default:
                System.out.println("\nInvalid selection: Try again");
                break;
        }
       return done;

    }

}
