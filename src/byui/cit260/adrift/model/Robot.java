/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import java.io.Serializable;

/**
 *
 * @author mossb
 */
public class Robot implements Serializable {
    private int diamonds;

    public Robot() {
    }

    public int getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.diamonds;
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
        final Robot other = (Robot) obj;
        if (this.diamonds != other.diamonds) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Robot{" + "diamonds=" + diamonds + '}';
    }

    
}
