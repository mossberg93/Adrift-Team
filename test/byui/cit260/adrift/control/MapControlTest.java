/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Philip
 */
public class MapControlTest {

    public MapControlTest() {
    }

    /**
     * Test of validateLocation method, of class MapControl.
     */
    @Test
    public void testValidateLocation() {
        System.out.println("validateLocation");

        GameControl.createNewGame(GameControl.createPlayer("Bob"));

        /*******************
         * Test case #1
         *******************/

        System.out.println("\tTest case #1");

        // input values for test case 1

        String location = "C3";
        boolean expResult = true;
        boolean result = MapControl.validateLocation(location);
        assertEquals(expResult, result);

        /*******************
         * Test case #2
         *******************/

        System.out.println("\tTest case #2");

        // input values for test case 1

        location = "G20";
        expResult = false;
        result = MapControl.validateLocation(location);
        assertEquals(expResult, result);

        /*******************
         * Test case #3
         *******************/

        System.out.println("\tTest case #3");

        // input values for test case 1

        location = "A1";
        expResult = true;
        result = MapControl.validateLocation(location);
        assertEquals(expResult, result);

        /*******************
         * Test case #2
         *******************/

        System.out.println("\tTest case #4");

        // input values for test case 1

        location = "E5";
        expResult = true;
        result = MapControl.validateLocation(location);
        assertEquals(expResult, result );
    }
}
