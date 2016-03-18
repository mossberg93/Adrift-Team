
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip
 */
public class TestJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int sum = 0;

        for(StealableItems si : StealableItems.values()) {
            sum += si.getValue();
        }

        System.out.println("sum  = " + sum);
    }

    public enum StealableItems implements Serializable{
        diamonds(5000),
        goldBars(50000),
        painting(10000),
        sculpture(7500),
        vase(15000);

        // class instance variables
        private final int value;

        StealableItems(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
