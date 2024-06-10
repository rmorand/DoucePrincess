public class Guerrier extends Personnage {

    private final Integer resistance;

    public Guerrier(String name, Integer level, Integer health, Integer mana, Integer attack, Integer defense, Integer resistance) {
        super(name, level, health, mana, attack, defense);
        this.resistance = resistance;
    }

    @Override
    public Integer attack() {
        return this.attack;
    }

    @Override
    public void defend() {
        this.defense = this.defense + 1 + this.resistance;
        System.out.println(this.getName() + " se cache derrière son bouclier");
    }

    @Override
    public void special() {
        this.defense += this.defense;
        System.out.println(this.getName() + " double sa défense... Quel pleutre");
    }
}
