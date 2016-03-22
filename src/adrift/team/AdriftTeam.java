/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift.team;

import byui.cit260.adrift.model.*;
import byui.cit260.adrift.view.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Philip
 */
public class AdriftTeam {

    private static Player player = null;
    private static Game game = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    private static PrintWriter logFile = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        try {

            // open charcter stream files for end user input and outpu
            AdriftTeam.inFile = new BufferedReader(new InputStreamReader(System.in));
            AdriftTeam.outFile = new PrintWriter(System.out, true);

            // open log file
            String filePath = "Adrfit.log";
            AdriftTeam.logFile = new PrintWriter(filePath);

            // create StartProgramViewOrig and display the start
            // program view
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
            return;

        } catch (Throwable e) {
                System.out.println(
                    "Exception: " + e.toString() +
                    "\nCause: " + e.getCause() +
                    "\nMessage: " + e.getMessage());

                e.printStackTrace();
        }
        finally {
            try {
                if (AdriftTeam.inFile != null) {
                    AdriftTeam.inFile.close();
                }

                if (AdriftTeam.outFile != null) {
                    AdriftTeam.outFile.close();
                }

                if (AdriftTeam.logFile != null) {
                    AdriftTeam.logFile.close();
                }

            } catch (IOException ex) {
                System.out.println("Error closing files");
            }
        }
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        AdriftTeam.player = player;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game currentGame) {
        AdriftTeam.game = currentGame;
    }

   public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        AdriftTeam.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        AdriftTeam.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        AdriftTeam.logFile = logFile;
    }
}
