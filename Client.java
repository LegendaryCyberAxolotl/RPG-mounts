public class Client {
    public static void main(String[] args) {
        MountType airbornMount = new AirbornType();
        MountType groundMount = new GroundType();
        MountType waterMount = new WaterType();

        Mount commonGround = new CommonMount("Owlbear", groundMount);
        Mount epicAirborn = new EpicMount("Dragon", airbornMount);
        Mount legendaryWater = new LegendaryMount("Leviathan", waterMount);

        commonGround.move();
        epicAirborn.move();
        legendaryWater.move();
    }
}
