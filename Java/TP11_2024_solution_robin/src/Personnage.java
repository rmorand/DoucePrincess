public abstract class Personnage implements PersonnageInterface{
    private final String name;
    private final Integer level;
    protected Integer health;
    protected Integer mana;
    protected Integer attack;
    protected Integer defense;
    boolean didDmg;

    public Personnage(String name, Integer level, Integer health, Integer mana, Integer attack, Integer defense){
        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.didDmg = true;
    }

    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    @Override
    public void defend() {
        this.defense += 1;
    }

    @Override
    public String toString(){
        return this.name + " est de niveau " + level + ", il s'agit d'un " + this.getClass().getName();
    }
}
