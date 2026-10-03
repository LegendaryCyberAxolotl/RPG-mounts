public abstract class Mount {
    protected String name;
    protected int speed;
    protected int HP;
    protected MountType type;
    
    public Mount(String name, int speed, int HP, MountType type) {
        this.name = name;
        this.speed = speed;
        this.HP = HP;
        this.type = type;
    }
}
