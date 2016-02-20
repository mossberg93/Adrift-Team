/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adtift.control;

import byui.cit260.adrift.control.RobotControl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Philip
 */
public class RobotControlTest {
    
    public RobotControlTest() {
    }

    /**
     * Test of calculateO2 method, of class RobotControl.
     */
    @Test
    public void testCalculateO2() {
        
        System.out.println("calculateO2");
        
        /*******************
         * Test case #1
         *******************/
        
        System.out.println("\tTest case #1");
        
        // input values for test case 1
        int distance = 12;
        int amount = 5;
        int harvest = 1;
        int buggy = 1;
        
        double expResult = 68; // expected results
        
        // create instance of RobotControl class
        RobotControl instance = new RobotControl();

        // call function to test
        double result = instance.calculateO2(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);
        
        /*******************
         * Test case #2
         *******************/
        
        System.out.println("\tTest case #2");
        
        // input values for test case 2
        distance = 12;
        amount = -2;
        harvest = 1;
        buggy = 1;
        
        expResult = -1; // expected results
        
        result = instance.calculateO2(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);      
        
        /*******************
         * Test case #3
         *******************/
        
        System.out.println("\tTest case #3");
        
        // input values for test case 3
        distance = -1;
        amount = 5;
        harvest = 1;
        buggy = 1;
        
        expResult = -1; // expected results
        
        result = instance.calculateO2(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
        
        /*******************
         * Test case #4
         *******************/
        
        System.out.println("\tTest case #4");
        
        // input values for test case 4
        distance = 12;
        amount = 5;
        harvest = 2;
        buggy = 1;
        
        expResult = -1; // expected results
        
        result = instance.calculateO2(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
        
        /*******************
         * Test case #5
         *******************/
        
        System.out.println("\tTest case #5");
        
        // input values for test case 5
        distance = 12;
        amount = 5;
        harvest = 1;
        buggy = 3;
        
        expResult = -1; // expected results
        
        result = instance.calculateO2(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
        
        /*******************
         * Test case #6
         *******************/
        
        System.out.println("\tTest case #6");
        
        // input values for test case 6
        distance = 0;
        amount = 0;
        harvest = 0;
        buggy = 0;
        
        expResult = 0; // expected results
        
        result = instance.calculateO2(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
        
        /*******************
         * Test case #7
         *******************/
        
        System.out.println("\tTest case #7");
        
        // input values for test case 7
        distance = 12;
        amount = 5;
        harvest = 1;
        buggy = 1;
        
        expResult = 68; // expected results
        
        result = instance.calculateO2(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
    }

    /**
     * Test of calculateEnergy method, of class RobotControl.
     */
    @Test
    public void testCalculateEnergy() {
        
        System.out.println("calculateEnergy");
        
        /*******************
         * Test case #1
         *******************/
        
        System.out.println("\tTest case #1");
        
        // input values for test case 1
        int distance = 4;
        int amount = 6;
        int harvest = 0;
        int buggy = 0;
        
        double expResult = 28.0; // expected results
        
        // create instance of RobotControl class
        RobotControl instance = new RobotControl();
        
        // call function to test
        double result = instance.calculateEnergy(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);
        
        /*******************
         * Test case #2
         *******************/
        
        System.out.println("\tTest case #2");
        
        // input values for test case 2
        distance = 4;
        amount = -5;
        harvest = 0;
        buggy = 1;
        
        expResult = -1; // expected results
        
        result = instance.calculateEnergy(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);      
        
        /*******************
         * Test case #3
         *******************/
        
        System.out.println("\tTest case #3");
        
        // input values for test case 3
        distance = -2;
        amount = 3;
        harvest = 1;
        buggy = 0;
        
        expResult = -1; // expected results
        
        result = instance.calculateEnergy(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
        
        /*******************
         * Test case #4
         *******************/
        
        System.out.println("\tTest case #4");
        
        // input values for test case 4
        distance = 7;
        amount = 2;
        harvest = 5;
        buggy = 0;
        
        expResult = -1; // expected results
        
        result = instance.calculateEnergy(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
        
        /*******************
         * Test case #5
         *******************/
        
        System.out.println("\tTest case #5");
        
        // input values for test case 5
        distance = 5;
        amount = 7;
        harvest = 1;
        buggy = -2;
        
        expResult = -1; // expected results
        
        result = instance.calculateEnergy(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
        
        /*******************
         * Test case #6
         *******************/
        
        System.out.println("\tTest case #6");
        
        // input values for test case 6
        distance = 0;
        amount = 0;
        harvest = 0;
        buggy = 0;
        
        expResult = 0; // expected results
        
        result = instance.calculateEnergy(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
        
        /*******************
         * Test case #7
         *******************/
        
        System.out.println("\tTest case #7");
        
        // input values for test case 7
        distance = 1;
        amount = 1;
        harvest = 1;
        buggy = 1;
        
        expResult = 2; // expected results
        
        result = instance.calculateEnergy(distance, amount, harvest, buggy);
        
        // compare expected results with return value
        assertEquals(expResult, result, 0.0001);    
    }

    /**
     * Test of calculateFuel method, of class RobotControl.
     */
    @Test
    public void testCalculateFuel() {
        System.out.println("calculateFuel");
        
        /*********************
         * Test Case #1
         ********************/
        System.out.println("\tTest case #1");
        
        //input values for test case 1
        int destination = 5;
        int amount = 10;
        
        double expResult = 55.0; //expected output returned value
        
        RobotControl instance = new RobotControl();
        
        //call function to run test
        double result = instance.calculateFuel(destination, amount);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        /*********************
         * Test Case #2
         ********************/
        System.out.println("\tTest case #2");
        
        //input values for test case 1
        destination = -1;
        amount = 10;
        
        expResult = -1; //expected output returned value
        
        //call function to run test
        result = instance.calculateFuel(destination, amount);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        /*********************
         * Test Case #3
         ********************/
        System.out.println("\tTest case #3");
        
        //input values for test case 1
        destination = 5;
        amount = -1;
        
        expResult = -1; //expected output returned value
        
        //call function to run test
        result = instance.calculateFuel(destination, amount);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        /*********************
         * Test Case #4
         ********************/
        System.out.println("\tTest case #4");
        
        //input values for test case 1
        destination = -1;
        amount = -1;
        
        expResult = -1; //expected output returned value
        
        //call function to run test
        result = instance.calculateFuel(destination, amount);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        /*********************
         * Test Case #5
         ********************/
        System.out.println("\tTest case #5");
        
        //input values for test case 1
        destination = 0;
        amount = 10;
        
        expResult = 0; //expected output returned value
        
        //call function to run test
        result = instance.calculateFuel(destination, amount);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        /*********************
         * Test Case #6
         ********************/
        System.out.println("\tTest case #6");
        
        //input values for test case 1
        destination = 5;
        amount = 0;
        
        expResult = 5; //expected output returned value
        
        //call function to run test
        result = instance.calculateFuel(destination, amount);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        /*********************
         * Test Case #7
         ********************/
        System.out.println("\tTest case #7");
        
        //input values for test case 1
        destination = 0;
        amount = 0;
        
        expResult = 0; //expected output returned value
        
        //call function to run test
        result = instance.calculateFuel(destination, amount);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
    }
}
