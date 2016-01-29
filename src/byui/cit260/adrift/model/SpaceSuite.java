/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import java.io.Serializable;

/**
 *
 * @author Philip
 */
public class SpaceSuite implements Serializable {

    // class instance variables
    private double o2;

    public SpaceSuite() {
    }

    public double getO2() {
        return o2;
    }

    public void setO2(double o2) {
        this.o2 = o2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.o2) ^ (Double.doubleToLongBits(this.o2) >>> 32));
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
        final SpaceSuite other = (SpaceSuite) obj;
        if (Double.doubleToLongBits(this.o2) != Double.doubleToLongBits(other.o2)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpaceSuite{" + "o2=" + o2 + '}';
    }

}
