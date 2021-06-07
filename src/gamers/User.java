package gamers;

import characters.Warrior;

import java.util.ArrayList;
import java.util.Random;

public class User {


    private String name; // имя игрока
    private int balance; // баланс игрка
    private ArrayList<Warrior> heroes;


    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
        heroes = new ArrayList<>();


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void setHeroes(Warrior warrior) {
        heroes.add(warrior);
    }

    public ArrayList<Warrior> getHeroes() {
        return heroes;
    }

    public Warrior randomWar() throws NullPointerException {
        Warrior warrior;
        Random random = new Random();
        warrior = heroes.get(random.nextInt(heroes.size()));

        return warrior;
    }

    public void info() {
        System.out.println("Ваш логин - " + name);
        System.out.println("Ваш баланс - " + balance + " монет");
    }

    @Override
    public String toString() {
        return getName() + " \n" + "Баланс " + getBalance() + " $\n"  + getHeroes().size() + " Воина \n";
    }
}