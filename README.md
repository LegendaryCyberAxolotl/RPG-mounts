# Clean code orinciples

## Clear separation of abstraction-side vs. implementation-side responsibilities (no leaking implementor details to the client)

`Mount` is an abstraction with atributes common for all mounts and contains a method for movement

`CommonMount`, `EpicMount` and `LegendaryMount` define distinctive features of each rarity

`MountType` is contains methods that depend on a type of a mount

`GroundType`, `WaterType` and `AirbornType` define behavior unique for each type of mounts

## Meaningful names distinguishing Abstraction vs. Implementor roles

Abstraction is a thing that can vary in multiple dimensions.

It is clear that `Mount` and `CommonMount`, `EpicMount` and `LegendaryMount` are abstractions because the topic is Mounts and we want to make them vary in rarities and types.

Implementor is responsible for a mechanism of what the Abstraction does. In this case, types of mounts is the Implementors because they tell mounts how they move depending on their types.

So it is clear that `MountType` and `GroundType`, `WaterType` and `AirbornType` are implementors.

## Small, focused classes on both sides of the bridge

```java
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

    public void move() {
        System.out.println(name + ": " + type.move());
    }
}
```

```java
public class LegendaryMount extends Mount {
    private static final Rarity DEFAULT_RARITY = Rarity.LEGENDARY;
    private static final int DEFAULT_SPEED = 15;
    private static final int DEFAULT_HP = 30;

    public LegendaryMount(String name, MountType type) {
        super(name, DEFAULT_SPEED, DEFAULT_HP, type);
    }
}
```

```java
public interface MountType {
    String move();
}
```

```java
public class WaterType implements MountType {
    @Override
    public String move() {
        return "I can swim!";
    }
}
```

> Classes are small and do only one job. `Mount` describes all mounts, `LegendaryMount` describes unique features of legendary mounts, `MountType` tells what the type is responsible for, and `WaterType` tells how water type mounts move.

## No duplicated logic between Concrete Implementors

```java
public class GroundType implements MountType {
    @Override
    public String move() {
        return "I can run!";
    }
}
```

```java
public class WaterType implements MountType {
    @Override
    public String move() {
        return "I can swim!";
    }
}
```

```java
public class AirborType implements MountType {
    @Override
    public String move() {
        return "I can fly!";
    }
}
```

> Each class has it's own logic of movement implementation. They don't do something like

```java
case (type) {
    switch "ground":
        System.out.println("I can run!")
    switch "water":
        System.out.println("I can fly!")
    switch "airborn":
        System.out.println("I can swim!")
}
```

> Each of them implements movement in its own way

## Backward-compatible design (adding a new Concrete Implementor requires no change to the Abstraction)

New types can be added easily. For example:

```java
public class TeleportType implements MountType {
    @Override
    public String move() {
        return "I can teleport!";
    }
}
```

Here, I didn't change anything in the abstraction. Since it contains a link to a type in its field, I don't need to change it. I just create an instance of a new type and hand it over to Abstraction when creating an instance of it.