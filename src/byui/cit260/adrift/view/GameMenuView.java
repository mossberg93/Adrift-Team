/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

/**
 *
 * @author Philip
 */
public class GameMenuView extends View {
    
    public GameMenuView() {
        
        super("\n"
            + "\n---------------------------------------"
            + "\n Game Menu                            |"
            + "\n---------------------------------------"			
            + "\nM - Map"
            + "\nI - Inventory"
            + "\nS - Ship Status"
            + "\nX - Explore Location"
            + "\nV - Move"
            + "\nG - Calculate Energy"
            + "\nF - Calculate Fuel"
            + "\nO - Calculate O2"
            + "\nC - Craft Tools"
            + "\nR - Harvest Resources"
            + "\nD - Deliver Resource"
            + "\nP - Repair Ship"
            + "\nL - Launch Ship"
            + "\nH - Help Menu"
            + "\nE - Exit"
            + "\n---------------------------------------"
            + "\n"
            + "\nEnter an option: ");
    }

    @Override
    public boolean doAction(String input) {
        
        boolean done = false;
        char choice;
        choice = input.toLowerCase().charAt(0);		
        
        switch(choice) {
            case 'm':
                System.out.println("Display map chosen");
                break;
            case 'i': 
                System.out.println("Display inventory chosen");
                break;
            case 's':
                System.out.println("Display ship chosen");
                break;
            case 'x':
                System.out.println("Explore location chosen");
                break;
            case 'v':
                System.out.println("Move chosen");
                break;
            case 'g':
                System.out.println("Calc energy chosen");
                break;
            case 'f':
                System.out.println("Calc fuel chosen");
                break;
            case 'o':
                System.out.println("Calc O2 chosen");
                //CalculateO2View calculateO2 = new CalculateO2View();
                //calculateO2.displayCalculateO2();                
                break;                
            case 'c':
                System.out.println("craft tools chosen");
                break;
            case 'r':
                System.out.println("Harvest resources chosen");
                break;
            case 'd':
                System.out.println("Deliver resources chosen");
                break;
            case 'p':
                System.out.println("Repair ship chosen");
                break;
            case 'l':
                System.out.println("Launch ship chosen");
                break;
            case 'h':
                System.out.println("Help menu chosen");
                this.displayHelpMenu();
                break;
            case 'e':
                System.out.println("Exit chosen");
                done = true;
                break;				
            default:
                System.out.println("\nInvalid selection: Try again");
                break;
        }
        
        return done;
    }	
    
    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }    
    
}
