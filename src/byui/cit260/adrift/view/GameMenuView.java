/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.GameControl;
import byui.cit260.adrift.control.MapControl;
import byui.cit260.adrift.control.ShipControl;
import byui.cit260.adrift.exceptions.GameControlException;
import byui.cit260.adrift.exceptions.MapControlException;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;


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
            //+ "\nX - Explore Location"
            + "\nV - Move"
            //+ "\nG - Calculate Energy"
            //+ "\nF - Calculate Fuel"
            + "\nT - Calculate Travel Costs"
            + "\nC - Craft Resources"
            //+ "\nR - Harvest Resources"
            //+ "\nD - Deliver Resource"
            + "\nR - Repair Ship"
            + "\nL - Launch Ship"
            + "\nP - Generate Map Report"
            + "\nU - Display Map Information"
            + "\nX - CHEAT: Reduce ship damage by 1"
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
                MapView mapView = new MapView();
                mapView.displayMap();
                break;
            case 'i':
                this.displayInventory();
                break;
            case 's':
                this.displalyShipDamage();
                break;
            case 'x':
            //    this.console.println("Explore location chosen");
                AdriftTeam.getGame().getShip().setDamage(AdriftTeam.getGame().getShip().getDamage() - 1);
                break;
            case 'v':
                this.movePlayer();
                break;
            //case 'g':
            //    this.console.println("Calc energy chosen");
            //    break;
            //case 'f':
            //    CalculateFuelView calculateFuel = new CalculateFuelView();
            //    calculateFuel.display();
            //    break;
            case 't':
                CalculateTravelView calcTravel = new CalculateTravelView();
                calcTravel.display();
                break;
            case 'c':
                CraftMenuView craftMenu = new CraftMenuView();
                craftMenu.display();
                break;
            //case 'r':
            //    this.console.println("Harvest resources chosen");
            //    break;
            //case 'd':
            //    this.console.println("Deliver resources chosen");
            //    break;
            case 'r':
                this.repairShip();
                break;
            case 'l':
                done = this.launchShip();
                break;
            case 'g':
                this.GenerateMapReport();
                break;
            case 'u':
                this.displayMapInfo();
                break;
            case 'h':
                this.console.println("Help menu chosen");
                this.displayHelpMenu();
                break;
            case 'e':
                this.console.println("Exit chosen");
                done = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid selection: Try again");
                break;
        }

        return done;
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void movePlayer() {

        MapView mapView = new MapView();
        mapView.displayMap();
        this.console.println("\nPlease selct a map location (e.g. B2) to "
            + "move to.");
        String input = super.getInput().toLowerCase();

        while (input.length() != 2) {

            mapView.displayMap();
            ErrorView.display(this.getClass().getName(), "\nInvalid selection: Please selct a valid map"
                + " location (e.g. B2) to move to.");

            input = super.getInput();
        }

        try {
            GameControl.moveToLocation(input);
        } catch (MapControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage()
                + "\nYou were not moved as an invalid location was selected.");
        }
    }

    private void GenerateMapReport() {

        this.console.println("\nEnter the filepath to save the report.");
        String filePath = this.getInput();

        try {
            GameControl.saveReport(this.getMapInfo(), filePath);
            this.console.println("\nThe report was successfully saved.");
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    private void displayMapInfo() {

        this.console.println(this.getMapInfo());
    }

    private String getMapInfo() {

        int[] am = new int[2];
        int[] ap = new int[2];
        int[] cm = new int[2];
        int[] dm = new int[2];
        int[] ip = new int[2];
        int[] im = new int[2];
        int[] nb = new int[2];
        int[] op = new int[2];
        int[] um = new int[2];
        int i = 0;
        int[] mapItems = new int[25];

        Location[][] locations = AdriftTeam.getGame().getMap().getLocations();
        String results = null;

        for (int row = 0; row < locations.length; row++) {

            for(int col = 0; col < locations[row].length; col++) {

                mapItems[i] = locations[row][col].getAmountRemaining();
                i++;

                String symbol = locations[row][col].getScene().getMapSymbol();

                switch(symbol) {
                    case "AM" :
                        if(!(locations[row][col].isVisited())) {
                            am[0]++;
                        }
                        am[1] += locations[row][col].getAmountRemaining();
                        break;
                    case "AP" :
                        if(!(locations[row][col].isVisited())) {
                            ap[0]++;
                        }
                        ap[1] += locations[row][col].getAmountRemaining();
                        break;
                    case "CM":
                        if(!(locations[row][col].isVisited())) {
                            cm[0]++;
                        }
                        cm[1] += locations[row][col].getAmountRemaining();
                        break;
                    case "DM":
                        if(!(locations[row][col].isVisited())) {
                            dm[0]++;
                        }
                        dm[1] += locations[row][col].getAmountRemaining();
                        break;
                    case "IF":
                        if(!(locations[row][col].isVisited())) {
                            ip[0]++;
                        }
                        ip[1] += locations[row][col].getAmountRemaining();
                        break;
                    case "IM":
                        if(!(locations[row][col].isVisited())) {
                            im[0]++;
                        }
                        im[1] += locations[row][col].getAmountRemaining();
                        break;
                    case "NB":
                        if(!(locations[row][col].isVisited())) {
                            nb[0]++;
                        }
                        nb[1] += locations[row][col].getAmountRemaining();
                        break;
                    case "OP":
                        if(!(locations[row][col].isVisited())) {
                            op[0]++;
                        }
                        op[1] += locations[row][col].getAmountRemaining();
                        break;
                    case "UM":
                        if(!(locations[row][col].isVisited())) {
                            um[0]++;
                        }
                        um[1] += locations[row][col].getAmountRemaining();
                        break;
                }
            }
        }


        results = "\nThe following areas are still unexplored.";

        results += String.format("\n%-17s %-12s %-10s", "", "Number", "Resources");
        results += String.format("\n%-17s %-12s %-10s", "Scene", "Unexplored", "Remaining") ;
        results += "\n-----------------------------------------";
        results += String.format("\n%-17s %-12s %-10s", "Aluminum Mine", am[0], am[1]);
        results += String.format("\n%-17s %-12s %-10s", "Asteroid Plain", ap[0], ap[1]);
        results += String.format("\n%-17s %-12s %-10s", "Copper Mine", cm[0], cm[1]);
        results += String.format("\n%-17s %-12s %-10s", "Diamond Mine", dm[0], dm[1]);
        results += String.format("\n%-17s %-12s %-10s", "Ice Fields", ip[0], ip[1]);
        results += String.format("\n%-17s %-12s %-10s", "Iron Mine", im[0], im[1]);
        results += String.format("\n%-17s %-12s %-10s", "Nasa Base", nb[0], nb[1]);
        results += String.format("\n%-17s %-12s %-10s", "Outpost", op[0], op[1]);
        results += "\n\nTotal items remaining: " + MapControl.sum(mapItems);

        return results;
    }

    private void displayInventory() {

        String display;
        InventoryItem[] inventory = AdriftTeam.getGame().getPlayer().getInventory();

        display = "\n---------------------------------------";
        display += String.format("\n%-20s %-10s       |", "Inventory Item", "Amount");
        display += "\n---------------------------------------";

        for(InventoryItem item : inventory) {

            display += String.format("\n%-20s %-10s", item.getType(), item.getAmount());
        }

        this.console.println(display);
    }

    private void displalyShipDamage() {

        int shipDamage = AdriftTeam.getGame().getShip().getDamage();

        if (shipDamage > 0) {
            this.console.println("\nYour ship is damaged in " + shipDamage
                + " locations and will require " + shipDamage + " Repair Modules"
                + " to be fixed.");
        }
        else {
            this.console.println("\nYour ship is repaired and ready for space flight.");
        }
    }

    private void repairShip() {

        int repaired = ShipControl.repairShip();

        this.console.println("\nYour ship was repaired in " + repaired + " locations.");

        this.displalyShipDamage();
    }

    private boolean launchShip() {

        boolean success = false;

        try {
            success = GameControl.launchShip();
            this.console.println("\nCongratulations, you've successfully repaired your ship and are on your way home.");

        } catch (GameControlException ex) {
             ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

        return success;
    }
}


