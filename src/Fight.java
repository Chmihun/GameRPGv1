public class Fight {
    private final Persrnazh pers1;
    private final Persrnazh pers2;
    Persrnazh persU;
    Persrnazh persM;

    final int time = 700;
    static boolean flagPers = true;

    public Fight(Persrnazh monster, Persrnazh gamer) {
        this.pers1 = gamer;
        this.pers2 = monster;
    }

    public void fight() {
        StringBuilder carentLife;
        if (flagPers) {
            persM = pers2;
            persU = pers1;
            int life = pers1.maxLife;
        } else {
            persM = pers1;
            persU = pers2;
            int life = pers2.maxLife;
        }
        int damage = damageFromEnemy(persM.strength, persU.dexterity);
        int newHealth = persU.life - damage;
        if (newHealth < 0) newHealth = 0;

        persU.setLife(newHealth);
        StringBuilder lifeBar = buildHealthBar(persU.getLife(), persU.getMaxLife(), flagPers ? '+' : '=', 15);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println("ТЫ ПОЗОРНО СБЕЖАЛ");
            return;
        }
        //*********************************************************************************
        printLifeStatus(persU, lifeBar, flagPers);
        //*********************************************************************************
        flagPers = !flagPers;
        if (persU.life > 0 && persM.life > 0) fight();
//        if (pers1.life > 0 && pers2.life <= 0) System.out.println("you WIN");
//        if (pers1.life <= 0 && pers2.life > 0) System.out.println("you LOSER");
    }

    private StringBuilder buildHealthBar(int currentLife, int maxLife, char symbol, int totalLength) {
        int filledLength = (int) Math.round(((double) currentLife / maxLife) * totalLength);
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < filledLength; i++) bar.append(symbol);
        return bar;
    }


    static double newlife(double damageFromUser, int life) {
        final int a2 = 15;
        double d1 = (double) a2 * damageFromUser / (double) life;
        return Math.abs(d1);
    }

    static int damageFromEnemy(int strengthEnemy, int dexterity) {
//        int strength;    //сила
//        int dexterity;   //ловкость
        double damageFromEnemy = strengthEnemy - (dexterity * Math.random());
        damageFromEnemy = Math.max(0, (int) Math.ceil(damageFromEnemy));
        return (int) Math.ceil(damageFromEnemy);

    }

    private static <T extends Persrnazh> void printLifeStatus(T pers, StringBuilder carentLife, boolean flagPers) {// (Persrnazh pers,StringBuilder carentLife) {
        if (carentLife.length() > 5) {
            if (flagPers) {
                System.out.printf("%-10s: %d HP %-18s",
                        pers.getName(), pers.life, carentLife);
            } else {
                System.out.printf("%-10s: %d HP %-1s%n",
                        pers.getName(), pers.life, carentLife);
            }
        } else {
            if (flagPers) {
                System.err.printf("%-10s: %d HP %-18s",
                        pers.getName(), pers.getLife(), carentLife);
            } else {
                System.err.printf("%-10s: %d HP %-1s%n",
                        pers.getName(), pers.getLife(), carentLife);
            }
        }
    }
}


