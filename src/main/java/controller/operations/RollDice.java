package controller.operations;

import java.util.Random;

public class RollDice {
    public static int roller(){
        Random random = new Random();
        return random.nextInt(4) + 1;
    }
}