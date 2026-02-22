import id.ac.polban.employee.model.Department;

public class MainTest {
    public static void main(String[] args) {
        // Mengambil blueprint class Department dari dalam file JAR
        Department deptTest = new Department("Public Relation");
        
        System.out.println("Berhasil memanggil departemen: " + deptTest.getDeptName() + " dari file JAR!");
    }
}