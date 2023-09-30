package Laboratory0;

public class Phone {
    private final String operating_system;
    private final int year;
    private final double size;
    private final String color;

    public Phone(String operating_system, String color, int year, double size) {
        this.operating_system = operating_system;
        this.color = color;
        this.year = year;
        this.size = size;
    }

    public void state() {
        System.out.println("Your phone is from " + year);
        System.out.println("It works on " + operating_system);
        System.out.println("It's screen size is " + size);
        System.out.println("In " + color + " color.");
    }
}
