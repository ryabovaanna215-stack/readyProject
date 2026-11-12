package readyProject;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String castle = "🏰";
        String rock = "🪨";
        int sizeBoard = 5;
        int step = 0;

        Person person = new Person(sizeBoard);

        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        int castleY = 1;

        int rockX = 1 + random.nextInt(sizeBoard);
        int rockY = 1 + random.nextInt(sizeBoard);

        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }
        int countMonster = sizeBoard * sizeBoard - sizeBoard - 5;
        Monster[] monsters = new Monster[countMonster];
        int count = 0;

        while (count < countMonster) {
            Monster monster;

            if (random.nextBoolean()) {
                monster = new Monster(sizeBoard);
            } else {
                monster = new BigMonster(sizeBoard);
            }
            int row = monster.getY() - 1;
            int column = monster.getX() - 1;

            if (board[row][column].equals("  ")) {
                board[row][column] = monster.getImage();
                monsters[count] = monster;
                count++;
            }
        }
        board[castleY - 1][castleX - 1] = castle;
        board[rockY - 1][rockX - 1] = rock;

        Helper helper;
        do {
            helper = new Helper(sizeBoard);
        }while(!board[helper.getB()-1][helper.getA()-1].equals("  "));
        board[helper.getB() - 1][helper.getA() - 1] = helper.getHelper();

        System.out.println("Привет! Небольшой справочник для понимания, что есть что перед тем, как начнешь играть:"
                +"\n1.🏰 - замок, придешь сюда - победишь"
                +"\n2.🧙 - главный герой нашей игры"
                +"\n3.🧟, 🧌 - монстры, их надо побеждать если что^^"
                +"\n4.👸 - твой помощник, если решишь его задачу, то получишь доп. жизнь! (если нет, то потеряешь, так что будь осторожен!!!!");
        System.out.println("Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        switch (answer) {
            case "ДА":
                System.out.println("Выбери сложность игры (от 1 до 5):");
                int difficultGame = scanner.nextInt();

                while (true) { //пока у нас все ок и все истинно
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();
                    outputBoard(board, person.getLive());

                    System.out.println("Введите, куда будет ходить персонаж "
                            + "(ход возможен только по вертикали или горизонтали на одну клетку)"
                            + "\nКоординаты персонажа — (x: " + person.getX()
                            + ", y: " + person.getY() + ")");

                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.println(x + ", " + y);

                    if (person.isMoveCorrect(x, y)) {
                        if (board[y - 1][x - 1].equals("  ")) {

                            board[person.getY() - 1][person.getX() - 1] = " ";
                            person.move(x, y);
                            step++;

                            System.out.println("Ход корректный; новые координаты: "
                                    + person.getX() + ", " + person.getY()
                                    + "\nХод номер: " + step);

                        } else if (board[y - 1][x - 1].equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        }

                        else if (board[y - 1][x - 1].equals(helper.getHelper())) {
                            if(helper.taskHelper(difficultGame)){
                                person.upLive();
                                board[person.getY() - 1][person.getX() - 1] = "  ";
                                person.move(x, y);
                                step++;
                            }
                            else{person.downLive();}
                        } else if (board[y - 1][x - 1].equals(rock)) {
                            System.out.println("Ты на камень наткнулся, осторожнее");
                        } else {
                            for (Monster monster : monsters) {
                                if (monster.conflictPerson(x, y)) {
                                    if (monster.taskMonster(difficultGame)) {
                                        board[person.getY() - 1][person.getX() - 1] = "  ";
                                        person.move(x, y);
                                        step++;
                                    } else {
                                        person.downLive();
                                        System.out.println("Вы отступили назад!");
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Некорректный ход");
                    }

                    if (person.getLive() <= 0) {
                        break;
                    }
                }
                if (person.getLive() <= 0) {
                    System.out.println("Закончились жизни. Попробуй снова!");
                }
                break;
            case "НЕТ":
                System.out.println("Жаль, приходи ещё!");
                break;
            default:
                System.out.println("Данные введены неКорРекТНо");
                break;
        }
    }
    static void outputBoard(String[][] board, int live) {
        String leftBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";
        for (String[] row : board) {
            System.out.println(wall);
            for (String col : row) {
                System.out.printf("%s %2s ", leftBlock, col);
            }
            System.out.println(leftBlock);
        }
        System.out.println(wall);
        System.out.println("Количество жизней:\t" + live + "\n");
    }

}
