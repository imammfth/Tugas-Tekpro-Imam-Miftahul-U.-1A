public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Shape("blue", false);
        System.out.println(s1.toString());

        Circle c1 = new Circle(5.5, "yellow", true);
        System.out.println(c1.toString());
        System.out.println("Area: " + c1.getArea() + ", Perimeter: " + c1.getPerimeter());

        Rectangle r1 = new Rectangle(2.0, 4.0);
        System.out.println(r1.toString());
        System.out.println("Area: " + r1.getArea());

        Square sq1 = new Square(3.0, "purple", true);
        System.out.println(sq1.toString());
        System.out.println("Area: " + sq1.getArea());
        
        // Test mengubah dimensi Square
        sq1.setWidth(5.0); 
        System.out.println("Setelah diubah: " + sq1.toString() + " Area: " + sq1.getArea());
    }
}
