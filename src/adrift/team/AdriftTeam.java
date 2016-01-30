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
        
        // Player - Team x
        
        TestRyansModules();
        
        // Game - Ryan x
        // Ship - Ryan x
        // Robot - Ryan
        // InventoryItem - Ryan
        // Actor - Ryan
        // Map - Ryan
        
        //TestPhilipsModules();
        
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
        
        //TestPlayer
        Player player1 = new Player();
        player1.setBestTime(42);
        player1.setName("Ryan");
        
        String playerInfo = player1.toString();
        System.out.println(playerInfo);
        
        //TestGame
        Game game1 = new Game();
        game1.setNumPeople(1);
        game1.setTotalTime(100);
        
        String gameInfo = game1.toString();
        System.out.println(gameInfo);
        
        //TestShip
        Ship ship1 = new Ship();
        ship1.setDescription("This is the ship.");
        ship1.setDamage(0);
        
        String shipInfo = ship1.toString();
        System.out.println(shipInfo);
        
        //TestRobot
        Robot robot1 = new Robot();
        robot1.setDiamonds(1);
        
        String robotInfo = robot1.toString();
        System.out.println(robotInfo);
        
        //TestInventory
        Inventory inventory1 = new Inventory();
        inventory1.setInventoryType("Personal Inventory");
        inventory1.setQuantityInStock(1);
        inventory1.setRequiredAmount(1);
        
        String inventoryInfo = inventory1.toString();
        System.out.println(inventoryInfo);
        
        //TestActor
        Actor actor1 = new Actor();
        actor1.setAttribute("Male");
        actor1.setCoordinates(55);
        actor1.setDescription("This is you.");
        actor1.setEnergy(100);
        actor1.setName("You");
        
        String actorInfo = actor1.toString();
        System.out.println(actorInfo);
        
        //TestMap
        Map map1 = new Map();
        map1.setColumnCount(5);
        map1.setRowCount(5);
        
        String mapInfo = map1.toString();
        System.out.println(mapInfo);
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
