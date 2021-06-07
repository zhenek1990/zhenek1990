package control;

public class DecorationAndInfo {


    public String getGO_ONE() {
        return "\n * Игрок №1 * \n - Ваш ход - \n";
    }
    public String getGO_TWO() {
        return "\n * Игрок №2 * \n - Ваш ход - \n";
    }

    public String getGO_BOT(){
        return "\n* БOT_БOБ * \n - ВАШ ХОД - \n";
    }

    public String getWRONG_COMMAND() {

        return "\n Вы ввели не правильную команду \n";
    }

    // название
    public void gameName() {
        System.out.println("●▬▬▬▬▬▬▬▬▬▬▬ஜ۩۞۩ஜ▬▬▬▬▬▬▬▬▬▬▬●\n" +
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                "░█░█░█░█▀▀▀░█░░░░█▀▀▀░█▀▀█░█▀█▀█░█▀▀▀░\n" +
                "░█░█░█░█▀▀▀░█░░░░█░░░░█░░█░█░█░█░█▀▀▀░\n" +
                "░▀▀▀▀▀░▀▀▀▀░▀▀▀▀░▀▀▀▀░▀▀▀▀░▀░▀░▀░▀▀▀▀░\n" +
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                "●▬▬▬▬▬▬▬▬▬▬▬ஜ۩۞۩ஜ▬▬▬▬▬▬▬▬▬▬▬●\n");
        System.out.println();
        System.out.println("           В ИГРУ");
        System.out.println("|----------------------------|");
        System.out.println("| * THE WAY OF THE WARRIOR * |"); // путь воина
        System.out.println("|----------------------------|");
        System.out.println();

    }


    //инфо о рынке
    public void buyWarrior() {

        System.out.println("Вы попали на \" Невольничий рынок \"");
        System.out.println();
        System.out.println("Здесь вы можете купить себе воина");
        System.out.println();
        System.out.println("Вы можете покупать сколько угодно воинов до тех пор," +
                "\n пока не закончатся монеты  ");
        System.out.println();
    }


    // инфо о воинах
    public void characterSelection() {

        System.out.println("Выберите воина");
        System.out.println();
        System.out.println("Введите 1 - что бы выбрать Лучника");
        System.out.println("Введите 2 - что бы выбрать Варвара");
        System.out.println("Введите 3 - что бы выбрать Гнома");
        System.out.println("Введите 4 - что бы выбрать Ведьму");
        System.out.println("Введите 5 - что бы посмотреть всех воинов");
        System.out.println();
    }


    // визуализация  главного меню
    public void mainMenu() {
        System.out.println("Введите :\n " +"\n   * RULES - Информация об игре *\n" +
                "\n   * 1 - Рынок * 2 - Мои воины * 3 - Баланс * \n" +
                "                    * 0 - В АТАКУ *" +
                "\n * 4 - пропустить ход * 5 - купить зелье * 6 - Выход *\n");
    }


    // да или нет
    public void yesNo() {
        System.out.println("Введите :" +
                "\n - Да - для того что бы купить воина " +
                "\n - Нет - для выхода");
    }


    // режим игры
    public void gameModeInfo() {
        System.out.println("Выберите режим игры :");
        System.out.println();
    }

    //вывод на экран  "игра с ботом или с другом"
    public void selectGameMode() {
        System.out.println("1. Играть с другом введите - ИГРОК");
        System.out.println("2. Играть с компьютером введите - БОТ");
        System.out.println();
    }

    public void rules(){
        System.out.println("\n* * * THE WAY OF THE WARRIOR * * * \n " +
                "Для того что бы начать играть нужно ввести свой ник\n" +
                "и вам автоматически зачислится 1000 монет на баланс игрока.\n" +
                "После того как все игроки зарегистрируются вы попадаете в главное меню где можете\n" +
                "* купить игрока\n" +
                "* посмотреть всех своих воинов\n" +
                "* посмотреть свой ник и баланс\n" +
                "* купить зелье\n" +
                "* пропустить ход\n" +
                "* пойти в БОЙ\n" +
                "\n" +
                "- ПАМЯТКА -\n" +
                "\n" +
                "* Вы не можете начать бой если у вас нет воина,\n" +
                "сначала нужно его купить\n" +
                "* Вы не можете начать бой если у противника нет воина,\n" +
                "нужно пропустить ход\n" +
                "* Вы не можете купить магическое зелье если у вас нет воина,\n" +
                "сначала нужно купить воина потом зелье\n" +
                "* Если в игре с БОТ_БОБОМ вы хотите пойти в бой первым, тогда в первом раунде\n" +
                "не покупайте воина, а просто пропустите ход\n" +
                "*Будьте внимательны что в бою одни нападают, другие отбиваются.\n" +
                "В первом и втором случаи оба воина бьют друг друга\n" +
                "и воин может умереть даже если нападает\n" +
                "* если воин нападает у него повышается сила удара\n" +
                "и она будет расти с каждой атакой до тех пор, пока воин не умрет\n");
    }


    // конец, выход
    public void end() {
        System.out.println("\n" +
                "° ◦ ₒ ˳\uD83C\uDF53˳ ₒ ◦ ° ° ◦ ₒ ˳\uD83C\uDF53˳ ₒ ◦ THE° ◦ ₒ ˳✧\uD83C\uDF53˳ ₒ ◦ ° ° ◦ ₒ ˳ END " +
                "˳ ₒ ◦ ° ° ◦ ₒ ˳\uD83C\uDF53˳ ₒ ◦ ° ◦ ₒ ˳✧\n" + "\n");

    }


}
