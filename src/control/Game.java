package control;

import characters.Archer;
import characters.Warrior;
import gamers.Bot;
import gamers.User;
import otherComand.CommandStr;
import otherComand.OtherValuesInt;

import java.util.Scanner;

public class Game {

    private Scanner scStr;
    private String userInput;
    private int userNum;

    private int count;  // СЧЁТЧИК РАУНДОВ
    private Warrior here; // ОБЩИЙ ВОИН
    private Warrior heroOne; // ВОИН ПЕРВОГО ИГРОКА
    private Warrior heroTwo; // ВОИН ВТОРОГО ИГРОКА
    private Warrior heroBot; // БОТ ВОИН

    private boolean eqBot;

    User playerOne;
    User playerTwo;
    Bot bot;
    DecorationAndInfo decAndInfo;
    BattlePreparation battleClass;

    //  конструктор
    public Game() {

        scStr = new Scanner(System.in);
        decAndInfo = new DecorationAndInfo();
        battleClass = new BattlePreparation();

    }

    // инициализация играков
    public void initialization() {
        System.out.println(CommandStr.PLAYER.value + " " + count + " Напишите ваше имя ");
        playerOne = new User(scStr.nextLine(), OtherValuesInt.BALANCE.val);
        playerOne.info();
        count++;
        System.out.println();
        if (userInput.equalsIgnoreCase("ИГРОК")) {
            System.out.println();
            System.out.println(CommandStr.PLAYER.value + " " + count + " Напишите ваше имя ");
            playerTwo = new User(scStr.nextLine(), OtherValuesInt.BALANCE.val);
            playerTwo.info();
            System.out.println();
        } else if (userInput.equalsIgnoreCase("БОТ")) {
            System.out.println("* COMPUTER *");
            bot = new Bot(" БOT_БOБ ", OtherValuesInt.BALANCE.val);
            bot.info();
        } else {
            System.out.println("что-то пошло не так, в методе initialization");
        }
        count--;
    }

    //  логика БОТ_БОБА
    public void botGame() {
        if (count % 2 == 0) {

            sleep();
            if (bot.getHeroes().isEmpty()) {
                for (int i = 0; i < 4; i++) {

                    if (bot.getBalance() >= OtherValuesInt.PRICE_TWO.val) {
                        here = battleClass.marketplace(bot.numberRandom(battleClass.getMARKET().size()));
                        bot.setBalance(bot.getBalance() - here.getPRICE());
                        bot.setHeroes(here);
                    } else if (bot.getBalance() >= OtherValuesInt.PRICE_ONE.val &&
                            bot.getBalance() < OtherValuesInt.PRICE_TWO.val) {
                        bot.setBalance(bot.getBalance() - here.getPRICE());
                        bot.setHeroes(battleClass.marketplace(0));
                    }else if (bot.getBalance() < OtherValuesInt.PRICE_ONE.val){
                        System.out.println("У " + bot.getName() + " не хватает денег\n");
                        break;
                    }
                    else {
                        continueOrEnd();
                        break;
                    }
                    System.out.println("\n Сделка прошла успешно\n");
                    System.out.println(bot.toString());

                }
            }

            if (!playerOne.getHeroes().isEmpty()) {
                battle();
                bot.setBalance(bot.getBalance() + OtherValuesInt.BATTLE_PRIZE.val);   // начисляем награду за бой
                System.out.println("\nВам начислена награда за бой 100 $\n");
                System.out.println(bot.toString());
            } else {
                System.out.println("Сообщение от БОТ_БОБ \n Купи себе воина, если не боишся.\n");
                System.out.println("БОТ_БОБ пропустил ход\n");
            }
            System.out.println(decAndInfo.getGO_ONE());
            count++;
        }
    }

    //  делаем паузы
    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // стартовый метод , вся логика
    public void go() {

        decAndInfo.gameName();
        gameMode();
        initialization();
        System.out.println(decAndInfo.getGO_ONE());


        do {
            System.out.println("*** РАУНД *** " + "\n  *** " + count + " ***   \n");

            if (!eqBot) {

                decAndInfo.mainMenu();
                selectPlayer();
                mainMenu(userNum);

            } else {
                if (count % 2 != 0) {
                    decAndInfo.mainMenu();
                    selectPlayer();
                    mainMenu(userNum);

                } else {
                    botGame();

                }
            }
        } while (userNum != 6);

    }

    //  выбор режима игры
    public void gameMode() {
        decAndInfo.gameModeInfo();

        do {
            decAndInfo.selectGameMode();
            try {
                userInput = scStr.nextLine();
            } catch (Exception e) {
                decAndInfo.getWRONG_COMMAND();
            }

            eqBot = userInput.equalsIgnoreCase(CommandStr.BOT.value);
            boolean eqPlayer = userInput.equalsIgnoreCase(CommandStr.PLAYER.value);

            if (eqPlayer) {
                System.out.println("Вы выбрали игру с другом ");
                count++;
            } else if (eqBot) {
                System.out.println("Вы выбрали игру с компьютером ");
                count++;
            } else {
                System.out.println("Вы ввели не правильную команду.");
                System.out.println("Попробуйте ещё раз");
                System.out.println();
            }
        } while (count != 1);


    }

    //  выбор числа меню и перевод в цифру
    public void selectPlayer() {
        do {

            System.out.println("Введите число : \n");

            userInput = scStr.nextLine();
            try {
                userNum = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                if (userInput.equalsIgnoreCase("rules")){
                    decAndInfo.rules();
                }else {
                    System.out.println("Не правильная команда");
                }
                return;
            }

        } while (userNum < 0 || userNum > 6);
    }

    //  присваиваем воина плееру
    public void heroesPlayer(Warrior hero1) {

        int val;

        if (!eqBot) {
            if (count % 2 != 0) {
                val = playerOne.getBalance() - hero1.getPRICE(); // вычесляем баланс
                if (val < 0) {
                    System.out.println("У вас недостаточно денег\n");

                } else {
                    playerOne.setBalance(val);
                    playerOne.setHeroes(hero1);
                    System.out.println("\n Сделка прошла успешно\n");
                }
            } else {
                val = playerTwo.getBalance() - hero1.getPRICE(); // вычесляем баланс
                if (val < 0) {
                    System.out.println("У вас недостаточно денег\n");

                } else {
                    playerTwo.setBalance(val);
                    playerTwo.setHeroes(hero1);
                    System.out.println("\n Сделка прошла успешно\n");
                }
            }
        } else {
            if (count % 2 != 0) {
                val = playerOne.getBalance() - hero1.getPRICE(); // вычесляем баланс
                if (val < 0) {
                    System.out.println("У вас недостаточно денег\n");
                } else {
                    playerOne.setBalance(val);
                    playerOne.setHeroes(hero1);
                    System.out.println("\n Сделка прошла успешно\n");
                }
            }
        }
    }

    //  посмотреть всех воинов каждого игрока
    public void showAllPlayer() {
        if (!eqBot) {
            if (count % 2 != 0) {
                if (!playerOne.getHeroes().isEmpty()) {
                    for (Warrior hero : playerOne.getHeroes()) {

                        System.out.println(hero.toString());
                        System.out.println();
                    }
                } else {
                    System.out.println("\nУ вас нет, не одного воина\n");
                }
            } else {
                if (!playerTwo.getHeroes().isEmpty()) {
                    for (Warrior hero : playerTwo.getHeroes()) {

                        System.out.println(hero.toString());
                        System.out.println();
                    }
                } else {
                    System.out.println("\nУ вас нет, не одного воина\n");
                }
            }

        } else {
            if (count % 2 != 0) {
                if (!playerOne.getHeroes().isEmpty()) {
                    for (Warrior hero : playerOne.getHeroes()) {

                        System.out.println(hero.toString());
                        System.out.println();
                    }
                } else {
                    System.out.println("\nУ вас нет, не одного воина\n");
                }

            }
        }
    }

    // главное меню // и в основном вся логика
    public void mainMenu(int num) {

        switch (num) {
            case 0: {    // в бой
                int val;

                if (count % 2 != 0 && !eqBot && playerTwo.getHeroes().isEmpty()) {
                    System.out.println("Выберите команду - \"пропустить ход\"");
                    System.out.println("У 2 " + playerTwo.getName() + " игрока нет воина\n");
                    break;
                } else if (count % 2 == 0 && !eqBot && playerOne.getHeroes().isEmpty()) {
                    System.out.println("Выберите команду - \"пропустить ход\"");
                    System.out.println("У " + playerOne.getName() + "  игрока нет воина\n");
                    break;
                } else if (count % 2 != 0 && eqBot && bot.getHeroes().isEmpty()) {
                    System.out.println("Выберите команду - \"пропустить ход\"");
                    System.out.println("У " + bot.getName() + " нет воина\n");
                    break;
                } else if (playerOne.getHeroes().isEmpty() || !eqBot && playerTwo.getHeroes().isEmpty()) {
                    System.out.println("\nУ вас нет, не одного воина\n");
                    break;
                }

                battle();
                System.out.println("\nВам начислена награда за бой 100 $\n");
                if (!eqBot) {
                    if (count % 2 == 0) {
                        val = playerTwo.getBalance() + OtherValuesInt.BATTLE_PRIZE.val;  // начисляем награду за бой
                        playerTwo.setBalance(val);
                        System.out.println(decAndInfo.getGO_ONE());
                    } else {
                        val = playerOne.getBalance() + OtherValuesInt.BATTLE_PRIZE.val; // начисляем награду за бой
                        playerOne.setBalance(val);
                        System.out.println(decAndInfo.getGO_TWO());
                    }
                } else {
                    val = playerOne.getBalance() + OtherValuesInt.BATTLE_PRIZE.val; // начисляем награду за бой
                    playerOne.setBalance(val);
                    System.out.println(decAndInfo.getGO_BOT());


                }

                count++;
                break;

            }


            case 1: { // рынок

                decAndInfo.buyWarrior();
                decAndInfo.characterSelection();

                do {

                    selectPlayer();
                } while (userNum < 1 || userNum > 5);

                if (userNum == 5) {
                    battleClass.showAllMarket();
                    return;
                } else {
                    here = battleClass.marketplace(userNum - 1);
                    heroesPlayer(here);
                    break;
                }
            }
            case 2: {  // просмотр всех воинов игрока
                showAllPlayer();
                break;
            }
            case 3: {  // баланс и имя игрока
                if ((count % 2 != 0)) {
                    playerOne.info();
                } else {
                    playerTwo.info();
                }
                break;
            }
            case 4: {  // пропустить ход

                count++;
                if (!eqBot) {
                    if (count % 2 != 0) {
                        System.out.println(decAndInfo.getGO_ONE());
                    } else {
                        System.out.println(decAndInfo.getGO_TWO());
                    }
                } else {
                    if (count % 2 != 0) {
                        System.out.println(decAndInfo.getGO_ONE());
                    } else {
                        System.out.println(decAndInfo.getGO_BOT());
                    }
                }

                break;
            }
            case 5: {  //  купить зелье

                int sumPotion;

                if (count % 2 != 0) {
                    sumPotion = OtherValuesInt.PRICE_POTION.val * playerOne.getHeroes().size();

                    if (playerOne.getBalance() < sumPotion) {
                        System.out.println("У вас нет денег \n");
                        break;
                    } else if (playerOne.getHeroes().isEmpty()){

                        System.out.println("\nСначало купите воина , только потом зелье \n");
                        break;

                    } else {
                        playerOne.setBalance(playerOne.getBalance() - sumPotion);
                        for (Warrior hero : playerOne.getHeroes()) {
                            hero.setPotion(true);
                        }
                        System.out.println("Вы купили магическое зелье , всем своим воинам ");
                    }
                } else {
                    sumPotion  = OtherValuesInt.PRICE_POTION.val * playerTwo.getHeroes().size();
                    if (playerOne.getBalance() < sumPotion) {
                        System.out.println("У вас нет денег \n");
                        break;
                    }else if (playerOne.getHeroes().isEmpty()){

                        System.out.println("\nСначало купите воина , только потом зелье \n");
                        break;

                    } else {
                        System.out.println("Вы купили магическое зелье , всем своим воинам");
                        playerTwo.setBalance(playerTwo.getBalance() - sumPotion);
                        for (Warrior hero : playerTwo.getHeroes()) {
                            hero.setPotion(true);
                        }
                    }
                }

                System.out.println("ВНИМАНИЕ \nЗелье действует один раунд\n");
                break;
            }
            case 6: {  // выход
                decAndInfo.end();
                System.exit(0);
                break;
            }

        }

    }

 //  битва
    public void battle() {
        int size;
        if (!eqBot) {
            size = Math.max(playerOne.getHeroes().size(), playerTwo.getHeroes().size());
        } else {
            size = Math.max(playerOne.getHeroes().size(), bot.getHeroes().size());
        }

        sleep();
        for (int i = 0; i < size; i++) {

            try {
                if (playerOne.getHeroes().isEmpty()) {
                    System.out.println("У " + playerOne.getName() + " игрока, нет воина ");
                    break;
                } else {
                    heroOne = playerOne.randomWar();
                }
                if (!eqBot) {
                    if (playerOne.getHeroes().isEmpty()) {
                        System.out.println("У " + playerTwo.getName() + " игрока, нет воина ");
                        break;
                    } else {
                        heroTwo = playerTwo.randomWar();
                    }
                } else {
                    if (bot.getHeroes().isEmpty()) {
                        System.out.println("У " + bot.getName() + " игрока, нет воина ");
                        break;
                    } else {
                        heroBot = bot.randomWar();
                    }
                }
            } catch (NullPointerException e) {
                continue;
            }

            System.out.println("В АТАКУ");
            if (!eqBot) {
                if (count % 2 != 0) {
                    System.out.println("всем воинам 1 игрока присваевается +3 к силе\n");
                    heroOne.setImpactForce(heroOne.getImpactForce() + 3);
                } else {
                    System.out.println("всем воинам 2 игрока присваевается +3 к силе\n");
                    heroTwo.setImpactForce(heroTwo.getImpactForce() + 3);
                }
            } else {
                if (count % 2 != 0) {
                    System.out.println("всем воинам 1 игрока присваевается +3 к силе\n");
                    heroOne.setImpactForce(heroOne.getImpactForce() + 3);

                } else {
                    System.out.println("всем БOT воинам присваевается +3 к силе\n");
                    heroBot.setImpactForce(heroBot.getImpactForce() + 3);
                }
            }


            assert heroOne != null;

            if (eqBot) {
                assert heroBot != null;
                if (heroBot.getImpactForce() - heroOne.getProtection() > 0) {
                    heroOne.setHealthPoint(heroOne.getHealthPoint() - (heroBot.getImpactForce() - heroOne.getProtection()));
                }
                if (heroOne.getImpactForce() - heroBot.getProtection() > 0) {
                    heroBot.setHealthPoint(heroBot.getHealthPoint() - (heroOne.getImpactForce() - heroBot.getProtection()));
                }

            } else {
                assert heroTwo != null;
                if (heroOne.getImpactForce() - heroTwo.getProtection() > 0) {
                    heroTwo.setHealthPoint(heroTwo.getHealthPoint() - (heroOne.getImpactForce() - heroTwo.getProtection()));
                }
                if (heroTwo.getImpactForce() - heroOne.getProtection() > 0) {
                    heroOne.setHealthPoint(heroOne.getHealthPoint() - (heroTwo.getImpactForce() - heroOne.getProtection()));
                }

            }

            if (count % 2 != 0 && !eqBot) {
                sleep();
                if (heroOne.isPotion()) {
                    heroOne.potionPower();
                } else {
                    heroOne.toAttack();
                }
                sleep();
                heroTwo.toAttack();
                sleep();
                System.out.println("\nВоин 1 игрока " + heroOne.getRACE() + " по имени " + heroOne.getNAME()
                        + "\nСила удара - " + heroOne.getImpactForce() + " | " + "Защита - " + heroOne.getProtection()
                        + "\nАтакует воина 2 игрока " + heroTwo.getRACE() + " по имени " + heroTwo.getNAME()
                        + "\nсила удара - " + heroTwo.getImpactForce() + " | " + "защита - " + heroTwo.getProtection() + "\n");

                if (heroOne.getHealthPoint() > 1) {
                    System.out.println("У воина " + heroOne.getRACE() + " по имени " + heroOne.getNAME() + " осталось "
                            + heroOne.getHealthPoint() + "% жизни \n");
                }

                if (heroTwo.getHealthPoint() > 1) {
                    System.out.println("У воина " + heroTwo.getRACE() + " по имени " + heroTwo.getNAME() + " осталось "
                            + heroTwo.getHealthPoint() + "% жизни \n");
                }

            } else if (count % 2 != 0 && eqBot) {

                sleep();
                if (heroOne.isPotion()) {
                    heroOne.potionPower();
                heroOne.setPotion(false);
                } else {
                    heroOne.toAttack();
                }

                sleep();
                heroBot.toAttack();

                sleep();
                System.out.println("\nВоин 1 игрока " + heroOne.getRACE() + " по имени " + heroOne.getNAME()
                        + "\nСила удара - " + heroOne.getImpactForce() + " | " + "Защита - " + heroOne.getProtection()
                        + "\nАтакует Бот воина " + heroBot.getRACE() + " по имени " + heroBot.getNAME()
                        + "\nсила удара - " + heroBot.getImpactForce() + " | " + "защита - " + heroBot.getProtection() + "\n");

                if (heroOne.getHealthPoint() > 1) {
                    System.out.println("У воина " + heroOne.getRACE() + " по имени " + heroOne.getNAME() + " осталось "
                            + heroOne.getHealthPoint() + "% жизни \n");
                }

                if (heroBot.getHealthPoint() > 1) {
                    System.out.println("У воина " + heroBot.getRACE() + " по имени " + heroBot.getNAME() + " осталось "
                            + heroBot.getHealthPoint() + "% жизни \n");
                }
            } else if (count % 2 == 0 && !eqBot) {

                sleep();
                if (heroTwo.isPotion()) {
                    heroTwo.potionPower();
                    heroTwo.setPotion(false);
                } else {
                    heroTwo.toAttack();
                }

                sleep();
                heroOne.toAttack();

                sleep();
                System.out.println("\nВоин 2 игрока " + heroTwo.getRACE() + " по имени " + heroTwo.getNAME()
                        + "\nСила удара - " + heroTwo.getImpactForce() + " | " + "Защита - " + heroTwo.getProtection()
                        + "\nАтакует воина 1 игрока " + heroOne.getRACE() + " по имени " + heroOne.getNAME()
                        + "\nсила удара - " + heroOne.getImpactForce() + " | " + " защита - " + heroOne.getProtection() + "\n");

                if (heroTwo.getHealthPoint() > 0) {
                    System.out.println("У воина " + heroTwo.getRACE() + " по имени " + heroTwo.getNAME() + " осталось "
                            + heroTwo.getHealthPoint() + "% жизни \n");
                }

                if (heroOne.getHealthPoint() > 0)
                    System.out.println("У воина " + heroOne.getRACE() + " по имени " + heroOne.getNAME() + " осталось "
                            + heroOne.getHealthPoint() + "% жизни \n");
            } else if (count % 2 == 0 && eqBot) {

                sleep();
                heroBot.toAttack();

                sleep();
                heroOne.toAttack();

                sleep();
                System.out.println("\nБOT Воин " + heroBot.getRACE() + " по имени " + heroBot.getNAME()
                        + "\nСила удара - " + heroBot.getImpactForce() + " | " + "Защита - " + heroBot.getProtection()
                        + "\nАтакует воина 1 игрока " + heroOne.getRACE() + " по имени " + heroOne.getNAME()
                        + "\nсила удара - " + heroOne.getImpactForce() + " | " + " защита - " + heroOne.getProtection() + "\n");

                sleep();
                if (heroBot.getHealthPoint() > 0) {
                    System.out.println("У воина " + heroBot.getRACE() + " по имени " + heroBot.getNAME() + " осталось "
                            + heroBot.getHealthPoint() + "% жизни \n");
                }
                sleep();
                if (heroOne.getHealthPoint() > 0)
                    System.out.println("У воина " + heroOne.getRACE() + " по имени " + heroOne.getNAME() + " осталось "
                            + heroOne.getHealthPoint() + "% жизни \n");

            }

            checkForWarrior();

            continueOrEnd();

        }
        sleep();
    }

//    проверка воина живой он или нет
    public void checkForWarrior() {


        if (heroOne.getHealthPoint() < 1) {
            playerOne.getHeroes().remove(heroOne);
            System.out.println("Воин 1 игрока " + heroOne.getRACE()
                    + " по имени " + heroOne.getNAME() + " УМЕР\n");
        }
        if (!eqBot) {
            if (heroTwo.getHealthPoint() < 1) {
                playerTwo.getHeroes().remove(heroTwo);
                System.out.println("Воин 2 игрока " + heroTwo.getRACE()
                        + " по имени " + heroTwo.getNAME() + " УМЕР\n");
            }
        } else {
            if (heroBot.getHealthPoint() < 1) {
                bot.getHeroes().remove(heroBot);
                System.out.println("БOT Воин " + heroBot.getRACE()
                        + " по имени " + heroBot.getNAME() + " УМЕР\n");

            }
        }
    }

    // проверка возможности играть дальше
    public void continueOrEnd() {
        if (playerOne.getHeroes().isEmpty() && playerOne.getBalance() < OtherValuesInt.PRICE_ONE.val) {

            System.out.println("\n    - ПОБЕДА -");
            if (!eqBot) {
                System.out.println("Игрок " + playerTwo.getName() + " ВЫИГРАЛ");
            } else {
                System.out.println("   * COMPUTER *\n" + bot.getName() + " ВЫИГРАЛ");
            }
            System.exit(0);
        } else if (!eqBot) {

            if (playerTwo.getHeroes().isEmpty() && playerTwo.getBalance() < OtherValuesInt.PRICE_ONE.val) {
                System.out.println("\n    - ПОБЕДА -");
                System.out.println("Игрок " + playerOne.getName() + " ВЫИГРАЛ");

                System.exit(0);
            } else if (playerOne.getHeroes().isEmpty() && playerOne.getBalance() < OtherValuesInt.PRICE_ONE.val
                    && playerTwo.getHeroes().isEmpty() && playerTwo.getBalance() < OtherValuesInt.PRICE_ONE.val) {
                System.out.println("\nЗЕМЛЯ ЗАБРАЛА ВСЕХ");
                System.out.println("ПОБЕДИТЕЛЯ НЕТ");
                System.exit(0);
            }

        } else {
            if (bot.getHeroes().isEmpty() && bot.getBalance() < OtherValuesInt.PRICE_ONE.val) {
                System.out.println("    \n- ПОБЕДА -");
                System.out.println("Игрок " + playerOne.getName() + " ВЫИГРАЛ");

                System.exit(0);
            } else if (playerOne.getHeroes().isEmpty() && playerOne.getBalance() < OtherValuesInt.PRICE_ONE.val
                    && bot.getHeroes().isEmpty() && bot.getBalance() < OtherValuesInt.PRICE_ONE.val) {
                System.out.println("\nЗЕМЛЯ ЗАБРАЛА ВСЕХ");
                System.out.println("ПОБЕДИТЕЛЯ НЕТ");
                System.exit(0);

            }
        }
    }
}



