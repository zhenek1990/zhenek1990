package gamers;

import characters.Warrior;

import java.util.Collection;
import java.util.Random;

public class Bot extends User {
    private Random random;

    public Bot(String name, int balance)
    {
        super(name, balance);
        random = new Random();
    }

    public int numberRandom(int val){

        return random.nextInt(val);
    }

    @Override
    public String toString() {
        return  super.toString();
    }
}
