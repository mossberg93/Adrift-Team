/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import byui.cit260.adrift.control.MapControl;
import byui.cit260.adrift.control.RobotControl;
import byui.cit260.adrift.exceptions.MapControlException;

/**
 *
 * @author Philip
 */
public class CalculateTravelView extends View {

    private int distance = 0;
    private int amount = 0;
    private int harvest = 0;
    private int buggy = 0;
    private int o2Amount = 0;
    private int energyAmount = 0;
    private int fuelAmount = 0;
    private String mapLoc = null;
    private int question = 1;
    String message;
    String[] dialogue = {
        "Enter your destination coordinates.",
        "Will you be taking the buggy?"
            + "\nY - Yes"
            + "\nN - No",
        "Will you be harvesting resources?"
            + "\nY - Yes"
            + "\nN - No",
        "How much resources will you be harvesting?"
    };

    public CalculateTravelView() {
        super();

        mapLoc = AdriftTeam.getGame().getPlayer().getLocation();
        o2Amount = AdriftTeam.getGame().getPlayer().getO2();
        energyAmount = AdriftTeam.getGame().getPlayer().getEnergy();
        fuelAmount = AdriftTeam.getGame().getBuggy().getFuel();

        message = "You're at map coordinates " + mapLoc + " and have: "
            + "\n" + o2Amount + " liters of oxygen"
            + "\n" + energyAmount + " calories of energy"
            + "\n" + fuelAmount + " liters of fuel."
            + "\n-------------------------------------\n"
            + dialogue[0];
        super.setDisplayMessage(message);
    }

    @Override
    public boolean doAction (String input) {

        boolean valid = false;
        boolean done = false;
        char selection = input.toLowerCase().charAt(0);

        switch(question) {
            case 1: // Enter your destination coordinates.

                try {
                    MapControl.validateLocation(input.toLowerCase());
                    String mapDest = input;
                    distance = MapControl.calculateDistance(mapLoc, mapDest);
                    valid = true;
                } catch (MapControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                }

                break;
            case 2: // Will you be taking the buggy?
                switch (selection) {
                    case 'y':
                        buggy = 1;
                        valid = true;
                        break;
                    case 'n':
                        buggy = 0;
                        done = true;
                        break;
                    default:
                        ErrorView.display(this.getClass().getName(), "Input invalid: Please enter Y or N");
                        break;
                }

                break;
            case 3: // Will you be harvesting resources?
                switch (selection) {
                    case 'y':
                        harvest = 1;
                        valid = true;
                        break;
                    case 'n':
                        harvest = 0;
                        done = true;
                        break;
                    default:
                        ErrorView.display(this.getClass().getName(), "Input invalid: Please enter Y or N");
                        break;
                }

                break;
            case 4: // How much resources will you be harvesting?

                try {
                    amount =  Integer.parseInt(input);
                } catch (NumberFormatException e){
                    ErrorView.display(this.getClass().getName(), "Input invalid: Enter a number.");
                }

                if (amount > 0) {
                    done = true;
                }
                else {
                    ErrorView.display(this.getClass().getName(), "Input invalid: Enter a value > 0");
                }

                break;
          }

        if (done) {
            int requiredO2 = RobotControl.calculateO2(distance, amount, harvest, buggy);
            int requiredEnergy = RobotControl.calculateEnergy(distance, amount, harvest, buggy);
            int requiredFuel = RobotControl.calculateFuel(distance, amount);

            String summary = "\nSummary"
                + "\n-------------------------------------"
                + "\nTravel distance: " + distance;

            if (harvest == 1) {
                summary += "\nHarvest: Y";
                summary += "\nHarvest Amount: " + amount;
            }
            else {
                summary += "\nHarvest: N";
            }

            if (buggy == 1) {
                summary += "\nBuggy: Y";
            }
            else {
                summary += "\nBuggy: N";
            }

            summary += "\nThis trip will require: "
                + "\n" + requiredO2 + " liters of oxygen"
                + "\n" + requiredEnergy + " calories of energy"
                + "\n" + requiredFuel + " liters of fuel.";

            this.console.println(summary);

            return done;
        }

        if (valid) {
            message = dialogue[question]; // get the next part of the dialogue
            super.setDisplayMessage(message); // update the display message
            question++; // advance to the next question
        }

        return done;
    }
}
