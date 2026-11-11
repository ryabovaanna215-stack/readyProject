package readyProject;

import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {
    private String image = "🧌";

    // Добавляем конструктор, который принимает размер доски
    public BigMonster(int sizeBoard) {
        super(sizeBoard); // Передаем этот размер в родительский класс Monster
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override //переопределяем род класс Monster
    public boolean taskMonster(int difficultGame) { //переопределяет метод родительского класса
        if (difficultGame == 1) {
            return taskLittleMonster();
        } else if (difficultGame == 2 || difficultGame == 3){
            System.out.println("Решите задачу:");


            Random random = new Random();

            int x = random.nextInt(15);
            int y = random.nextInt(10);
            int z = random.nextInt(20);
            int trueAnswer = x * y - z;

            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
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
        else {
            Random random = new Random();

            int x = random.nextInt(10);
            int y = random.nextInt(10);
            int z = random.nextInt(1,20);

            int trueAnswer = x * x /y + z;

            System.out.println("Реши пример: " + x + " * " + x + " / " + y + " + " + z + " = ?");
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
    public boolean taskLittleMonster(){
        return super.taskMonster(1);
    }
}
