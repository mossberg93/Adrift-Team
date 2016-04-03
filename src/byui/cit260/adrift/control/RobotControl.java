/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

/**
 *
 * @author Philip
 */
public class RobotControl {

    public static int calculateO2(int distance, int amount, int harvest, int buggy) {

        if (distance < 0) {
            return -1;
        }

        if (amount < 0) {
            return -1;
        }

        if (harvest != 0 && harvest != 1) {
            return -1;
        }

        if (buggy != 0 && buggy != 1) {
            return -1;
        }

        int totalO2 = distance + harvest + (amount * distance) - (amount * buggy);

        return totalO2;
    }

    public static int calculateEnergy(int distance, int amount, int harvest, int buggy) {

        if (distance < 0) {
            return -1;
        }

        if (amount < 0) {
            return -1;
        }

        if (harvest != 0 && harvest != 1) {
            return -1;
        }

        if (buggy != 0 && buggy != 1) {
            return -1;
        }

        int totalEnergy = distance + harvest + (amount * distance) - (amount * buggy);

        return totalEnergy;
    }

  public static int calculateFuel(int destination, int amount) {

      if (destination < 0) {
          return -1;
      }

      if (amount < 0) {
          return -1;
      }

      int totalFuel = destination + (amount * destination);

      return totalFuel;
  }
}
