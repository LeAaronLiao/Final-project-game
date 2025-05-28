public class Heal extends Item {
    public Heal(int x, int y) {
        super("heal", "heal.png", x, y);
    }
    @Override
    public void use(Player player) {
        player.setHealth(player.getHealth() + 10);
    }
}
