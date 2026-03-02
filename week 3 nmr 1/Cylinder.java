public class Cylinder extends Circle { 
    private double height; 

    public Cylinder() {
        super(); 
        this.height = 1.0;
    }

    public Cylinder(double height) {
        super(); 
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius); 
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    
    // Modifikasi: Overriding getArea() untuk Luas Permukaan Tabung
    @Override
    public double getArea() {
        // 2π × radius × tinggi + 2 × luas alas
        return (2 * Math.PI * getRadius() * height) + (2 * super.getArea());
    }

    // Modifikasi: Memperbaiki getVolume() dengan memanggil getArea() milik superclass
    public double getVolume() {
        return super.getArea() * height;
    }
    
    // Modifikasi: Overriding toString()
    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString() + " height=" + height;
    }
}