public class Soigneur extends Personnage {

    private final Integer regen;

    public Soigneur(String name, Integer level, Integer health, Integer mana, Integer attack, Integer defense, Integer regen) {
        super(name, level, health, mana, attack, defense);
        this.regen = regen;
    }

    @Override
    public Integer attack() {
        return this.attack;
    }

    @Override
    public void defend() {
        this.setDefense(this.getDefense() + 1);
        System.out.println(this.getName() + " invoque un bouclier magique.");
    }

    @Override
    public void special() {
        if (this.mana >= 10) {
            this.mana -= 10;
            this.health += 10;
            System.out.println(this.getName() + " se soigne de 10 HP");
        } else {
            System.out.println(this.getName() + " tente de se soigner mais n'as pas de mana :(");
        }
    }
}
