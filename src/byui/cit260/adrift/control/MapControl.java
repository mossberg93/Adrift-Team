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
public class MapControl {
    
    public static String getLocation() {
        System.out.println("Stub getLocation function called");
        return "C5";
    }    
    
    public static boolean validateLocation(String location) {
        System.out.println("Stub validateLocation function called");
        return true;
    }  
    
    public static int calculateDistance(String mapLoc, String mapDest) {
        System.out.println("Stub calculateDistance function called");
        return 5;
    }   
}
