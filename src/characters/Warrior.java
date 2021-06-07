package characters;

import otherComand.OtherValuesInt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class Warrior implements MagicPotion {
    private final String RACE; // раса воина
    private final String NAME; // имя воина
    private int healthPoint;  // Очки здоровья
    private int impactForce;   // Сила удара
    private int protection;   // защита
    private final int MIN_IMPACT_FORCE;   // Минимальная Сила удара
    private final int PRICE;  //  цена героя
    private boolean potion; // зелье
    private final ArrayList<String> NAMES;
    private Random random;


    public Warrior(String race, int healthPoint, int minImpactForce, int price) {
        this.RACE = race;
        this.healthPoint = healthPoint;
        this.MIN_IMPACT_FORCE = minImpactForce;
        this.PRICE = price;

        random = new Random();

        impactForce = randomImpactForce();
        protection = protectionRandom();

        NAMES = new ArrayList<>();
        Collections.addAll(NAMES, "Андерс", "Арни", "Алекс", "Арчи", "Антеон", "Альбус", "Айбер", "Адам",
                "Бесталл", "Боркас", "Баэлнесс", "Брэндон", "Боб", "Брандон", "Беон", "Бобби",
                "Бурбон", "Берадот", "Верронн", "Вильгельм", "Вениамин", "Вандон", "Виктуар",
                "Гилдримм", "Гарри", "Гэри", "Гарольд", "Гордон", "Джерласс", "Джаспер", "Дик",
                "Джим", "Доар", "Джон", "Диплексий", "Джонас", "Джек", "Дин", "Джордж",
                "Джексон", "Эйлдар", "Эдгар", "Эвари", "Эдуардо", "Эйревелл", "Энрики", "Элберт",
                "Энджи", "Эльберт", "Эгри", "Эдвард", "Эштон", "Иладар", "Иррадион", "Иллирий",
                "Ингард", "Ивиникум");

        NAME = nameRandom();
        potion = false;


    }

    public boolean isPotion() {
        return potion;
    }

    public void setPotion(boolean potion) {
        this.potion = potion;
    }

    public String getRACE() {
        return RACE;
    }

    public String getNAME() {
        return NAME;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getImpactForce() {
        return impactForce;
    }

    public void setImpactForce(int impactForce) {
        this.impactForce = impactForce;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getMIN_IMPACT_FORCE() {
        return MIN_IMPACT_FORCE;
    }

    public int getPRICE() {
        return PRICE;
    }

    public abstract String toString();

    public abstract void toAttack();

    public int randomImpactForce() {
        return random.nextInt(OtherValuesInt.PROTECTION.val + OtherValuesInt.POTION.val) + getMIN_IMPACT_FORCE();
    }

    public int protectionRandom() {
        int protect;
        protect = random.nextInt(OtherValuesInt.PROTECTION.val);

        return protect;
    }

    public String nameRandom() {

        String nameRand;
        int size;

        size = NAMES.size();
        nameRand = NAMES.remove(random.nextInt(size));

        return nameRand;
    }

}