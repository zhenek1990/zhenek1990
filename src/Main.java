import control.Game;

/*
Создать игру Битва Воинов.
Абстрактный класс: персонаж.
Касты: варвары, лучники...
Класс Игра.
Простой вариант: два против двух.

*Интерфейс Целитель.
 */
public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.go();
    }
}
