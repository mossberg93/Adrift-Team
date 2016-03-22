/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.GameControl;
import byui.cit260.adrift.control.MapControl;
import byui.cit260.adrift.exceptions.MapControlException;
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
            + "\nT - Generate Map Report"
            + "\nU - Display Map Information"
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
                this.console.println("Display inventory chosen");
                break;
            case 's':
                this.console.println("Display ship chosen");
                break;
            case 'x':
                this.console.println("Explore location chosen");
                break;
            case 'v':
                this.movePlayer();
                break;
            case 'g':
                this.console.println("Calc energy chosen");
                break;
            case 'f':
                this.console.println("Calc fuel chosen");
                CalculateFuelView calculateFuel = new CalculateFuelView();
                calculateFuel.display();
                break;
            case 'o':
                this.console.println("Calc O2 chosen");
                CalculateO2View calculateO2 = new CalculateO2View();
                calculateO2.display();
                break;
            case 'c':
                this.console.println("craft tools chosen");
                break;
            case 'r':
                this.console.println("Harvest resources chosen");
                break;
            case 'd':
                this.console.println("Deliver resources chosen");
                break;
            case 'p':
                this.console.println("Repair ship chosen");
                break;
            case 'l':
                this.console.println("Launch ship chosen");
                break;
            case 't':
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
}
