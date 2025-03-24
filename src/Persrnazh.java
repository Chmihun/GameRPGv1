public abstract class Persrnazh {
    String name;
    int life;  //единицы жизни
    int maxLife;
    int strength;    //сила
    int dexterity;   //ловкость
    int experience;  // опыт
    int gold;
    int level;

    public Persrnazh(String name, int level, int life, int strength, int dexterity,
                     int experience, int gold) {
        this.dexterity = dexterity;
        this.life = life;
        this.maxLife = life;
        this.name = name;
        this.strength = strength;
        this.experience = experience;
        this.gold = gold;
        this.level = level;
    }

    public int getDexterity() {
        return dexterity;
    }

    public Persrnazh setDexterity(int dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public int getExperience() {
        return experience;
    }

    public Persrnazh setExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public int getGold() {
        return gold;
    }

    public Persrnazh setGold(int gold) {
        this.gold = gold;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public Persrnazh setLevel(int level) {
        this.level = level;
        return this;
    }

    public int getLife() {
        return life;
    }

    public Persrnazh setLife(int life) {
        this.life = life;
        return this;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public Persrnazh setMaxLife(int maxLife) {
        this.maxLife = maxLife;
        return this;
    }

    public String getName() {
        return name;
    }

    public Persrnazh setName(String name) {
        this.name = name;
        return this;
    }

    public int getStrength() {
        return strength;
    }

    public Persrnazh setStrength(int strength) {
        this.strength = strength;
        return this;
    }
}
