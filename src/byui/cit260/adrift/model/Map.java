/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import byui.cit260.adrift.view.ErrorView;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author mossb
 */
public class Map implements Serializable {

    private int rowCount;
    private int columnCount;
    private Location[][] locations;

    public Map() {
    }

    public Map(int rowCount, int columnCount) {

        if (rowCount < 1 || columnCount < 1) {
            ErrorView.display(this.getClass().getName(), "The number of rows and clumns must be > zero");
            return;
        }

        this.rowCount = rowCount;
        this.columnCount = columnCount;

        this.locations = new Location[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for(int column = 0; column < columnCount; column++) {
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                location.setAmountRemaining((int)(Math.random() * 5 + 1));

                locations[row][column] = location;
            }
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", locations=" + locations + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.rowCount;
        hash = 97 * hash + this.columnCount;
        hash = 97 * hash + Arrays.deepHashCode(this.locations);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        if (!Arrays.deepEquals(this.locations, other.locations)) {
            return false;
        }
        return true;
    }


}
