import java.util.Scanner;

public class Game {
    Persrnazh gamer = new Gamer(1, 150, 30, 4, 50, 300);
    //**************************************************************************************************
//    Persrnazh pers1 = new Skeleton(1, 150, 3, 4, 50, 500);
//    Persrnazh pers2 = new Goblin(1, 200, 35, 4, 50, 500);

    private final Scanner scanner = new Scanner(System.in);

    public void Start() {
        new Path(this).path();
    }

    volatile boolean flag = false;
    boolean humiliation = false;

    public void attack() {
        Persrnazh enemy = Math.random() < 0.5 ?
                new Skeleton(1, 155, 3, 4, 50, 500) :
                new Goblin(1, 200, 35, 4, 50, 500);
        Fight fight = new Fight(enemy, gamer);

        flag = false;
        Thread t1 = new Thread(() -> {
            System.out.println("Введи  1  чтобы выпить зелье, или любую клавишу, чтобы сбежать ");
            fight.fight();  // Начинаем бой
            System.out.println();
            flag = true;

            if (gamer.life > 0) {
                System.out.println(" \nТЫ ПОБЕДИЛ  !!!!\nКуда пойдем дальше?");
                if (!humiliation) {
                    int newExperience = gamer.experience;
                    newExperience += enemy.getMaxLife();
                    gamer.setExperience(newExperience);
                    ((Gamer) gamer).lavelUp();
                    int newGold = enemy.gold + gamer.gold;
                    gamer.setGold(newGold);

                }
                new Path(this).path();
            } else {
                System.out.println("Тебя убили \n  Game Over");
                System.exit(0);
            }
        });
        Thread t2 = new Thread(() -> {
            while (!flag) {
                if (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    if (flag) break;
                    if (str.equals("1")) {
                        if (((Gamer) gamer).setInventar(3) == 1) {
                            ((Gamer) gamer).drink((gamer.life) / 4);
                        }
                        if (((Gamer) gamer).setInventar(4) == 1) {
                            ((Gamer) gamer).drink((gamer.life) / 2);
                        }
                    } else {
                        t1.interrupt();
                        System.out.println("!!!!!!!сбежал!!!!");
                        humiliation = true;
                        ((Gamer) gamer).lavelDown();
                        flag = true;
                        break;
                    }
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("что то не так");
        }

    }
}
