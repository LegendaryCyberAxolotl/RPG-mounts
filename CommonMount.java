public class CommonMount extends Mount {
    private static final Rarity DEFAULT_RARITY = Rarity.COMMON;
    private static final int DEFAULT_SPEED = 5;
    private static final int DEFAULT_HP = 10;

    public CommonMount(String name, MountType type) {
        super(name, DEFAULT_SPEED, DEFAULT_HP, type);
    }
    
}
