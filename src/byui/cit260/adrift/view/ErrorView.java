/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.team.AdriftTeam;
import java.io.PrintWriter;

/**
 *
 * @author Philip
 */
public class ErrorView {

    private static final PrintWriter errorFile = AdriftTeam.getOutFile();
    private static final PrintWriter logFile = AdriftTeam.getLogFile();

    public static void display(String className, String errorMessage) {

        errorFile.println(
            "---------------------------------------"
            + "\n- ERROR - " + errorMessage
            + "\n---------------------------------------"
        );

        logFile.println(className + " - " + errorMessage);
    }
}
