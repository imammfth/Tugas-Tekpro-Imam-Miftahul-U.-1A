public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println("Cylinder 1:");
        System.out.println(" radius=" + c1.getRadius() + "\n height=" + c1.getHeight() 
            + "\n surface area=" + c1.getArea() + "\n volume=" + c1.getVolume());
        System.out.println(c1.toString() + "\n");

        Cylinder c2 = new Cylinder(10.0);
        System.out.println("Cylinder 2:");
        System.out.println(" radius=" + c2.getRadius() + "\n height=" + c2.getHeight() 
            + "\n surface area=" + c2.getArea() + "\n volume=" + c2.getVolume());
        System.out.println(c2.toString() + "\n");

        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("Cylinder 3:");
        System.out.println(" radius=" + c3.getRadius() + "\n height=" + c3.getHeight() 
            + "\n surface area=" + c3.getArea() + "\n volume=" + c3.getVolume());
        System.out.println(c3.toString());
    }
}