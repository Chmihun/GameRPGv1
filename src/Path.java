import java.util.Scanner;

public class Path {
    private Game game;


    public Path(Game game) {
        this.game = game;

    }

    public void path() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n\n%-30s куда идем? Введи нужную цифру%n", "Ваш выбор");
        System.out.println();
        System.out.printf("%-40s%n", "1- Темный лес");
        System.out.printf("%-40s%n", "2- в лавку торговцу");
        System.out.printf("%-40s%n", "3- посмотреть свой образ");
        System.out.printf("%-40s%n", "4- выпить зелье");

        System.out.printf("%-40s%n", "5- выйти из игры");
        String path = scanner.nextLine();
        switch (path) {
            case "1" -> game.attack();
            case "2" -> new Dealer((Gamer) game.gamer, game).showcase();//new Dealer(gamer,game).showcase();
            case "3" -> {
                if (game.gamer instanceof Gamer) {
                    ((Gamer) game.gamer).image(game);
                }
            }
            case "4" -> {

                if (game.gamer instanceof Gamer) {
                    if (((Gamer) game.gamer).setInventar(3) == 1) {
                        ((Gamer) game.gamer).drink((game.gamer.life) / 4);
                    } else if (((Gamer) game.gamer).setInventar(4) == 1) {
                        ((Gamer) game.gamer).drink((game.gamer.life) / 2);
                    } else System.out.println("У вас нет зелей");


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    path();
                }

            }
            case "5" -> {
                System.out.println("GAME OVER");
                System.exit(0);
            }
            default -> {
                path();

            }
        }
    }
}
