public class LegendaryMount extends Mount {
    private static final Rarity DEFAULT_RARITY = Rarity.LEGENDARY;
    private static final int DEFAULT_SPEED = 15;
    private static final int DEFAULT_HP = 30;

    public LegendaryMount(String name, int speed, int HP, MountType type) {
        super(name, DEFAULT_SPEED, DEFAULT_HP, type);
    }
}
