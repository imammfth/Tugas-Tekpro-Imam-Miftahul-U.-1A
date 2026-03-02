public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // --- Contoh pemanggilan metode compare ---
        System.out.println("Perbandingan Gaji:");
        int hasilBanding = staff[0].compare(staff[1]); 
        
        if (hasilBanding == -1) {
            System.out.println("Gaji Antonio lebih kecil dari Maria.");
        } else if (hasilBanding == 1) {
            System.out.println("Gaji Antonio lebih besar dari Maria.");
        } else {
            System.out.println("Gaji Antonio sama dengan Maria.");
        }
        // -----------------------------------------
    }
}