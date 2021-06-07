package characters;

import otherComand.OtherValuesInt;

public class Barbarian extends Warrior implements MagicPotion{

    //     Класс Варворов


    public Barbarian(String race, int healthPoint, int maxInpactForce, int price) {
        super(race, healthPoint, maxInpactForce, price);
    }

    @Override
    public String toString() {
        return getRACE() +
                "\n имя - " + getNAME() +
                "\n здоровье - " + getHealthPoint() + "%" +
                "\n минимальный удар - " + getMIN_IMPACT_FORCE() +
                "\n зелье прибовляет +20 к защите  " +
                "\n цена - " + getPRICE();

    }

    @Override
    public void toAttack() {
        System.out.println("\n\"ВАРВАРЫ\":");
        System.out.println("─────▀▄▄▄▄──▀▄───▄▄▄▄▄▄───▄▀──▄▄▄▄▀\n" +
                "──────▀▄▄▄▀▄─▀▄▄▀──────▀▄▄▀─▄▀▄▄▄▀\n" +
                "───────▀▄▄▄▀▄─▄▀────────▀▄─▄▀▄▄▄▀\n" +
                "────────▀▄▄▄▀▄▀──────────▀▄▀▄▄▄▀\n" +
                "────────────▐▀▀▀▀▀▀▀▀▀▀▀▀▀▀▌\n" +
                "────────────▐▄▄▄▄▄▄▄▄▄▄▄▄▄▄▌\n" +
                "───────────▄▀─▐░░▀▀░░▀▀░░▌─▀▄\n" +
                "───────────▌▄▀▐▌▀█▀░░▀█▀░▌▀▄▐\n" +
                "───────────▌──▐░░░░░▌░░░░▌──▐\n" +
                "──────────▀▄▄▀▐░░░░▄▄▌░░░▌▀▄▄▀\n" +
                "───────────▌▄▀▐░░░░░░░░░░▌▀▄▐\n" +
                "───────────▌▄▀▐░░░▀▄▄▄▌░░▌▀▄▐\n" +
                "──────────▄▀─▄▀▀▄░░░░░░▄▀─▀▄─▀▄\n" +
                "──────────▀▄─▄▀─▐▀▄▄▄▄▀▌─▄▀─▀▄▀\n" +
                "─────────▀▄─▄▀▀▄▐░░░░░░▌▀▄─▀▄\n" +
                "──────────▄██████▄▄▄▄▄▄█████▄\n" +
                "───▄▄▄──▄████████████████████▄─▄▄▄▄\n" +
                "─▄▀░░░▀████████████████████████▀░░░▀▄\n" +
                "▐░░░░░░░▐█████████████████████░░░░░░░▌\n" +
                "▐░░░░░░░▐████▀░░▀█████▀░░▀████▐░░░░░░▌\n" +
                "▐░░░░░░░▐████░░░░░███ ░░░░░████░░░░░░░▌\n" +
                "─▀▄░░░▄▀─████▄░░▄█████▄░░▄████▀▄░░░▄▀\n" +
                "─▌░░░░░░██████████████████████░░░▐░░▐\n" +
                "▐░░░░▐░░▐████▀░░▀█████▀░░▀████▐░░▐░░░▌\n" +
                "▐░░░░▐░░▐████░░░░░███ ░░░░░████░░░▐░░░▌\n" +
                "▐░░░░▐░▐─████▄░░▄█████▄░░▄████░░░▐░░░▌\n" +
                "─▀▄░░░▄▀─█████████████████████▀▄░░░▄▀\n" +
                "▐░░░░░░░▐████▀░░▀█████▀░░▀████▐░░░░░░▌\n");
        System.out.println("Достаём свои дубинки");
        System.out.println("В АТАКУ\n");
        setProtection(protectionRandom());
    }


    @Override
    public void potionPower() {
        System.out.println("█──█──████──█─█──███──████──█──█\n" +
                "█─█───█──█──█─█───█───█──█──█──█\n" +
                "██────████──███───█───█──█──█─██\n" +
                "█─█───█───────█───█───█──█──██─█\n" +
                "█──█──█─────███───█───████──█──█\n" +
                "────────────────────────────────\n" +
                "█──█──█─█──████───████──█──█\n" +
                "█──█──█─█──█──██──█──█──█─█\n" +
                "████──███──████───████──██\n" +
                "───█────█──█──██──█──█──█─█\n" +
                "───█──███──████───█──█──█──█\n");
        System.out.println("НЕ СОКРУШИМЫЙ \n К защите воина +20\n");
        setProtection(getProtection() + OtherValuesInt.POTION.val);

    }
}