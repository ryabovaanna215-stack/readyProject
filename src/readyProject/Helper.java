package readyProject;

import java.util.Random;
import java.util.Scanner;

public class Helper {
    public String helper = "👸";
    private int a,b;

    Helper(int sizeBoard){
        Random random = new Random();
        a = 1 + random.nextInt(sizeBoard);
        b = 1+ random.nextInt(sizeBoard);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    public boolean taskHelper(int difficultGame) {
        System.out.println("Решите задачу:");

        Random random = new Random();
        int c = random.nextInt(50);
        int d = random.nextInt(50);
        int g = random.nextInt(100);
        if (difficultGame == 1) {
            int trueAnswer = c * d;

            System.out.println("Реши пример: " + c + " * " + d + " = ?");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты получил жизнь!");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else {
            int trueAnswer = c*d+g;
            System.out.println("Реши пример: " + c + " * " + d + "+" + g + "= ?");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты получил жизнь!");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        }
    }
}

