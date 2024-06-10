public class Mage extends Personnage {

    private final Integer magicPower;

    public Mage(String name, Integer level, Integer health, Integer mana, Integer attack, Integer defense, Integer resistance) {
        super(name, level, health, mana, attack, defense);
        this.magicPower = resistance;
    }

    @Override
    public Integer attack() {
        return this.attack + this.magicPower;
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
            this.attack += 10;
        } else {
            System.out.println(this.getName() + " veut renforcer son attaque mais n'as pas assez de mana.");
        }
    }
}
