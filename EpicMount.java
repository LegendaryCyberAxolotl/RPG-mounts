public class EpicMount extends Mount {
    private static final Rarity DEFAULT_RARITY = Rarity.EPIC;
    private static final int DEFAULT_SPEED = 10;
    private static final int DEFAULT_HP = 20;

    public EpicMount(String name,  MountType type) {
        super(name, DEFAULT_SPEED, DEFAULT_HP, type);
    }
}
