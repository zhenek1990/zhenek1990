package otherComand;

public enum CommandStr {
    PLAYER("ИГРОК"), BOT("БОТ"),YES("ДА"),NO("НЕТ");

    public String value;


    CommandStr(String value) {
        this.value = value;
    }
}
