package characters;

import otherComand.OtherValuesInt;

public class Witche extends Warrior implements MagicPotion {

    // Класс Ведьм


    public Witche(String race, int healthPoint, int maxInpactForce, int price) {
        super(race, healthPoint, maxInpactForce, price);

    }

    @Override
    public String toString() {
        return getRACE() +
                "\n имя - " + getNAME() +
                "\n здоровье - " + getHealthPoint() + "%" +
                "\n минимальный удар - " + getMIN_IMPACT_FORCE() +
                "\n зелье прибовляет +20 к силе  " +
                "\n цена - " + getPRICE();

    }

    @Override
    public void toAttack() {
        System.out.println("\n\"ВЕДЬМА\":");
        System.out.println("ююююююююххххххххуууууууууу");

        System.out.println("██████████████████████████████████████\n" +
                "███████████▀▀▀░░░▄▄▄▄░░░▀▀▀███████████\n" +
                "████████▀░░░░░░░██▀░▀░░░░░░░░▀████████\n" +
                "██████▀░░░░░░░░███░░░░░░░░░░░░░▀██████\n" +
                "████▀░░░░░░░░▀████▄░░░░░░░░░░░░░░▀████\n" +
                "███▀░░░░░░░░░░█████▄░░░░░░░░░░░░░░░███\n" +
                "██▀░░░░░░░░░░░▀▀██▄░░░░░░░░░░░░░░░░░██\n" +
                "█▀░░░░░░░░░░░░░▄█████░░░░░░░░░░░░░░░▀█\n" +
                "█░░░░░░░░░░░▄▄████████░░░░░░░░░░░░░░░█\n" +
                "█░▀▀▀▄▄▄▄██████░░░▀████▄░░░░░░░░░░░░░█\n" +
                "█░░░░░░░▀▀▀███░░░▄▄██████▄░░░░░░░░░░░█\n" +
                "█░░░░░░░░░░░▀▀▀▀▀█████████░░░░░░░░░░░█\n" +
                "██░░░░░░░░░░░░░░░░▀████████████▄▄░░░▄█\n" +
                "██▄░░░░░░░░░░░░░░░░░███░▀███████░░░░██\n" +
                "███▄░░░░░░░░░░░░░░░░░███▄▀█████▄░░▄███\n" +
                "████▄░░░░░░░░░░░░░░░▀▀░█░░▀██▀▀▀░▄████\n" +
                "██████▄░░░░░░░░░░░░░░░░░░░░░▀░░▄██████\n" +
                "████████▄▄░░░░░░░░░░░░░░░░░░▄▄████████\n" +
                "████████████▄▄▄░░░░░░░░▄▄▄████████████\n" +
                "██████████████████████████████████████");

        System.out.println("Кто хочет печенько, с прянечного домика\n");
        setImpactForce(randomImpactForce());
    }


    @Override
    public void potionPower() {

        System.out.println("⣿⣿⣿⡟⣹⣯⣝⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⢿⣿⡟⢠⣿⣿⣿⣷⡌⠻⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠸⣿⡇⢸⣿⣿⣿⣿⣿⡄⠄⢿⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⡆⠹⡇⠄⣿⣿⣿⣿⣿⣿⡄⠄⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣷⡀⠄⠄⠘⣿⣿⣿⣿⣿⣿⡄⠄⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⢿⡆⠄⠄⠹⣿⣿⣿⣿⣿⣧⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣷⣦⣤⣀⠄⠘⢿⣿⣿⣿⣿⡆⠄⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣷⣦⣄⠄⠄⠙⠿⣿⣿⡇⣀⣬⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣍⡀⠄⠄⠈⠛⢷⠋⠁⠉⠻⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣂⡀⠄⠄⠈⠄⠄⠄⢠⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣀⠄⠄⠄⠄⠄⠙⢿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢶⣄⠄⠄⠸⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠟⢋⣠⣴⣾⡿⠄⠄⢰⣬⡙⠿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣧⣾⣿⣿⣿⣿⠟⠁⠄⠄⠄⢿⣿⣷⣮⣾\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠄⠄⠄⠄⢨⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠄⠄⢀⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠄⠄⠄⣸⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠄⠄⠄⣰⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠄⠄⢀⣼⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠄⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⣿⡸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "\n");
        System.out.println("Посмеёмся");
        System.out.println("Веселящие зелье - В БОЙ \n К силе воина +20\n");
        setImpactForce(getImpactForce() + OtherValuesInt.POTION.val);

    }
}
