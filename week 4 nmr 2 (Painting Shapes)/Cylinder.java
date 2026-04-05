public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double r, double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }

    public double area() {
        // Mengikuti rumus yang tertera spesifik pada soal praktikum
        return Math.PI * radius * radius * height; 
    }

    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}