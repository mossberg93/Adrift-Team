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
                this.console.println("\nYou have equipped the mining drill.");
                break;
           case 's' : //equip shovel
               this.console.println("\nYou have equippped the shovel.");
               break;
           case 'h' : // equip hammer
               this.console.println("\nYou have equipped the hammer.");
               break;
           case 't' : // oxygen tank
               this.console.println("\nYou have equipped the oxygen tank.");
               break;
           case 'b' : // equip buggy
               this.console.println("\nYou have entered the buggy.");
               break;
           case 'e' : // exit menu
               this.console.println("\n Exited the menu");
               done = true;
               break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid selection: Try again");
                break;
        }
       return done;

    }

}
