import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gamer extends Persrnazh {   //игрок
    private List<Integer> invenary = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    public Gamer(String name,int level, int life, int strength, int dexterity, int experience, int gold) {
        super(name, level, life, strength, dexterity, experience, gold);

    this.name=name;
    }

//    @Override
//    public String getName() {
//        return name;
//    }

    public void drink(int addlife) {

        if (inventary(3) == 1 || inventary(4) == 1) {  // Проверяем, есть ли зелье в инвентаре
            this.maxLife += addlife;  // Изменяем максимальное здоровье
            this.life += addlife;  // Изменяем текущее здоровье
            System.out.println("Ты выпил зелье! Новое здоровье: " + this.life);
            invenary.set(3, 0);
            invenary.set(4, 0);
        } else {
            System.out.println("У вас нет зелий!");
        }

    }

    public void lavelUp() {
        int expVar=level * 500;
        if (experience > expVar) {
            setLife(getMaxLife() + getMaxLife() * getLevel() / 10);
            setStrength(getStrength() + getStrength() * getLevel() / 10);
            setDexterity(getDexterity() + getDexterity() * getLevel() / 10);
            int newlavel = getLevel();
            newlavel++;
            setLevel(newlavel);
        }
    }

    public void lavelDown() {
        setLife(Math.max(1, getMaxLife() - getMaxLife() * getLevel() / 5));
        setStrength(Math.max(1, getStrength() - getStrength() * getLevel() / 5));
        setDexterity(Math.max(1, getDexterity() - getDexterity() * getLevel() / 5));
    }

    public void addInventar(int index, int i) {
        invenary.set(index, i);
    }

    public int setInventar(int i) {
        return invenary.get(i);
    }

    public int inventary(int i) {

//        invenary.add(21);
//        invenary.add(21);
//        invenary.add(21);
//        invenary.add(21);
//        invenary.add(21);
        /*      В продаже имеются:
        1:  меч (+50 к силе)               : 100 golds
        2:  перчатки(+50 к ловкости)       : 100 golds
        3:  кальчуга(-20 от повреждений)   : 50 golds
        4:  зелье на 25%                   : 20 golds
        5:  зелье на 50%                   : 50 golds*/
        return invenary.get(i);
//    int[]invenary=new int[5];
    }

    public void image(Game game) {
        int d = 2;
        String s1 = inventary(0) == 1 ? " { с учетом +" + 50 + " ->МЕЧ}" : "";
        String s2 = inventary(1) == 1 ? " { с учетом +" + 50 + " ->ПЕРЧАТОК}" : "";
        String s3 = inventary(2) == 1 ? " На вас надета КАЛЬЧУГА{-" + 20 + "}% жизни" : "";
        String s4 = inventary(3) == 1 ? " В рюкзаке имеется малое зелье на +25% к жизни" : "";

        System.out.println("Ваши параметры:");
        System.out.printf("Ваш уровень: %d\n" +
                        "Очки жизни: %d\n" +
                        "Сила: %d%s\n" +
                        "Ловкость: %d%s\n" +
                        "Опыт: %d\n" +
                        "Золото: %d\n\n%s\n%s\n",
                level,
                life,
                strength,
                s1,
                dexterity,
                s2,
                experience,
                gold,
                s3, s4);
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER для продолжения");
        sc.nextLine();
        game.Start();
    }
}
