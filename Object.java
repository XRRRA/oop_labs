public class Object {
    private final boolean is_moving;
    private final int speed;
    private final String color;
    public Object(boolean is_moving, int speed, String color){
        this.is_moving = is_moving;
        this.speed = speed;
        this.color = color;
    }
    public void state() {
        System.out.println("The " + color + " car is moving " + is_moving + "with the speed of " + speed);
    }
    public static void main(String[] args){
        Object object = new Object(true, 20, "yellow");
        object.state();
    }
}
