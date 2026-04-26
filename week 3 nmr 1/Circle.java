public class Circle { 
    private double radius;
    private String color; // Modifikasi: penambahan variabel color

    // Constructors
    public Circle() { 
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double r) { 
        this.radius = r;
        this.color = "red";
    }
    
    // Modifikasi: Constructor dengan radius dan color
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter and Setter
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + " color=" + color + "]";
    }
}