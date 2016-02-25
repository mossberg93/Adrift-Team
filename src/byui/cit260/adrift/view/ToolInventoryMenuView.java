/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import java.util.Scanner;

/**
 *
 * @author mossb
 */
public class ToolInventoryMenuView {
    
    private String promptMessage = "Enter an object.";
    
    private final String TOOLMENU = "\n"
            + "\n------------------------------------------------------------"
            + "\n Tool Menu"
            + "\n------------------------------------------------------------"
            + "\nD - Mining Drill"
            + "\nS - Shovel"
            + "\nH - Hammer"
            + "\nT - Oxygen Tank"
            + "\nB - Buggy"
            + "\nQ - Quit"
            + "\n------------------------------------------------------------";
            
    private void displayToolMenu() {
        
        char selection = ' ';
        do {
            System.out.println(TOOLMENU);
            
            String input = this.getInput();
            selection = input.toLowerCase().charAt(0);
            
            this.doAction(selection);
        } while (selection != 'e');
    }

    private String getInput() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n + this.promptMessage");
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() != 1) {
                System.out.println("\nYou have entered an invalid value. Value must be 1 character.");
                continue;
            }
            break;
        }
        return value;
    }

    private void doAction(char selection) {
        
        switch(selection) {
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
                       
        }
            
    }
            
    
}
