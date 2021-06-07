package otherComand;

public enum OtherValuesInt {

    POTION(20), PROTECTION(30), BALANCE(1000), PRICE_ONE(200), PRICE_TWO(350), MAX_HEALTH_POINT(100),
    MIN_IMPACT_FORCE_ONE(15), MIN_IMPACT_FORCE_TWO(30), BATTLE_PRIZE(100), PRICE_POTION(50);

    public int val;

    OtherValuesInt(int val) {
        this.val = val;
    }
}
