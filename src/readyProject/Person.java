package readyProject;

import java.util.Random;

public class Person {
    private int x, y;
    private String image = "🧙";
    private int live = 3;

    Person(int sizeBoard) {
        Random random = new Random();
        x = 1 + random.nextInt(sizeBoard); // выбирает случайную клетку от 1 до sizeBoard
        y = sizeBoard; // ставит персонажа в самую нижнюю клетку
    }

    Person(int x, int y) { // создает персонажа в строго указанных координатах
        this.x = x;
        this.y = y;
    }

    Person() { // конструктор по умолчанию
        this(1, 1);
    }

    public int getX() { //возвращает текущие координаты персонажа
        return x;
    }

    public int getY() { //возвращает текущие координаты персонажа
        return y;
    }

    public int getLive() { //возвращает текущие кол-во жизней
        return live;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) { //позволяет изменить внешний вид персонажа
        this.image = image;
    }

    public boolean isMoveCorrect(int x, int y) { //проверяет, может ли персонаж сделать шаг
        return this.x == x && Math.abs(this.y - y) == 1 // либо меняется y, но не меняется x
                || this.y == y && Math.abs(this.x - x) == 1; // либо меняется x, но не меняется y
    }

    void move(int x, int y) { //перемещает персонажа на новые координаты
        this.x = x;
        this.y = y;
    }

    public void downLive() { // уменьшает кол-во жизней
        if (live <= 0) {
            live = 0;
        } else {
            live--;
        }
    }
    public void upLive(){
        live++;
    }
}