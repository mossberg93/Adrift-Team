/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift.team;

import byui.cit260.adrift.model.*;

/**
 *
 * @author Philip
 */
public class AdriftTeam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TestRyansModules();
        TestPhilipsModules();

        // Player - Team
        // Game - Ryan
        // Ship - Ryan
        // Robot - Ryan
        // InventoryItem - Ryan
        // Actor - Ryan
        // Map - Ryan
        // Buggy - Philip
        // Space Suite - Philip
        // Location - Philip
        // ResourceScene - Philip
        // RegularScene - Philip
        // NASABase - Philip
        // Outpost - Philip
    }

    public static void TestRyansModules() {
        // Ryan puts his test code in here.
    }

    public static void TestPhilipsModules() {

        // Test SpaceSuite
        SpaceSuite spaceSuite1 = new SpaceSuite();
        spaceSuite1.setO2(5);

        String spaceSuiteInfo = spaceSuite1.toString();
        System.out.println(spaceSuiteInfo);

        // Test Buggy
        Buggy buggy1 = new Buggy();
        buggy1.setDescription("Space Buggy that transports resources.");
        buggy1.setFuel(2);

        String buggyInfo = buggy1.toString();
        System.out.println(buggyInfo);

        // Test Location
        Location location1 = new Location();
        location1.setRow(2);
        location1.setColumn(1);
        location1.setVisited(true);
        location1.setAmountRemaining(1.5);

        String locationInfo = location1.toString();
        System.out.println(locationInfo);

        // Test ResourceScene
        ResourceScene resourceScene1 = new ResourceScene();
        resourceScene1.setDescription("In front of you is a deep crater with "
                + " tiny points that reflect light");
        resourceScene1.setTravelTime(2.25);
        resourceScene1.setSymbol("A");
        resourceScene1.setAmountAvailable(3.5);
        resourceScene1.setResourceType("Diamond");

        String resourceSceneInfo = resourceScene1.toString();
        System.out.println(resourceSceneInfo);

        // Test RegularScene
        RegularScene regularScene1 = new RegularScene();
        regularScene1.setDescription("A barren astroid landscape stretches "
                + "before you.");
        regularScene1.setTravelTime(1);
        regularScene1.setSymbol("B");

        String regularSceneInfo = regularScene1.toString();
        System.out.println(regularSceneInfo);
        
        // Test NASABase
        NASABase NASABase1 = new NASABase();
        NASABase1.setDescription("The gleaming white structure of the NASA "
                + "Base is in front of you.");
        NASABase1.setTravelTime(3.5);
        NASABase1.setSymbol("F");
        NASABase1.setNumItems(5);
        
        String NASABaseInfo = NASABase1.toString();
        System.out.println(NASABaseInfo);
        
        // Test Outpost
        Outpost outpost1 = new Outpost();
        outpost1.setDescription("You stumble upon an abandoned Russian outpost");
        outpost1.setTravelTime(.5);
        outpost1.setSymbol("S");
        outpost1.setNumItems(3);
        
        String outpostInfo = outpost1.toString();
        System.out.println(outpostInfo);
    }

}
