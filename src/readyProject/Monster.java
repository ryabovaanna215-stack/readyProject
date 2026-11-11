package readyProject;

import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "🧟";
    private final int x, y; // final - не дает перемещаться

    Monster(int sizeBoard) {
        Random random = new Random();
        x = 1 + random.nextInt(sizeBoard); //выбирает случайную колонку от 1 до sizeBoard.
        y = 1 + random.nextInt(sizeBoard - 1); // выбирает случайную строку, но не затрагивает самую нижнюю
    }

    public int getX() { // возвращают текущие координаты монстра
        return x;
    }

    public int getY() { //  возвращают текущие координаты монстра
        return y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean conflictPerson(int personX, int personY) { //Проверяет столкновение с игроком
        return personX == x && personY == y;
    }

    public boolean taskMonster(int difficultGame) { //Запускает мини-игру (битву) с монстром
        System.out.println("Решите задачу:");

        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        int c = random.nextInt(100);
        if (difficultGame == 1) {
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else {
            int trueAnswer = a + b - c;

            System.out.println("Реши пример: " + a + " + " + b + "-"+ c + " = ?");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        }
    }
}
