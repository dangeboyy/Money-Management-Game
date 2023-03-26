package controller.operations;

import java.util.Random;

public class TransportationMistake {
    public static double ratioOfBrokenProducts(){
        Random random = new Random();
        double ratio = random.nextInt(21);
        return ratio/100;
    }
}