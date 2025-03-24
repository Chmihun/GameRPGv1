import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите имя персонажа");
        Game game=new Game();
        game.gamer.setName(sc.nextLine());
        game.Start();

    }
}