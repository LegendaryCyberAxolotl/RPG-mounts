public class Client {
    public static void main(String[] args) {
        MountType airbornMount = new AirbornMount();
        MountType groundMount = new GroundMount();
        MountType waterMount = new WaterMount();

        Mount commonGround = new CommonMount("Owlbear", groundMount);
        Mount epicAirborn = new EpicMount("Dragon", airbornMount);
        Mount legendaryWater = new LegendaryMount("Leviathan", waterMount);

        commonGround.move();
        epicAirborn.move();
        legendaryWater.move();
    }
}
