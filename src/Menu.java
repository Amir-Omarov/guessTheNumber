import java.util.Random;
import java.util.Scanner;

    /*
        Written by: Omarov Amir;
    */

public class Menu {
    public static Scanner input = new Scanner(System.in);
    public static int counter;

    public static void start() {    // старт игры
        System.out.println("Привет, хочешь начать игру \"Угадай число\" (да / нет)?");
        checkAnswer();
    }

    public static void level() {    // уровни сложности
        System.out.println("Выберите уровень сложности:");
        System.out.println("1. Легкий, от 1 до 10 (включительно);");
        System.out.println("2. Средний, от 1 до 100 (включительно);");
        System.out.println("3. Сложный, от 1 до 1000 (включительно).");
        System.out.println("Введите номер сложности (1 / 2 / 3):");
        selectLevel();
    }

    public static void selectLevel() {    // выбор сложности
        int num = input.nextInt();
        switch (num) {
            case 1:
                System.out.println("Вы выбрали легкий уровень.");
                gameLevel1();
                break;
            case 2:
                System.out.println("Вы выбрали средний уровень.");
                gameLevel2();
                break;
            case 3:
                System.out.println("Вы выбрали сложный уровень.");
                gameLevel3();
                break;
            default:
                System.out.println("Вы ввели неверный номер, введите заново (1 / 2 / 3):");
                selectLevel();
        }
    }

    public static void checkAnswer() {    // проверка ответа на старт игры
        while (true) {
            String answer = input.next();
            if (answer.equals("Да") || answer.equals("да")) {
                level();
                break;
            } else if (answer.equals("Нет") || answer.equals("нет")) {
                System.out.println("Прощай!");
                break;
            } else {
                System.out.println("Не понял твоего ввода, введи еще раз (да / нет).");
            }
        }
    }

    public static void gameLevel1() {    // легкий уровень
        Random rand = new Random();
        System.out.println("Загадываю число... (от 1 до 10)");
        System.out.println("Число готово, начинай!");
        int max = 11;
        int number = rand.nextInt(1, 11);
        guessing(number, max - 1);
    }

    public static void gameLevel2() {    // средний уровень
        Random rand = new Random();
        System.out.println("Загадываю число... (от 1 до 100)");
        System.out.println("Число готово, начинай!");
        int max = 101;
        int number = rand.nextInt(1, 101);
        guessing(number, max - 1);
    }

    public static void gameLevel3() {    // сложный уровень
        Random rand = new Random();
        System.out.println("Загадываю число... (от 1 до 1000)");
        System.out.println("Число готово, начинай!");
        int max = 1001;
        int number = rand.nextInt(1, 1001);
        guessing(number, max - 1);
    }

    public static void guessing(int number, int max) {    // угадывание загаданного числа
        counter = 1;
        while (true) {
            int option = input.nextInt();
            if (option > max) {
                System.out.println("Число слишком большое, что вышло за рамки игры (от 1 до " + max + ")");
            } else if (option < 1) {
                System.out.println("Число слишком маленькое, что вышло за рамки игры (от 1 до " + max + ")");
            } else if (option > number) {
                System.out.println("Твоё число больше загаданного, попробуй еще!");
                counter++;
            } else if (option < number) {
                System.out.println("Твоё число меньше загаданного, попробуй еще!");
                counter++;
            } else {
                System.out.println("Верно!");
                end();
                break;
            }
        }
    }

    public static void end() {    // конец игры
        System.out.println("Потрачено попыток: " + counter);
        System.out.println("Хочешь сыграть заново (да / нет)?");
        checkAnswer();
    }
}
