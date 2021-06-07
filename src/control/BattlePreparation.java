package control;

import characters.*;
import otherComand.OtherValuesInt;

import java.util.ArrayList;

public class BattlePreparation<T> {

    private final ArrayList<Warrior> MARKET;

    public ArrayList<Warrior> getMARKET() {
        return MARKET;
    }

    public BattlePreparation() {
        MARKET = new ArrayList<>();
        MARKET.add(new Archer("Лучник", OtherValuesInt.MAX_HEALTH_POINT.val, OtherValuesInt.MIN_IMPACT_FORCE_ONE.val,
                OtherValuesInt.PRICE_ONE.val));
        MARKET.add(new Barbarian("Варвар", OtherValuesInt.MAX_HEALTH_POINT.val, OtherValuesInt.MIN_IMPACT_FORCE_TWO.val,
                OtherValuesInt.PRICE_TWO.val));
        MARKET.add(new Gnome("Гном", OtherValuesInt.MAX_HEALTH_POINT.val, OtherValuesInt.MIN_IMPACT_FORCE_TWO.val,
                OtherValuesInt.PRICE_TWO.val));
        MARKET.add(new Witche("Ведьмак", OtherValuesInt.MAX_HEALTH_POINT.val, OtherValuesInt.MIN_IMPACT_FORCE_ONE.val,
                OtherValuesInt.PRICE_ONE.val));


    }



    //  выбрать воина
    public Warrior marketplace(int val) {
        Warrior war;

        war = MARKET.remove(val);  // выбераем на рынке воина
        System.out.println("Вы желаете преобрести  : \n" + war.toString() + "\n");

        // возращаем другого воина на рынок
        if (war instanceof Archer) {
            MARKET.add(val, new Archer(war.getRACE(), war.getHealthPoint(), war.getMIN_IMPACT_FORCE(), war.getPRICE()));
        } else if (war instanceof Barbarian) {
            MARKET.add(val, new Barbarian(war.getRACE(), war.getHealthPoint(), war.getMIN_IMPACT_FORCE(), war.getPRICE()));
        } else if (war instanceof Gnome) {
            MARKET.add(val, new Gnome(war.getRACE(), war.getHealthPoint(), war.getMIN_IMPACT_FORCE(), war.getPRICE()));
        } else if (war instanceof Witche) {
            MARKET.add(val, new Witche(war.getRACE(), war.getHealthPoint(), war.getMIN_IMPACT_FORCE(), war.getPRICE()));
        }

        return war; // передаём игроку
    }

    // посмотреть всех воинов на рынке
    public void showAllMarket() {

        for (Warrior war : MARKET) {
            System.out.println(war.toString());
            System.out.println();
        }

    }


}


