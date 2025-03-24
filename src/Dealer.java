import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Dealer {//торговец

    private Gamer gamer;
    private Game game;

    public Dealer(Gamer gamer, Game game) {
        this.gamer = gamer;
        this.game = game;
        ((Gamer) gamer).inventary(0);
    }
    /*
     * зелье25 + 25%
     * зелье50 + 50%
     * мечь +20 к силе
     * перчатки +20 к лювкости
     * броня -20 сила противника и -20 своей ловкости
     *
     * */

    String potion25 = "зелье на 25%"; //зелье
    String potion50 = "зелье на 50%"; //зелье
    String sword = "меч (+50 к силе)"; //мечь
    String gloves = "перчатки(+50 к ловкости)"; //перчатки
    String armor = "кальчуга(-20 от повреждений)"; //броня

    Map<String, Integer> map = new LinkedHashMap<>() {{
        put(sword, 100);
        put(gloves, 100);
        put(armor, 50);
        put(potion25, 20);
        put(potion50, 50);
    }};

    //   Persrnazh gamer = new Gamer(1, 200, 10, 5, 0, 200);
    public void showcase() {
        System.out.println("\n" +
                "В продаже имеются:");
        int i = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%d:  %-30s : %d golds%n", i++, entry.getKey(), entry.getValue());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\nхотите купить введи номер лота\n" +
                "\n\t\t\tУ ВАС " + gamer.getGold() + " золотых монет\n\t\t\tENTER для выхода");
  /*      В продаже имеются:
        1:  меч (+50 к силе)               : 100 golds
        2:  перчатки(+50 к ловкости)       : 100 golds
        3:  кальчуга(-20 от повреждений)   : 50 golds
        4:  зелье на 25%                   : 20 golds
        5:  зелье на 50%                   : 50 golds*/
        switch (sc.nextLine()) {
            case "1" -> {
                if (((Gamer) gamer).setInventar(0) == 1) System.out.println("предмет уже куплен");
                else {
                    if (gamer.getGold() - map.get(sword) > 0) {
                        ((Gamer) gamer).addInventar(0, 1);//меч
                        System.out.println("вы купили меч");
                        gamer.setGold(gamer.getGold() - map.get(sword));
                        gamer.setStrength(gamer.getStrength() + 50);
                    } else System.out.println("НЕ хватвет золота");
                }
                showcase();
            }
            case "2" -> {
                if (((Gamer) gamer).setInventar(1) == 1) System.out.println("предмет уже куплен");

                else {
                    if (gamer.getGold() - map.get(gloves) > 0) {
                        ((Gamer) gamer).addInventar(1, 1);//перчатки
                        System.out.println("Вы купили перчатки");
                        gamer.setGold(gamer.getGold() - map.get(gloves));
                        gamer.setDexterity(gamer.getDexterity() + 50);
                    } else System.out.println("НЕ хватвет золота");
                }
                showcase();
            }
            case "3" -> {
                if (((Gamer) gamer).setInventar(2) == 1) System.out.println("предмет уже куплен");

                else {
                    if (gamer.getGold() - map.get(armor) > 0) {
                        ((Gamer) gamer).addInventar(2, 1);//кальчуга
                        System.out.println("Вы купили кальчугу");
                        gamer.setGold(gamer.getGold() - map.get(armor));
                        gamer.setLevel(gamer.getLife() + 50);
                    } else System.out.println("НЕ хватвет золота");
                }
                showcase();
            }
            case "4" -> {
                if (((Gamer) gamer).setInventar(3) == 1 || ((Gamer) gamer).setInventar(4) == 1)
                    System.out.println("для зелья больше лотов нет");

                else {
                    if (gamer.getGold() - map.get(potion25) > 0) {
                        System.out.println("Вы купили зелье на 25%");
                        gamer.setGold(gamer.getGold() - map.get(potion25));
                        ((Gamer) gamer).addInventar(3, 1);//зелье на 25%
                    } else System.out.println("НЕ хватвет золота");
                }
                showcase();
            }
            case "5" -> {
                if (((Gamer) gamer).setInventar(4) == 1 || ((Gamer) gamer).setInventar(3) == 1)
                    System.out.println("для зелья больше лотов нет");
                else {
                    System.out.println("Вы купили зелье на 50%");
                    if (gamer.getGold() - map.get(potion50) > 0) {
                        gamer.setGold(gamer.getGold() - map.get(potion50));
                        ((Gamer) gamer).addInventar(4, 1);//зелье на 25%
                    } else System.out.println("НЕ хватвет золота");
                }
                showcase();
            }
            default -> new Path(game).path();
        }
    }
}